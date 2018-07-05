package com.meishifeng.demo.web.controller;

import com.meishifeng.demo.service.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <ul>
 * <li>Excel转换controller</li>
 * <li>1.跳转到相应的页面</li>
 * <li>2.获取Excel模板</li>
 * <li>User:meishifeng Date:2018/05/10 Time:14:35</li>
 * </ul>
 */
@Controller
@RequestMapping(value = "excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 跳转到相应的页面
     * @return
     */
    @RequestMapping(value = "toIndex")
    public String toIndex(){
        return "excel/excelTransformation";
    }

    /**
     * 获取Excel导入模板
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "getTemplate")
    public void getTemplate(HttpServletResponse response) throws Exception{
        String suffixName = "xlsx";
        String fileName = "模板." + suffixName;

        LinkedHashMap<String, String> titles = new LinkedHashMap<>();
        titles.put("经纪人", "EmpName");
        titles.put("手机号", "Mobile");
        titles.put("公司", "ComName");
        titles.put("门店", "StoreName");
        titles.put("机构码", "Hroc_Code");

        List<HashMap<String, Object>> contents = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hashmap = new HashMap<String, Object>();
        hashmap.put("EmpName", "XXX(必填)");
        hashmap.put("Mobile", "XXX(必填)");
        hashmap.put("ComName", "XXX");
        hashmap.put("StoreName", "XXX");
        hashmap.put("Hroc_Code", "XXX(必填)");
        contents.add(hashmap);

        Workbook workbook = excelService.getTemplate(suffixName, titles, contents);

        //将execl对象以流的形式给请求端
        response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO-8859-1"));
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }

}
