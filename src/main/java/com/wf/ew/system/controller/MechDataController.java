package com.wf.ew.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wf.ew.common.DataGridView;
import com.wf.ew.system.Vo.monitorListVo;
import com.wf.ew.system.model.MechData;
import com.wf.ew.system.service.MechDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwt
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/system/monitor")
public class MechDataController {
    @Autowired
    private MechDataService mechDataService;
    @RequestMapping("/list")
    public DataGridView monitorList(monitorListVo monitorListVo){
        Page<MechData> page = new Page<>(monitorListVo.getPage(), monitorListVo.getLimit());
        QueryWrapper<MechData> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(monitorListVo.getStartTime()!=null,"date",monitorListVo.getStartTime());
        queryWrapper.le(monitorListVo.getEndTime()!=null,"date",monitorListVo.getEndTime());
        this.mechDataService.page(page, queryWrapper);
        return  new DataGridView(page.getTotal(),page.getRecords());
    }

}

