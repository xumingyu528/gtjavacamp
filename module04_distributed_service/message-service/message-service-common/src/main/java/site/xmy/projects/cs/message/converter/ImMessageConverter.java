package site.xmy.projects.cs.message.converter;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import site.xmy.projects.cs.message.domain.ImMessageDTO;
import site.xmy.projects.cs.message.entity.ImMessage;

import java.util.List;

@Mapper
public interface ImMessageConverter {

    ImMessageConverter INSTANCE = Mappers.getMapper(ImMessageConverter.class);

    //DTO->Entity
    ImMessage convert(ImMessageDTO dto);

    //Entity->DTO
    ImMessageDTO convertDTO(ImMessage entity);
    List<ImMessageDTO> convertDTOs(List<ImMessage> entities);
}