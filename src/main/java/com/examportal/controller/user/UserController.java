package com.examportal.controller.user;

import com.examportal.controller.user.request.UserCreateRequest;
import com.examportal.controller.user.request.UserUpdateRequest;
import com.examportal.controller.user.response.UserCreateResponse;
import com.examportal.controller.user.response.UserUpdateResponse;
import com.examportal.data.BaseResponse;
import com.examportal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

  private UserService userService;

  @Autowired
  UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public UserCreateResponse create(@RequestBody UserCreateRequest userCreateRequest)
      throws Exception {
    return userService.create(userCreateRequest);
  }

  @PostMapping("/update")
  public UserUpdateResponse update(@RequestBody UserUpdateRequest userUpdateRequest)
      throws Exception {
    return userService.update(userUpdateRequest);
  }

  @DeleteMapping("/delete/{id}")
  public BaseResponse deleteById(@PathVariable(value = "id") Long id) throws Exception {
    return userService.deleteById(id);
  }
}
