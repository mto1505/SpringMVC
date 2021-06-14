/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.repository;

import com.mycompany.springmvctest.controller.entity.NewEntity;
import com.mycompany.springmvctest.controller.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 *
 * @author MinhTo
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findOneByUserNameAndStatus(String userName,int status);         
     User findByUserName(String username);
}
