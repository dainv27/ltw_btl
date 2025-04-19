package com.dainv.ptit.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRegisterInfo extends UserLoginInfo {
    private String verifyPassword;
    private String fullName;
    private Boolean isAgreedTnc;
}
