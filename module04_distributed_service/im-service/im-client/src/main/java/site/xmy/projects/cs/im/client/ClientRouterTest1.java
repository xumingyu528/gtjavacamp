package site.xmy.projects.cs.im.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import site.xmy.projects.cs.im.dto.IMLoginRequest;
import site.xmy.projects.cs.im.dto.IMLoginResponse;
import site.xmy.projects.cs.im.dto.IMServerInfo;
import site.xmy.projects.cs.im.handler.*;

@ChannelHandler.Sharable
public class ClientRouterTest1 {

    private static Logger logger = LoggerFactory.getLogger(ClientRouterTest1.class);
    public static String userid = "1011";
    public static String username = "xmy";
    public static String routerHost = "127.0.0.1";
    private static int routerPort = 9003;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        // 1. 从router层获取IM服务器信息
        IMServerInfo serverInfo = getServerInfo();
        // 2. 调用Router 执行登录
        loginToRoute(serverInfo);
        // 3. 启动netty请求，建立连接，发送消息
        start(userid, username, serverInfo);
    }

    private static IMServerInfo getServerInfo() {
        RestTemplate restTemplate = new RestTemplate();
        IMServerInfo serverInfo = restTemplate.getForObject("http://" + routerHost + ":" + routerPort + "/serverInfo/", IMServerInfo.class);
        return serverInfo;
    }

    private static void loginToRoute(IMServerInfo serverInfo) {
        RestTemplate restTemplate = new RestTemplate();
        IMLoginRequest request = new IMLoginRequest(userid, username, serverInfo.getHost(), serverInfo.getNettyPort(), serverInfo.getHttpPort());
        IMLoginResponse response = restTemplate.postForObject("http://" + routerHost + ":" + routerPort + "/login", request, IMLoginResponse.class);
        logger.info("登录信息: {}", response);
        if (response.success()) {
            logger.info("login success");
        } else {
            logger.info("login failed! cause: {}", response.getMsg());
            System.exit(0);
        }
    }

    private static void start(String userid, String username, IMServerInfo serverInfo) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        channel.pipeline().addLast(new ServerIdleHandler());
                        channel.pipeline().addLast(PacketCodecHandler.getInstance());
                        channel.pipeline().addLast(new ClientIdleHandler());
                        channel.pipeline().addLast(new LoginHandler(userid, username));
                        channel.pipeline().addLast(LoginResponseHandler.getInstance());
                        channel.pipeline().addLast(MessageResponseHandler.getInstance());
                    }
                });
        ChannelFuture future = bootstrap.connect(serverInfo.getHost(), serverInfo.getNettyPort());
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    logger.info("connect to server success !");
                } else {
                    logger.info("failed to connect to server! ");
                    System.exit(0);
                }
            }
        });

        try {
            future.channel().closeFuture().sync();
            logger.info("与服务器断开连接！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
