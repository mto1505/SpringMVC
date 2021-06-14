/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.controller.web;

import com.mycompany.springmvctest.controller.entity.NewEntity;
import com.mycompany.springmvctest.repository.NewRepository;
import com.mycompany.springmvctest.service.HomeService;
import com.mycompany.springmvctest.service.impl.NewService;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author MinhTo
 */
@Controller(value ="homeControllerWeb")
public class HomeController {
     @Autowired
    NewRepository repo;
   
    
    @RequestMapping(value={"/trang-chu"},method = RequestMethod.GET)  
    public ModelAndView homePage()
            {  
                ModelAndView mav=new ModelAndView("/web/home");
                   repo.findAll();
                   System.out.println(repo);
                  //mav.addObject("menu",homeService.loadMenu());
                // String message="<br style=/'text-align:center/'> Hello Web Spring MVC </br>"; 
                 return mav;

            }
    @RequestMapping(value = "/dang-nhap", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginPage() {
              
            ModelAndView mav = new ModelAndView("/login");
		return mav;
	}
        @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:https://localhost:8181/SpringMVCTest/dang-nhap?accessDenied");
	}
        @RequestMapping(value = "/thoat",method = RequestMethod.GET)
        public ModelAndView logoutPage(HttpServletRequest request,HttpServletResponse response)
                {
                    Authentication auth=SecurityContextHolder.getContext().getAuthentication();
                    if(auth!=null){
                       new SecurityContextLogoutHandler().logout(request, response, auth);
                    }
                    ModelAndView mav = new ModelAndView("redirect:https://localhost:8181/SpringMVCTest/trang-chu");
		return mav;
                }
    
}
