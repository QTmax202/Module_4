package com.example.spring_srcurity.service.role;

import com.example.spring_srcurity.model.Role;
import com.example.spring_srcurity.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
