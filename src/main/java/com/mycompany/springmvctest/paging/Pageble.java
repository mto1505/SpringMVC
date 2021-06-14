/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvctest.paging;
//import com.mycompany.web_demo_full.sort.Sorter;
/**
 *
 * @author MinhTo
 */
public interface Pageble {
    	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	//Sorter getSorter();
}
