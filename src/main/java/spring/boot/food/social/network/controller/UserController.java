package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.controller.BaseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.service.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController extends BaseController<UserDTO, UserService> {
    @Autowired
    private UserService userService;

    @Override
    public UserService getService() {
        return userService;
    }


    @PostMapping("/register")
    public ResponseDTO register(@RequestBody UserDTO userDTO) {
        return response(getService().register(userDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody UsernameAndPasswordDTO usernameAndPasswordDTO) {
        return response(getService().login(usernameAndPasswordDTO));
    }
}

