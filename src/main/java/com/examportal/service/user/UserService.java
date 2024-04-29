package com.examportal.service.user;

import com.examportal.controller.user.request.UserCreateRequest;
import com.examportal.controller.user.request.UserUpdateRequest;
import com.examportal.controller.user.response.UserCreateResponse;
import com.examportal.controller.user.response.UserUpdateResponse;
import com.examportal.data.BaseResponse;
import com.examportal.data.entities.User;
import com.examportal.data.enums.ResponseStatus;
import com.examportal.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class UserService {
  private UserRepo userRepo;

  @Autowired
  UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public UserCreateResponse create(UserCreateRequest userCreateRequest) throws Exception {
    Optional<User> byUsername = findByUsername(userCreateRequest.getUsername());
    if (byUsername.isPresent())
      throw new HttpClientErrorException(
          HttpStatus.BAD_REQUEST,
          "Username already exists in the system. Try with something different");
    User user = userCreateRequest.toUser();
    User savedUser = userRepo.save(user);
    return new UserCreateResponse(savedUser);
  }

  public UserUpdateResponse update(UserUpdateRequest userUpdateRequest) throws Exception {
    Optional<User> opt = findById(userUpdateRequest.getId());
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid user id");
    User user = opt.get();
    User updatedUser = userRepo.save(userUpdateRequest.toUser(user));
    return new UserUpdateResponse(updatedUser);
  }

  public Optional<User> findByUsername(String username) {
    return userRepo.findByUsername(username);
  }

  public Optional<User> findById(Long id) {
    return userRepo.findById(id);
  }

  public BaseResponse deleteById(Long id) throws Exception {
    Optional<User> opt = findById(id);
    if (opt.isEmpty())
      throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid User Id");
    userRepo.delete(opt.get());
    return new BaseResponse(ResponseStatus.OKAY);
  }
}
