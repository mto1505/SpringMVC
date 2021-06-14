package com.mycompany.springmvctest.service.impl;

import com.mycompany.springmvctest.controller.entity.NewEntity;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.mycompany.springmvctest.dao.ICategoryDAO;
import com.mycompany.springmvctest.dao.INewDAO;
import com.mycompany.springmvctest.dao.impl.CategoryDAO;
import com.mycompany.springmvctest.dao.impl.NewDAO;
import com.mycompany.springmvctest.model.CategoryModel;
import com.mycompany.springmvctest.model.NewModel;
import com.mycompany.springmvctest.paging.Pageble;
import com.mycompany.springmvctest.repository.NewRepository;
//import com.mycompany.web_demo_full.paging.Pageble;
import com.mycompany.springmvctest.service.INewService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.laptrinhjavaweb.utils.SessionUtil;

@Service
@Transactional
public class NewService {

    @Autowired
    NewRepository repo;
    
   
    public List<NewEntity> listAll() {
        return (List<NewEntity>) repo.findAll();
    }
     
  
}
