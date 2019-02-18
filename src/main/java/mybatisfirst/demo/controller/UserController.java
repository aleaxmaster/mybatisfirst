package mybatisfirst.demo.controller;

import mybatisfirst.demo.dao.UserMapper;
import mybatisfirst.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8888/getUser?username=xiaoli2
    @RequestMapping("/getUser")
    @ResponseBody
    public Object getUser(@Param("username") String username, @Param("id") int id , @RequestHeader("User-Agent") String user_Agent){
        User user =userMapper.findUserByUsername(username,id);
        Map map=new HashMap();
        map.put("userinfo",user);
        map.put("agent",user_Agent);
        return map;
       // return user!=null ? username+"的密码是："+user.getUser_password():"不存在用户名为"+username+"的用户";
    }

    //http://localhost:8888/updateUser?username=xiaoli2&password=123
    @RequestMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }


    //http://localhost:8888/addUser?username=xiaoli2&password=123
    @RequestMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.saveUser(user);
        return "success!";
    }

    //http://localhost:8888/addUser?username=xiaoli2
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    //http://localhost:8888/getUserList
    @RequestMapping("/getUserList")
    public List getUserList(String username, String password){
        return userMapper.getUserList();
    }
}
