package com.iunis.adventclub.helpers;

import javax.servlet.http.HttpServletRequest;

public class CommonsHelpers {

    public static String getBaseUrl(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    }
}
