package lecture.spring_boot_Mybatis.controller;


import lecture.spring_boot_Mybatis.dto.UserCreateDTO;
import lecture.spring_boot_Mybatis.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getUserList();
    }

    @PostMapping("")
    @ResponseBody
    // Map은 userdto의 json을 간단하게 return하기 위해서
    public Map<String, Boolean> insertUser(
            @RequestBody UserCreateDTO user
    ) {
        // User insert 로직
        userService.insertUser(user);

        Map<String, Boolean> result = new HashMap<String, Boolean>();
        result.put("result", true);
        // {result: true}
        return result;
    }
    @PatchMapping("/{id}")
    @ResponseBody
    public Map<String, Boolean> patchUser(
            @PathVariable int id,
            @RequestBody UserCreateDTO user) { // modelAttribute
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        try{
            userService.updateUser(id, user);
            result.put("result", true);
        }
        catch (Exception e) {
            result.put("result", false);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Map<String, Boolean> deleteUser(
            @PathVariable int id,
            @RequestBody UserCreateDTO user
    ) {
        Map<String, Boolean> result = new HashMap<>();
        try{
            // userService.updateUser(id, user);
            userService.deleteUser(id, user);
            result.put("result", true);
        }
        catch (Exception e) {

            result.put("result", false);
        }
        return result;
    }
}
