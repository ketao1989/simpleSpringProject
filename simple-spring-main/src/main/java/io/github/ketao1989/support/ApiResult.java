/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.support;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

/**
 * @author: tao.ke Date: 14-5-23 Time: 上午10:55
 * @version: \$Id$
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ApiResult")
@XmlSeeAlso({ String.class })
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 6358911739722949532L;

    /**
     * 返回成功失败
     */
    @XmlElement(name = "ret")
    private boolean ret;
    /**
     * 返回码
     */
    @XmlElement(name = "code")
    private int code;
    /**
     * 返回结果数据
     */
    @XmlElement(name = "data")
    private T data;
    /**
     * 错误信息
     */
    @XmlElement(name = "errMsg")
    private String errmsg;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
