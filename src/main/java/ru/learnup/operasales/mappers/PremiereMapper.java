package ru.learnup.operasales.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.learnup.operasales.dto.PremiereDto;
import ru.learnup.operasales.model.Premiere;

@Mapper(componentModel = "spring")
@Component
public interface PremiereMapper {

    PremiereDto toDto(Premiere premiere);
    Premiere toEntity(PremiereDto premiereDto);

}