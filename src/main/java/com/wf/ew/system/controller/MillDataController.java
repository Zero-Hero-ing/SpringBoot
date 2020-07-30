package com.wf.ew.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wf.ew.common.DataGridView;
import com.wf.ew.system.To.MillElePojo;
import com.wf.ew.system.Vo.millVo;
import com.wf.ew.system.model.MillData;
import com.wf.ew.system.service.MillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwt
 * @since 2020-04-01
 */
@RestController
@RequestMapping("/system/mill")
public class MillDataController {
    @Autowired
    private MillDataService millDataService;
    @RequestMapping("list")
    public DataGridView listmill(millVo millVo){
        Page<MillData> page = new Page<>(millVo.getPage(),millVo.getLimit());
        QueryWrapper<MillData> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(millVo.getStartTime()!=null,"date",millVo.getStartTime());
        queryWrapper.le(millVo.getEndTime()!=null,"date",millVo.getEndTime());
        this.millDataService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @RequestMapping("pageOne")
    public MillElePojo pageEle(){
        List<MillData> list = millDataService.list();
        ArrayList<Date> date = new ArrayList<>();
        ArrayList<Long> ele = new ArrayList<>();
        for (MillData millData : list) {
            date.add(millData.getDate());
            ele.add(millData.getEleValue());

        }
        MillElePojo millElePojo = new MillElePojo();
        millElePojo.setDate(date);
        millElePojo.setEleValue(ele);
        return millElePojo;
    }
}

