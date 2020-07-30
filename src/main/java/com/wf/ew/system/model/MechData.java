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
 * @since 2020-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MechData implements Serializable {

    private static final long serialVersionUID=1L;

    private Date date;

    private Integer runingtime;

    private Integer mainCurrent;

    private Double kilnSpeed;

    private Integer bdp;

    private Double oee;

    private Integer mtbf;

    private Double oTwo;

    private Double co;

    private Integer noX;


}
