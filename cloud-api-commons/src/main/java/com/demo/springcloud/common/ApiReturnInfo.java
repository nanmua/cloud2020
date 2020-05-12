package com.demo.springcloud.common;


import com.demo.springcloud.enu.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiReturnInfo<T> {

    private Integer code ;
    private String message;
    private T data;

    public ApiReturnInfo(Integer code, String message) {
        this(code, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
