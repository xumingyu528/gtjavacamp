package site.xmy.projects.cs.message.service;

import site.xmy.projects.cs.message.entity.ImMessage;

import java.sql.SQLException;
import java.util.List;

public interface ImMessageService {

    void saveImMessage(ImMessage imMessage) throws SQLException;

    List<ImMessage> findImMessages() throws SQLException ;

    List<ImMessage> findImMessagesByUserId(Long toUserId) throws SQLException ;
}
