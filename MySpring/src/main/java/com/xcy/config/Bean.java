package com.xcy.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcy
 * @Desc
 * @date 2020/7/30 22:29
 * @Version v1.0
 */
@Data
public class Bean {
    private String name;
    private String className;
    private List<Property> properties = new ArrayList<Property>();

}
