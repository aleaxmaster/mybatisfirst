package mybatisfirst.demo.dao;

import mybatisfirst.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByUsername(String name,int id);
    void updateUserByUsername(User user);
    void deleteUserByUsername(String username);
    void saveUser(User user);
    List<User> getUserList();
}
