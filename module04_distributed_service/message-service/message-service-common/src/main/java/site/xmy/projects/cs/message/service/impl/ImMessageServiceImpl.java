package site.xmy.projects.cs.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.xmy.projects.cs.message.entity.ImBusinessType;
import site.xmy.projects.cs.message.entity.ImMessage;
import site.xmy.projects.cs.message.mapper.ImBusinessTypeMapper;
import site.xmy.projects.cs.message.mapper.ImMessageMapper;
import site.xmy.projects.cs.message.service.ImMessageService;

import java.sql.SQLException;
import java.util.List;

@Service
public class ImMessageServiceImpl implements ImMessageService {

    @Autowired
    private ImMessageMapper imMessageMapper;

    @Autowired
    private ImBusinessTypeMapper imBusinessTypeMapper;

    @Override
    public void saveImMessage(ImMessage imMessage) throws SQLException {
        imMessageMapper.addImMessage(imMessage);
    }

    @Override
    public List<ImMessage> findImMessages() throws SQLException {
        List<ImMessage> messages = imMessageMapper.findImMessages();

        return fillImMessagesWithBusinessType(messages);
    }

    @Override
    public List<ImMessage> findImMessagesByUserId(Long toUserId) throws SQLException {
        List<ImMessage> messages = imMessageMapper.findImMessagesByUser(toUserId);

        return fillImMessagesWithBusinessType(messages);
    }

    private List<ImMessage> fillImMessagesWithBusinessType(List<ImMessage> messages) {
        for (ImMessage message : messages) {
            ImBusinessType businessType = imBusinessTypeMapper.findBusinessTypeByCode(message.getBusinessTypeCode());
            message.setBusinessTypeName(businessType.getBusinessTypeName());
        }

        return messages;
    }
}
