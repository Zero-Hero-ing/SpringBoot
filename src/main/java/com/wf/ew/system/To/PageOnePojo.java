package com.wf.ew.system.To;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/3/14 20:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageOnePojo {
    private List<Date> date;
    private List<Double> coalCost;
    private List<String> prodNum;
    private List<String> feedNum;
}
