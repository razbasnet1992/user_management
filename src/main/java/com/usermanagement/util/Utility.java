package com.usermanagement.util;

import javax.servlet.http.HttpServletRequest;

public class Utility {
    public static String getUrlSite(HttpServletRequest request){
        String urlSite = request.getRequestURL().toString();
        return urlSite.replace(request.getServletPath(),"");
    }
}
