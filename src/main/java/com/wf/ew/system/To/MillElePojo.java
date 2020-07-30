package com.wf.ew.system.To;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/4/1 14:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MillElePojo {
    private List<Date> date;
    private List<Long> eleValue;

}
