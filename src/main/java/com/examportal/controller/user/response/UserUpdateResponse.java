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
public class UserUpdateResponse extends BaseResponse {
  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String username;
  private String phoneNumber;

  public UserUpdateResponse(User user) {
    super(ResponseStatus.OKAY);
    this.id = user.getId();
    this.email = user.getEmail();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.username = user.getUsername();
    this.phoneNumber = user.getPhoneNumber();
  }
}
