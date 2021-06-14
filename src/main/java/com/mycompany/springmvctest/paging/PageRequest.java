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
public class PageRequest implements Pageble {
        private  Integer page;
	private Integer maxPageItem;
	//private Sorter sorter;

  /*  public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
        this.page = page;
        this.maxPageItem = maxPageItem;
        this.sorter = sorter;
    }*/

    @Override
    public Integer getPage() {
      return page;
    }

    @Override
    public Integer getOffset() {
        if(page!=null&&maxPageItem!=null)
        {
        return (page-1)*maxPageItem;
        }
        else
            return null;
    }

    @Override
    public Integer getLimit() {
      return maxPageItem;
    }

    
    /*public Sorter getSorter() {
        return sorter;
    }*/
}
