package com.wf.ew.system.model;

import java.time.LocalDateTime;
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
 * @since 2020-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoalCost implements Serializable {

    private static final long serialVersionUID=1L;

    private Date date;

    private String runingTime;

    private String feedNum;

    private String prodRate;

    private String prodNum;


}
