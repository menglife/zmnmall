package com.zmn.gmall.user.controller;

import com.zmn.gmall.user.bean.UmsMember;
import com.zmn.gmall.user.bean.UmsMemberReceiveAddress;
import com.zmn.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;//IDEA误报错setting中设置一下warning
    @RequestMapping("/user")
    @ResponseBody
    public String user(){
        return "Hello User";
    }
    //查看
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers=userService.getAllUser(); //alt+回车
        return umsMembers;

    }
    //添加
    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(){
        UmsMember umsMember1=new UmsMember();
        umsMember1.setCity("凌城");
        userService.addUser(umsMember1);
    }
    //更新
    @RequestMapping("updateUser")
    @ResponseBody
    public void updateUser(){
        UmsMember umsMember=new UmsMember();
        umsMember.setCity("zmn");
        umsMember.setId("12");

        userService.updateUser(umsMember);
    }
    //删除
    @RequestMapping("deleteUser")
    @ResponseBody
    public int deleteUser(){
        UmsMember umsMember=new UmsMember();
        umsMember.setId("13");
        return userService.deleteUser(umsMember);

    }
    //根据member的Id去查找member的所有的收货地址
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        System.out.println(memberId);

        List<UmsMemberReceiveAddress>  umsMemberReceiveAddresses= userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
}
