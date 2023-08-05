package com.lab0104.todaybackend.service.impl;

import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.data.repository.UserRepository;
import com.lab0104.todaybackend.service.UserService;
import org.springframework.stereotype.Service;

import com.lab0104.todaybackend.service.EntityAndDtoConversionService;


import javax.transaction.Transactional;
import java.io.Console;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    final private EntityAndDtoConversionService dataConversion;

    public UserServiceImpl(UserRepository userRepository, EntityAndDtoConversionService dataConversion){
        this.userRepository = userRepository;
        this.dataConversion = dataConversion;
    }


    @Override
    public UserDTO.Info findOne(long id) {
        User user = userRepository.getById(id);
        UserDTO.Info findUserDTO = dataConversion.userEntityToDTO(user);

        return findUserDTO;
    }

    @Override
    public UserDTO.Info save(UserDTO.Request userDTO) {
        User user = userRepository.save(dataConversion.userDtoToEntity(userDTO));
        UserDTO.Info saveUserDTO = dataConversion.userEntityToDTO(user);
        return saveUserDTO;
    }

    @Override
    public UserDTO.Info update(long id, UserDTO.Request userDTO) throws Exception {
        User user = dataConversion.userDtoToEntity(userDTO);
        user.setIdForUserUpdate(id);

        UserDTO.Info updateUserDTO = dataConversion.userEntityToDTO(userRepository.save(user));

        return updateUserDTO;
    }

    @Override
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

}
