package com.klaster.webstore.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by MSI DRAGON on 2017-09-24.
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {
    Logger logger = Logger.getLogger("auditLogger");
    private String user;
    private long productId = 1;
    //todo dodac obsluge pobierania productId z requesta!
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {
        if(request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")){
            user = request.getRemoteUser();
            //productId = Long.parseLong(request.getParameterValues("productId")[0]);
        }
        return true;
    }
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception arg3) throws Exception {
        if(request.getRequestURI().endsWith("products/add") && response.getStatus()==302){
            logger.info(String.format("Nowy produkt [%s] dodany przez %s dnia %s", productId, user, getCurrentTime()));
        }
    }
    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}

