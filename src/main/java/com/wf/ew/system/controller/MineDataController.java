package com.wf.ew.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wf.ew.common.DataGridView;
import com.wf.ew.common.JsonResult;
import com.wf.ew.system.To.MineElePojo;
import com.wf.ew.system.Vo.mineVo;
import com.wf.ew.system.Vo.mineVo;
import com.wf.ew.system.model.MineData;
import com.wf.ew.system.model.MineData;
import com.wf.ew.system.service.MineDataService;
import com.wf.ew.system.service.MineDataService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/system/mine")
public class MineDataController {
    @Autowired
    private MineDataService mineDataService;
    @RequestMapping("list")
    public DataGridView listmine(mineVo mineVo){
        Page<MineData> page = new Page<>(mineVo.getPage(), mineVo.getLimit());
        QueryWrapper<MineData> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(mineVo.getStartTime()!=null,"date",mineVo.getStartTime());
        queryWrapper.le(mineVo.getEndTime()!=null,"date",mineVo.getEndTime());

        this.mineDataService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @RequestMapping("/updateState")
    public JsonResult updateState(Date date,Integer state){
        if (date==null){
            return JsonResult.error("参数为空");
        }
        if (state == null || (state != 0 && state != 1)) {
            return JsonResult.error("状态值不正确");
        }
        MineData mineData = new MineData();
        mineData.setDate(date);
        mineData.setState(state);
        if (mineDataService.updateById(mineData)){
            return JsonResult.ok();
        }
        return JsonResult.error();
    }
    @RequestMapping("pageOne")
    public MineElePojo pageEle(){
        List<MineData> list = mineDataService.list();
        ArrayList<Date> date = new ArrayList<>();
        ArrayList<Double> ele = new ArrayList<>();
        for (MineData mineData : list) {
            date.add(mineData.getDate());
            ele.add(mineData.getTotalEle());

        }
        MineElePojo mineElePojo = new MineElePojo();
        mineElePojo.setDate(date);
        mineElePojo.setTotalEle(ele);
        return mineElePojo;
    }
}

