package lecture.spring_boot_Mybatis.service;


import lecture.spring_boot_Mybatis.domain.User;
import lecture.spring_boot_Mybatis.dto.UserDTO;
import lecture.spring_boot_Mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getUserList() {
        List<User> result = userMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<>();

        for(int i = 0; i<result.size(); i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(result.get(i).getId());
            userDTO.setName(result.get(i).getName());
            userDTO.setNickname(result.get(i).getNickname());
            userDTO.setNo(i+1);

            users.add(userDTO);
        }

        return users;
    }
}