package site.xmy.projects.cs.im.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.xmy.projects.cs.im.dto.ChatResponse;
import site.xmy.projects.cs.im.dto.P2PChatRequest;
import site.xmy.projects.cs.im.service.ChatService;
import site.xmy.projects.cs.im.service.LoginService;

@RestController
@RequestMapping("/p2p")
public class P2PChatController {
    private static Logger logger = LoggerFactory.getLogger(P2PChatController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ChatService chatService;


    @PostMapping("/chat")
    public ChatResponse p2pChat(@RequestBody P2PChatRequest request){
        ChatResponse response = new ChatResponse();
        if (loginService.isLogin(request.getFromUserId())){
            response.setCode("3001");
            response.setMsg("please login!");
        }


        if (loginService.isLogin(request.getToUserId())){
            response.setCode("3002");
            response.setMsg(request.getToUserId()+" not online!");
        }

        chatService.p2pChat(request);

        return response;
    }


}
