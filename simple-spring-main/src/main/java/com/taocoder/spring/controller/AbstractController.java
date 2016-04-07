/*
 * Copyright (c) 2016 taocoder.com. All Rights Reserved.
 */
package com.taocoder.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: tao.ke Date: 14-5-23 Time: 下午3:37
 * @version: \$Id$
 */
public abstract class AbstractController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected Map<String,Object> dataJson(Object value) {
        Map<String, Object> data = new HashMap<String, Object>(3);
        data.put("ret", true);
        data.put("data", value);
        data.put("code", 0);
        return data;
    }

    protected Map<String,Object> errorJson(String message, int code) {
        Map<String, Object> data = new HashMap<String, Object>(3);
        data.put("ret", false);
        data.put("code", code);
        data.put("errmsg", message);
        return data;
    }
}
