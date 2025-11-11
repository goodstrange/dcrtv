package com.dcrtv.dcrtvbackend.tool;

import com.dcrtv.dcrtvbackend.model.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CookieTool {

    /**
     *将信息存入cookie
     * @param response
     * @param type 存入cookie中的信息含义
     * @param message 存入cookie中的信息
     */
    public static void setCookie(HttpServletResponse response, String type,String message){
        Cookie cookie=new Cookie(type,message);
        cookie.setHttpOnly(true);      // 防止XSS攻击
        cookie.setSecure(true);        // HTTPS only
        cookie.setPath("/");           // 全站有效
        cookie.setMaxAge(3 * 24 * 60 * 60); // 3天
        cookie.setAttribute("SameSite", "Lax"); // CSRF防护

        response.addCookie(cookie);
    }

    /**
     * 获取cookie中的信息
     * @param request
     * @param type
     * @return
     */
    public static String getCookie(HttpServletRequest request,String type){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (type.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 移除cookie中的信息（退出登录）
     * @param response
     * @param type
     */
    public static void removeCookie(HttpServletResponse response,String type){
        Cookie cookie=new Cookie(type,"");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 立即过期

        response.addCookie(cookie);
    }
}
