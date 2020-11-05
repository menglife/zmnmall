package com.zmn.gmall.user.service;

import com.zmn.gmall.user.bean.UmsMember;
import com.zmn.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    void addUser(UmsMember umsMember);

    void updateUser(UmsMember umsMember);

    int deleteUser(UmsMember umsMember);

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
