package ru.pg.spring.boot_security.demo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pg.spring.boot_security.demo.model.Role;
import ru.pg.spring.boot_security.demo.service.RoleService;


import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleRestController {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.finedAllRoles();
    }
}

