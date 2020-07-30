package com.wf.ew.system.controller;


import com.wf.ew.common.DataGridView;
import com.wf.ew.system.To.PageOnePojo;
import com.wf.ew.system.To.pageTwoPojo;
import com.wf.ew.system.model.CoalClik;
import com.wf.ew.system.model.CoalCost;
import com.wf.ew.system.service.CoalClikService;
import com.wf.ew.system.service.CoalCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwt
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/system/coalclik")
public class CoalClikController {
    @Autowired
    private CoalCostService coalCostService;
    @Autowired
    private CoalClikService coalClikService;
    @RequestMapping("pageTwo")
    public pageTwoPojo pageTwo(){

        List<CoalCost> coalCosts = coalCostService.list();
        ArrayList<Date> date = new ArrayList<>();
        ArrayList<String> prodRate = new ArrayList<>();
        for (CoalCost coalCost : coalCosts) {

            date.add(coalCost.getDate());
            prodRate.add(coalCost.getProdRate());
        }
        pageTwoPojo pageTwoPojo = new pageTwoPojo();

        pageTwoPojo.setDate(date);
        pageTwoPojo.setProdRate(prodRate);
        return pageTwoPojo;
    }
    @RequestMapping("pageOne")
    public PageOnePojo pageOne(){
        List<CoalCost> coalCosts = coalCostService.list();
        List<CoalClik> coalCliks = coalClikService.list();
        ArrayList<String> feedNum = new ArrayList<>();
        ArrayList<Date> date = new ArrayList<>();
        ArrayList<Double> coalCost = new ArrayList<>();
        ArrayList<String> prodNum = new ArrayList<>();
        for (CoalClik coalClik : coalCliks) {
            coalCost.add(coalClik.getCoalCost());
        }
        for (CoalCost cost : coalCosts) {
            feedNum.add(cost.getFeedNum());
            date.add(cost.getDate());
            prodNum.add(cost.getProdNum());
        }
        PageOnePojo pageOnePojo = new PageOnePojo();
        pageOnePojo.setFeedNum(feedNum);
        pageOnePojo.setDate(date);
        pageOnePojo.setCoalCost(coalCost);
        pageOnePojo.setProdNum(prodNum);
        return pageOnePojo;

    }


}

