package com.meishifeng.demo.service.impl;

import com.meishifeng.demo.service.ExcelService;
import com.meishifeng.demo.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <ul>
 * <li>类名</li>
 * <li>1.方法一说明</li>
 * <li>2.方法二说明</li>
 * <li>User:meishifeng Date:2018/05/25 Time:15:48</li>
 * </ul>
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {

    /**
     * 获取Excel导入模板
     * @param suffixName            文件后缀名
     * @param titles    标题
     * @param contents           内容列表
     * @return
     */
    @Override
    public Workbook getTemplate(String suffixName, LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents){
        Workbook workbook = ExcelUtil.createExeclByData(suffixName, titles, contents);
        return workbook;
    }

}
