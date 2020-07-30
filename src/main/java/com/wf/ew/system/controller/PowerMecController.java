package com.wf.ew.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wf.ew.common.DataGridView;
import com.wf.ew.system.To.MecPowerPojo;
import com.wf.ew.system.Vo.eleMecVo;
import com.wf.ew.system.model.PowerMec;
import com.wf.ew.system.service.PowerMecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwt
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/system/powerMec")
public class PowerMecController {
    @Autowired
    private PowerMecService powerMecService;
    @RequestMapping("list")
    public DataGridView getMecList(eleMecVo eleMecVo){
        Page<PowerMec> page = new Page<>(eleMecVo.getPage(),eleMecVo.getLimit());

        QueryWrapper<PowerMec> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge( eleMecVo.getStartTime()!=null,"date", eleMecVo.getStartTime());
        queryWrapper.le( eleMecVo.getEndTime()!=null,"date", eleMecVo.getEndTime());
        this.powerMecService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());

    }
    @RequestMapping("pageOne")
    public MecPowerPojo pageMecPower(){
        List<PowerMec> list = this.powerMecService.list();
        ArrayList<Date> date = new ArrayList<>();
        ArrayList<Long> aProd=new ArrayList<>();
        ArrayList<Long> bProd=new ArrayList<>();
        for (PowerMec powerMec : list) {
            date.add(powerMec.getDate());
            aProd.add(powerMec.getAProd());
            bProd.add(powerMec.getBProd());
        }
        MecPowerPojo mecPowerPojo = new MecPowerPojo();
        mecPowerPojo.setDate(date);
        mecPowerPojo.setAProd(aProd);
        mecPowerPojo.setBProd(bProd);
        return mecPowerPojo;
    }

}

