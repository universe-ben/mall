/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ResponseCode
 * Author:   aa806
 * Date:     2018/7/12 22:35
 * Description: 枚举
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mmall.common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈枚举〉
 *
 * @author aa806
 * @create 2018/7/12
 * @since 1.0.0
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;//代号
    private final String desc;//状态

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc() {
        return desc;
    }
}