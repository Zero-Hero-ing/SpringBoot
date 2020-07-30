package com.wf.ew.system.Vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/4/1 14:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class millVo {
    private static final long serialVersionUID=1L;
    private Integer page=1;
    private Integer limit=10;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
