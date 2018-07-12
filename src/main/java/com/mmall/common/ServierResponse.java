/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ServierResponse
 * Author:   aa806
 * Date:     2018/7/12 21:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * 〈服务端响应对象〉<br>
 * 〈〉
 *
 * @author aa806
 * @create 2018/7/12
 * @since 1.0.0
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化Json的时候，如果是null的对象，key也会消失
public class ServierResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServierResponse(int status){
        this.status = status;
    }
    private ServierResponse(int status,T data){
        this.status = status;
        this.data = data;
    }
    private ServierResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    private ServierResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在Json序列化结果中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }

    public String getMsg(){
        return msg;
    }

    public static <T> ServierResponse<T> createBySuccess(){
        return new ServierResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServierResponse<T> createBySuccessMessage(String msg){
        return new ServierResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServierResponse<T> createBySuccess(T data){
        return new ServierResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServierResponse<T> createBySuccess(String msg,T data){
        return new ServierResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServierResponse<T> createByError(){
        return new ServierResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServierResponse<T> createByErrorMessage(String errorMessage){
        return new ServierResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServierResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServierResponse<T>(errorCode,errorMessage);
    }

}