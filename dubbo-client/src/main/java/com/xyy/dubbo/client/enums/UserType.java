package com.xyy.dubbo.client.enums;

/**
 * @Author: Xiongyy
 * @Date: 2020/11/9 22:07
 * .............................................
 * 佛祖保佑             永无BUG
 */
public enum UserType {

    INNER,

    /**
     * 外包账号
     */
    OUTER;

    private Integer intValue;

    public void UserType(Integer intValue){
        this.intValue = intValue;
    }
}
