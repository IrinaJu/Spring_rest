package ru.pg.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pg.spring.boot_security.demo.model.Role;
import ru.pg.spring.boot_security.demo.repository.RoleRepository;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> finedAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}

