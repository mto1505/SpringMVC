/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.controller.admin;

import com.mycompany.springmvctest.controller.web.*;
import com.mycompany.springmvctest.service.HomeService;
import com.mycompany.springmvctest.service.impl.NewService;
import static java.util.Collections.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author MinhTo
 */

@Controller(value ="homeControllerAdmin")
public class HomeController {
       @Autowired 
    NewService newService;
    @RequestMapping(value={"/quan-tri/trang-chu"},method = RequestMethod.GET)  
    public ModelAndView homePage()
            {  
                ModelAndView mav=new ModelAndView("/admin/home");
                  //mav.addObject("menu",homeService.loadMenu());
                // String message="<br style=/'text-align:center/'> Hello Web Spring MVC </br>"; 
                 return mav;

            }
   
}
