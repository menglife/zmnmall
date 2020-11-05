package com.zmn.gmall.user.service.impl;

import com.zmn.gmall.user.bean.UmsMember;
import com.zmn.gmall.user.bean.UmsMemberReceiveAddress;
import com.zmn.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.zmn.gmall.user.mapper.UserMapper;
import com.zmn.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMember= userMapper.selectAll();
        return umsMember;
    }

    @Override
    public void addUser(UmsMember umsMember) {
        userMapper.insertSelective(umsMember);
    }

    @Override
    public void updateUser(UmsMember umsMember) {
        userMapper.updateByPrimaryKey(umsMember);
    }

    @Override
    public int deleteUser(UmsMember umsMember) {
        return  userMapper.delete(umsMember);

    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        return umsMemberReceiveAddresses;
    }


}
