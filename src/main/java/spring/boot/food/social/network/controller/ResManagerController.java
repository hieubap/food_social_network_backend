package spring.boot.food.social.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.config.dto.UsernameAndPasswordDTO;
import spring.boot.core.controller.BaseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.food.social.network.dto.ResManagerDTO;
import spring.boot.food.social.network.dto.UserDTO;
import spring.boot.food.social.network.service.ResManagerService;

@RequestMapping("/res-manager")
@RestController
@CrossOrigin
public class ResManagerController extends BaseController<ResManagerDTO, ResManagerService> {
    @Autowired
    private ResManagerService resManagerService;

    @Override
    public ResManagerService getService() {
        return resManagerService;
    }

    @PostMapping("/register")
    public ResponseDTO register(@RequestBody ResManagerDTO resManagerDTO) {
        return response(getService().register(resManagerDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestBody UsernameAndPasswordDTO usernameAndPasswordDTO) {
        return response(getService().login(usernameAndPasswordDTO));
    }
}

