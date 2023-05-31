package ru.pg.spring.boot_security.demo.config;

import org.springframework.stereotype.Component;
import ru.pg.spring.boot_security.demo.model.Role;
import ru.pg.spring.boot_security.demo.model.User;
import ru.pg.spring.boot_security.demo.service.RoleService;
import ru.pg.spring.boot_security.demo.service.UserService;


import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitB {

    private final UserService userService;
    private final RoleService roleService;

    public InitB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void defaultDbValue() {

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        if (roleService.findRoleByName(roleUser.getName()) == null) {
            roleService.saveRole(roleUser);
        }

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        if (roleService.findRoleByName(roleAdmin.getName()) == null) {
            roleService.saveRole(roleAdmin);
        }

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setAge(35);
        admin.setEmail("admin@mail.ru");
        admin.setPassword("admin");
        admin.setRoles(Set.of(roleAdmin, roleUser));
        if (userService.findUserByEmail(admin.getEmail()) == null) {
            userService.saveUser(admin);
        }

        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setAge(30);
        user.setEmail("user@mail.ru");
        user.setPassword("user");
        user.setRoles(Set.of(roleUser));
        if (userService.findUserByEmail(user.getEmail()) == null) {
            userService.saveUser(user);
        }
    }
}

