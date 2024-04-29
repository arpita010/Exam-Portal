package com.examportal.controller.user.request;

import com.examportal.data.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  public User toUser() {
    User user = new User();
    user.setEmail(Optional.ofNullable(this.email).orElse(""));
    user.setPassword(Optional.ofNullable(this.password).orElse(""));
    user.setFirstName(Optional.ofNullable(this.firstName).orElse(""));
    user.setLastName(Optional.ofNullable(this.lastName).orElse(""));
    user.setEmail(Optional.ofNullable(this.email).orElse(""));
    user.setPhoneNumber(Optional.ofNullable(this.phoneNumber).orElse(""));
    return user;
  }
}
