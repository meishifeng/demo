package com.meishifeng.demo.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <ul>
 * <li>Excel转换service</li>
 * <li>1.获取Excel导入模板</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/25 Time:15:48</li>
 * </ul>
 */
public interface ExcelService {

    /**
     * 获取Excel导入模板
     * @param suffixName            文件后缀名
     * @param titles    标题
     * @param contents           内容列表
     * @return
     */
    Workbook getTemplate(String suffixName, LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents);

}
