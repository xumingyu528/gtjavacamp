package site.xmy.projects.cs.message.service;

import site.xmy.projects.cs.message.domain.ImMessageDTO;

import java.util.List;

public interface ImMessageManagementService {

    Long saveImMessage(ImMessageDTO imMessageDTO);

    List<ImMessageDTO> findImMessages();

    List<ImMessageDTO> findImMessagesByUserId(Long userId);
}
