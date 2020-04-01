package com.tutorial.common.response;

import java.io.Serializable;

/**
 * @author jimmy
 * @date 2020/4/1 15:58
 */
public interface IResult<T> extends Serializable {
    int getCode();
    int getMsg();
    T getData();
    boolean isSuccess();

    void setCode();
    void setMsg();
    void setData(T var);
}
