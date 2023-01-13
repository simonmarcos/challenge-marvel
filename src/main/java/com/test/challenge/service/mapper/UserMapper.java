package com.test.challenge.service.mapper;

import com.test.challenge.model.User;
import com.test.challenge.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDTO(User user);

    User dtoToEntity(UserDTO userDTO);
}
