/*
* Copyright (c) 2014 Qunar.com. All Rights Reserved.
*/
package io.github.ketao1989.support;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author: tao.ke Date: 14-5-23 Time: 上午11:38
 * @version: \$Id$
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
