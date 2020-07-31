package de.quirmbach.jp.mapstructdemo.mapper;

import de.quirmbach.jp.mapstructdemo.dto.PersonDto;
import de.quirmbach.jp.mapstructdemo.entity.PersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    @Mapping(target = "id", source = "personId")
    @Mapping(target = "lastName", source = "surName")
    PersonEntity convertToPersonEntity(PersonDto dto);

    @InheritInverseConfiguration
    PersonDto convertToPersonDto(PersonEntity entity);

}
