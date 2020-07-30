package com.wf.ew.system.Vo;

import com.wf.ew.system.model.MechData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/3/15 16:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class monitorListVo  extends MechData {
    private static final long serialVersionUID=1L;
    private Integer page=1;
    private Integer limit=10;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
