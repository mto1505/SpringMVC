/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.service.impl;

import com.mycompany.springmvctest.constant.SystemConstant;
import com.mycompany.springmvctest.controller.entity.Role;
import com.mycompany.springmvctest.controller.entity.User;
import com.mycompany.springmvctest.dto.MyUser;
import com.mycompany.springmvctest.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MinhTo
 */
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService{ //here AuthencitionProvider Mapping
    
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user=userRepository.findByUserName(username);
        User user=userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
       
    // User user2=userRepository.findByUserName(username);
               if(user==null)
            {
                throw new UsernameNotFoundException("User not found");
            }
        
        //
        List<GrantedAuthority> authorities=new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode())); //SimpleGrantedAuthority implements 
        }
        MyUser myUser=new MyUser(user.getUsername(),user.getPassword(),true,true,true,true,authorities);
        myUser.setFullName(user.getFullname());
        return myUser;
    }

    
}
