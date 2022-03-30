package com.example.spring_srcurity.service.role;


import com.example.spring_srcurity.model.Role;
import com.example.spring_srcurity.service.IGeneralService;

import java.util.Set;

public interface IRoleService extends IGeneralService<Role> {
    Set<Role> findByName(String name);
}
