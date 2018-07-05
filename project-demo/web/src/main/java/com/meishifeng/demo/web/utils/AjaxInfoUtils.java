package com.meishifeng.demo.web.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <ul>
 * <li>用户Ajax返回数据使用</li>
 * <li>1.响应json数组数据到页面，用于ajax请求</li>
 * <li>2.响应son对象数据到页面，用于ajax请求</li>
 * <li>User:meishifeng Date:2017/1/5 Time:16:09</li>
 * </ul>
 */
public class AjaxInfoUtils {

    /**
     * 响应json数组数据到页面，用于ajax请求
     *
     * @param obj   参数
     * @param response  响应
     */
    public static void setJsonArrayResponseToWeb(Object obj,HttpServletResponse response) {
        PrintWriter out = null;
        try {
            JSONArray json = JSONArray.fromObject(obj);
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        } catch (IOException e){

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     *  响应son对象数据到页面，用于ajax请求
     * @param obj   参数
     * @param response  响应
     */
    public static void setJsonObjResponseToWeb(Object obj, HttpServletResponse response){
        PrintWriter out = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            JSONObject json = JSONObject.fromObject(obj);
            out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        } catch (IOException e){

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
