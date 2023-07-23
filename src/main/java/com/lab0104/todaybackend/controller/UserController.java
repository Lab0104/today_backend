package com.lab0104.todaybackend.controller;

import com.lab0104.todaybackend.data.dto.UserDTO;
import com.lab0104.todaybackend.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/v1/user")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "사용자 조회", notes = "해당 id를 가지는 사용자를 조회.")
    @ApiImplicitParam(name = "id", value = "사용자 생성 시 자동으로 발급되는 id")
    public ResponseEntity<UserDTO.Info> getUser(@PathVariable Long id){
        UserDTO.Info getUserDTO = userService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(getUserDTO);
    }

    @PostMapping
    @ApiOperation(value = "사용자 생성", notes = "사용자의 정보를 입력하여 새로운 사용자를 생성합니다.")
    public ResponseEntity<UserDTO.Info> createUser(@RequestBody UserDTO.Request userDTO) {
        UserDTO.Info createUserDTO = userService.save(userDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createUserDTO);
    }

    @PutMapping
    @ApiOperation(value = "사용자 정보 수정", notes = "id와 사용자 정보를 입력받아 해당 id의 사용자 정보를 수정합니다.")
    @ApiImplicitParam(name = "id", value = "사용자 생성 시 발급되는 id")
    public ResponseEntity<UserDTO.Info> changeUser(@PathVariable long id, @RequestBody UserDTO.Request userDTO) throws Exception{
        userService.update(id, userDTO);
        UserDTO.Info changeUserDTO = userService.findOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(changeUserDTO);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "사용자 삭제", notes = "해당 id를 가지는 사용자를 삭제합니다.")
    @ApiImplicitParam(name = "id", value = "사용자 생성 시 발급되는 id")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
