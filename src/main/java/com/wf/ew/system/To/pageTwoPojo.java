package com.wf.ew.system.To;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zwt
 * @version 1.0
 * @date 2020/3/14 15:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class pageTwoPojo {
    private List<Date> date;
    private List<String> prodRate;
}
