package com.lab0104.todaybackend.service;

import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.dto.UserDTO;

public interface UserService {
    UserDTO.Info findOne(long id);

    UserDTO.Info save(UserDTO.Request userDTO);

    UserDTO.Info update(long id, UserDTO.Request userDTO) throws  Exception;

    void delete(Long id) throws Exception;


}