/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package com.taocoder.spring.controller.support;

import com.taocoder.spring.common.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

/**
 * @author tao.ke Date: 16/5/24 Time: 下午9:40
 */
public class GlobalJsonMessageConverter extends MappingJackson2HttpMessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalJsonMessageConverter.class);

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(object, outputMessage);
        LOGGER.info("response data:{}",JsonUtils.encode(object));
    }
}
