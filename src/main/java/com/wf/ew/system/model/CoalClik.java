package com.wf.ew.system.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zwt
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CoalClik implements Serializable {

    private static final long serialVersionUID=1L;

    private LocalDateTime date;

    private String runingTime;

    private Double mainBurner;

    private Double precalBurner;

    private Double coalCost;


}
