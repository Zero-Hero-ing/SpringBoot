package com.wf.ew.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wf.ew.common.DataGridView;
import com.wf.ew.common.JsonResult;
import com.wf.ew.common.PageParam;
import com.wf.ew.common.PageResult;
import com.wf.ew.system.Vo.CoalCostListVo;
import com.wf.ew.system.model.CoalCost;
import com.wf.ew.system.model.Role;
import com.wf.ew.system.service.CoalCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zwt
 * @since 2020-03-08
 */
@RestController
@RequestMapping("system/coal")
public class CoalCostController {

    @Autowired
    private CoalCostService coalCostService;

//    public PageResult<CoalCost> coalCostList(HttpServletRequest request) throws ParseException {
//        PageParam pageParam = new PageParam(request);
//        QueryWrapper<CoalCost> queryWrapper = new QueryWrapper<>();
//        String startDate = pageParam.getString("startDate");
//        String endDate = pageParam.getString("endDate");
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
//        Date StartTime = format.parse(startDate);
//        Date EndTime = format.parse(endDate);
//        queryWrapper.ge(StartTime!=null,"date",StartTime);
//        queryWrapper.le(EndTime!=null,"date",EndTime);
//        IPage page = this.coalCostService.page(pageParam, queryWrapper);
//        return new PageResult<>(page.getRecords(),pageParam.getTotal());
//    }
    @RequestMapping("/list")
    public DataGridView coalCostList(CoalCostListVo costListVo){
        Page<CoalCost> page = new Page<>(costListVo.getPage(), costListVo.getLimit());
        QueryWrapper<CoalCost> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(costListVo.getStartTime()!=null,"date",costListVo.getStartTime());
        queryWrapper.le(costListVo.getEndTime()!=null,"date",costListVo.getEndTime());
        this.coalCostService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }
}

