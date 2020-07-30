package com.wf.ew.system.model;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zwt
 * @since 2020-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MillData implements Serializable {

    private static final long serialVersionUID=1L;

    private Date date;

    /**
     * 辊压机定辊
     */
    private Long dingKun;

    /**
     * 辊压机动辊
     */
    private Long dongKun;

    /**
     * 辊压机循环风机
     */
    private Long clcWood;

    /**
     * 磨主电机
     */
    private Long eleMac;

    /**
     * 排风机
     */
    private Long exhFan;

    /**
     * 选粉机柜电源
     */
    private Long eleSou;

    /**
     * 入磨提升机柜
     */
    private Long inehcMac;

    /**
     * 出磨提升机
     */
    private Long outehcMac;

    /**
     * 磨尾收尘
     */
    private Long endShou;

    /**
     * 磨电量
     */
    private Long eleValue;


}
