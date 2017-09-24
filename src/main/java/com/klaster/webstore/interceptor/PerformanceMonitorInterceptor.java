package com.klaster.webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MSI DRAGON on 2017-09-24.
 */
public class PerformanceMonitorInterceptor implements HandlerInterceptor {

    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(this.getClass());
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(handler.toString());
        stopWatch.start(handler.toString());
        stopWatchLocal.set(stopWatch);
        logger.info("Przetwarzanie żądania do ścieżki: " + getURLPath(request));
        logger.info("Przetwarzanie żądania rozpoczęto o: " + getCurrentTime());
        return true;
    }
    public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Przetwarzanie żądania zakończono o: " + getCurrentTime());
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        StopWatch stopWatch = stopWatchLocal.get();
        stopWatch.stop();
        logger.info("Łączny czas przetwarzania żądania: " + stopWatch.getTotalTimeMillis()+ " ms");
        stopWatchLocal.set(null);
        logger.info("=======================================================");
    }
    private String getURLPath(HttpServletRequest request) {
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath+queryString;
    }
    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
