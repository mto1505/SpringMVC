/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.repository;

import com.mycompany.springmvctest.controller.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 *
 * @author MinhTo
 */
public interface NewRepository extends JpaRepository<NewEntity,Long>{
    
}
