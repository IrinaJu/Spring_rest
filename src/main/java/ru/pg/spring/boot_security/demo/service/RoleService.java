package ru.pg.spring.boot_security.demo.service;


import ru.pg.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> finedAllRoles();

    void saveRole(Role role);

    Role findRoleByName(String roleName);
}

