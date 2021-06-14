/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.controller.admin;

import com.mycompany.springmvctest.controller.web.*;
import com.mycompany.springmvctest.model.NewModel;
import com.mycompany.springmvctest.service.HomeService;
import com.mycompany.springmvctest.service.INewService;
import com.mycompany.springmvctest.service.impl.NewService;
import static java.util.Collections.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author MinhTo
 */
@Controller(value ="homeControllerAdminNew")
public class NewController {
    
      @Autowired 
    NewService newService;
    
    @RequestMapping(value={"/quan-tri/bai-viet/danh-sach"},method = RequestMethod.GET)  
    public ModelAndView showList()
            {   
                ModelAndView mav=new ModelAndView("/admin/new/list");
                 
                // String message="<br style=/'text-align:center/'> Hello Web Spring MVC </br>"; 
                 return mav;

            }
     
    @RequestMapping(value={"/quan-tri/bai-viet/chinh-sua"},method = RequestMethod.GET)  
    public ModelAndView editList()
            {  
                ModelAndView mav=new ModelAndView("/admin/new/edit");
                  //mav.addObject("menu",homeService.loadMenu());
                // String message="<br style=/'text-align:center/'> Hello Web Spring MVC </br>"; 
                 return mav;

            }
   
}
