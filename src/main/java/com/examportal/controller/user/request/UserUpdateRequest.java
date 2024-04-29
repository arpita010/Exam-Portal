package com.examportal.controller.user.request;

import com.examportal.data.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
  private Long id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String phoneNumber;

  public User toUser(User user) {
    user.setId(id);
    if (null != this.email) user.setEmail(this.email);
    if (null != this.password) user.setPassword(this.password);
    if (null != this.firstName) user.setFirstName(this.firstName);
    if (null != this.lastName) user.setLastName(this.lastName);
    if (null != this.phoneNumber) user.setPhoneNumber(this.phoneNumber);

    return user;
  }
}
