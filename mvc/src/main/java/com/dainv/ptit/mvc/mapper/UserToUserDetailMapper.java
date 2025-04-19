package com.dainv.ptit.mvc.mapper;

import com.dainv.ptit.mvc.entity.User;
import com.dainv.ptit.mvc.model.UserDetailSec;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserToUserDetailMapper {
    UserDetailSec toUserDetails(User user);
}
