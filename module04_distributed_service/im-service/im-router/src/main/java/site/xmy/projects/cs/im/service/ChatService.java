package site.xmy.projects.cs.im.service;

import site.xmy.projects.cs.im.dto.ChatResponse;
import site.xmy.projects.cs.im.dto.P2PChatRequest;

public interface ChatService {
    ChatResponse p2pChat(P2PChatRequest request);
}
