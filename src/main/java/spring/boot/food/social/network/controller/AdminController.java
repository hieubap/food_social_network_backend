package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.controller.BaseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.food.social.network.dto.AdminDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.service.AdminService;

@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController extends BaseController<AdminDTO, AdminService> {
    @Autowired
    private AdminService adminService;

    @Override
    public AdminService getService() {
        return adminService;
    }

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody AdminDTO userDTO) {
        return response(getService().register(userDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody UsernameAndPasswordDTO usernameAndPasswordDTO) {
        return response(getService().login(usernameAndPasswordDTO));
    }
}
