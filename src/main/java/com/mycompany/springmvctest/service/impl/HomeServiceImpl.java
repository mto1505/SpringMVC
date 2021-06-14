/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.service.impl;

import com.mycompany.springmvctest.service.HomeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author MinhTo
 */
@Service
public class HomeServiceImpl implements HomeService{
    
    @Override
    public List<String> loadMenu()
    {   
        List<String> menu=new ArrayList<>();
        menu.add("Blog");
        menu.add("Liên hệ");
        menu.add("Thanh Toán");
        return menu;
    }
}
