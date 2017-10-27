package com.manjula.crud.service.impl;

import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.view.EmployeeView;
import com.manjula.crud.view.RoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manjula on 10/27/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeView user = employeeService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleView role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
