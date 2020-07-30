package com.wf.ew.system.model;

import java.time.LocalDate;
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
 * @since 2020-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MecEle implements Serializable {

    private static final long serialVersionUID=1L;

    private LocalDate date;

    private Long waterPump;

    private Long mateSta;

    private Long imprMec;

    private Long mateMec;

    private Long dealCoal;

    private Long prodEle;

    private Long outerSys;


}
