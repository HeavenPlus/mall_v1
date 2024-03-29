package com.heaven.enums;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:08
 */
public enum YesOrNo {
    NO(0, "否"),
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
