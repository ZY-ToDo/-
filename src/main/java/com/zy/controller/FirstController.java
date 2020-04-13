package com.zy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zy.domain.PageBean;
import com.zy.domain.User;
import com.zy.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class FirstController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/say",produces="text/plain;charset=UTF-8")
    public String say(){
        return "forward:/index.jsp  瘦肉片和送帝国";
    }

    @RequestMapping(value="/eat",produces = {"application/json;charset=UTF-8"})
    public String eat(){
        return "老子最牛逼";
    }

    @RequestMapping(value="/play")
    public String play(){
//        user u1 = new user("张子翔",888);

//        JSONObject json = JSONObject.fromObject(u1);
//        String str = json.toString();
        // ObjectMapper ob = new ObjectMapper();
        //String uu = ob.writeValueAsString(u);
        return "a";
    }

    @RequestMapping("/findAll")
    public List<User> findUser(Model model){
        List<User> userlist = userService.findUser();

        System.out.println(userlist.toString());

        return userlist;
//        model.addAttribute("userlist",userlist);
//        return "forward:/user.jsp";

    }

    @RequestMapping("/jspAll")
    public String findJsp(Model model){
        List<User> userlist = userService.findUser();

        System.out.println(userlist.toString());

        model.addAttribute("userlist",userlist);


        return "forward:/user.jsp";

    }
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int id){
        System.out.println("进入删除 id为："+id);
        userService.delete(id);
        return "redirect:/users.html";
    }

    @RequestMapping("/byPage")
    public String findByPage(@RequestParam(defaultValue = "1")Integer currentPage,
                             @RequestParam(defaultValue = "5")Integer pageSize,Model model){
        PageBean<User> pageBean = userService.findUserByPage(currentPage, pageSize);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("pageSize",pageSize);
        System.out.println(pageBean.toString());
        return "forward:/user2.jsp";

    }


    @ResponseBody
    @RequestMapping("/byJson")
    public PageBean<User> findJson(@RequestParam(defaultValue = "1")Integer currentPage,
                             @RequestParam(defaultValue = "5")Integer pageSize){
        PageBean<User> pageBean = userService.findUserByPage(currentPage, pageSize);

        System.out.println(pageBean.toString());

        return pageBean;

    }





}
