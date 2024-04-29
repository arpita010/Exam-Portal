package com.examportal.controller.user.response;

import com.examportal.data.BaseResponse;
import com.examportal.data.entities.User;
import com.examportal.data.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse extends BaseResponse {
  private Long userId;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;

  public UserCreateResponse(User user) {
    super(ResponseStatus.OKAY);
    this.email = user.getEmail();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.userId = user.getId();
    this.username = user.getUsername();
    this.phoneNumber = user.getPhoneNumber();
  }
}
