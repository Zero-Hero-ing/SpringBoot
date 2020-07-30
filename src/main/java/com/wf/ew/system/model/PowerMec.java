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
 * @since 2020-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PowerMec implements Serializable {

    private static final long serialVersionUID=1L;

    private Date date;

    private Long limeStone;

    private Long outWood;

    private Long hightmpFan;

    private Long supByq;

    private Long eleValue;

    private Long lowPower;

    private Long aProd;

    private Long bProd;

    private Long cusmEle;


}
