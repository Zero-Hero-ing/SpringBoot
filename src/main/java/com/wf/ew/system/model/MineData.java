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
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MineData implements Serializable {

    private static final long serialVersionUID=1L;

    private Date date;

    private Double brokMoto;

    private Double broadEle;

    private Double woodMoto;

    private Double recMac;

    private Double transMoto;

    private Double dayBrok;

    private Double clikTran;

    private Double totalEle;

    private int state;


}
