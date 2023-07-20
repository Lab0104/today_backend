package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ApiOperation(value = "")
    public ResponseEntity<UserDTO.Info> createUser(@RequestBody UserDTO.Request userDTO) {
        UserDTO.Info createUserDTO = userService.save(userDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createUserDTO);
    }


    @GetMapping
    @ApiOperation(value = "")
    public ResponseEntity<UserDTO.Info> getUser(Long id){
        UserDTO.Info getUserDTO = userService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getUserDTO);
    }


    @PutMapping
    @ApiOperation(value ="")
    public ResponseEntity<UserDTO.Info>changeUser(long id, @RequestBody UserDTO.Request userDTO) throws Exception{
        userService.update(id, userDTO);
        UserDTO.Info changeUserDTO = userService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(changeUserDTO);
    }


    @DeleteMapping
    @ApiOperation(value = "category 삭제", notes = "id 값으로 삭제")
    public ResponseEntity<String> deleteUser(Long id) throws Exception {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
