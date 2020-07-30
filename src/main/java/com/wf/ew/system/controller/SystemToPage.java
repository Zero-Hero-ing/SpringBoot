package com.wf.ew.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.ew.common.DataGridView;
import com.wf.ew.system.model.CoalClik;
import com.wf.ew.system.model.CoalCost;
import com.wf.ew.system.service.CoalClikService;
import com.wf.ew.system.service.CoalCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/3/13 15:50
 */

@RequestMapping("system")
@Controller
public class SystemToPage {
     @Autowired
    private CoalCostService coalCostService;
    @Autowired
    private CoalClikService coalClikService;
    @RequestMapping("coalcost")
    public String toCoalCostPage(ModelMap model) {

        List<CoalClik> coalClikList = this.coalClikService.list();
        List<Double> coalcost = new ArrayList<>();
        for (CoalClik coalClik : coalClikList) {
            coalcost.add(coalClik.getCoalCost());
        }
        Double sum = sum(coalcost)/coalcost.size();
        double result = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<CoalCost> coalCostList = this.coalCostService.list();
        List<Double> prodnum= new ArrayList<>();
        for (CoalCost coalCost : coalCostList) {
            if (coalCost.getProdNum()==null){
                coalCost.setProdNum("0.00");
            }
            prodnum.add(Double.parseDouble(coalCost.getProdNum()));
        }
        double res2 = sum(prodnum) / prodnum.size() * 7;
        double pro_res = new BigDecimal(res2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        model.addAttribute("avgcost",result);
        model.addAttribute("prodNum",pro_res);
        model.addAttribute("prodRate","89.95");
        model.addAttribute("feedNum","60175.66");

        return "system/coalCostPage.html";
    }

    @RequestMapping("coalList")
    public String toCoalCostlistPage(){
        return "system/coalCostList.html";
    }

    @RequestMapping("monitor")
    public String tomonitorPage(){
        return "system/monitorList.html";
    }

    @RequestMapping("mill")
    public String tomillPage(){
        return "system/millList.html";
    }

    @RequestMapping("mine")
    public String tominePage(){
        return "system/mineList.html";
    }
    @RequestMapping("powerMec")
    public String topowerMecPage(){
        return "system/eleMecList.html";
    }

    public Double sum(List<Double> doulist){
        Double sum=0.00;
        for (Double aDouble : doulist) {
            if (aDouble==null){
                aDouble=0.00;
            }
            sum+=aDouble;
        }

        return sum;
    }

}
