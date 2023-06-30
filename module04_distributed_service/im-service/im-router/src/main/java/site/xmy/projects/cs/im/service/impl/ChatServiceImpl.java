package site.xmy.projects.cs.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import site.xmy.projects.cs.im.dto.ChatResponse;
import site.xmy.projects.cs.im.dto.IMLoginRequest;
import site.xmy.projects.cs.im.dto.P2PChatRequest;
import site.xmy.projects.cs.im.service.ChatService;
import site.xmy.projects.cs.im.service.LoginService;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    LoginService loginService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ChatResponse p2pChat(P2PChatRequest request) {
        IMLoginRequest loginRequest = loginService.getLoginInfo(request.getToUserId());

        ChatResponse response = restTemplate.postForObject("http://" + loginRequest.getServerHost() + ":" + loginRequest.getHttpPort() + "/chat/chat",
                request, ChatResponse.class);

        return response;
    }
}
