package com.work.service;

import com.work.servlet.Role;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);
}
