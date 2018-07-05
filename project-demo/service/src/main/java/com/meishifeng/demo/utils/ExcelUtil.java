package com.meishifeng.demo.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>Excel工具类</li>
 * <li>User:meishifeng Date:2018/05/25 Time:16:03</li>
 * </ul>
 */
public class ExcelUtil {

    /**
     * 根据Excel文件后缀名称，标题，数据内容列表创建Excel文件
     * @param suffixName    后缀名称
     * @param titles        Excel表标题
     * @param contents      数据内容集合
     * @return              返回Excel文件，Workbook类型
     */
    public static Workbook createExeclByData(String suffixName, LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents){
        suffixName = suffixName.toLowerCase();
        if ("xls".equals(suffixName)) {
            return createXLSFile(titles, contents);
        } else if ("xlsx".equals(suffixName)) {
            return createXLSXFile(titles, contents);
        }
        return null;
    }

    /**
     * 创建xls类型的Excel文件
     * @param titles    标题Map
     * @param contents  内容列表
     * @return          返回Excel文件，Workbook类型
     */
    public static Workbook createXLSFile(LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents){
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("员工数据");
        createSheet(sheet, titles, contents);

        return workbook;
    }

    /**
     * 创建xlsx类型的Excel文件
     * @param titles    标题Map
     * @param contents  内容列表
     * @return          返回Excel文件，Workbook类型
     */
    public static Workbook createXLSXFile(LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("员工数据");
        createSheet(sheet, titles, contents);

        return workbook;
    }

    /**
     * 给sheet创建内容，标题和内容
     * @param sheet     需要处理的sheet
     * @param titles    标题
     * @param contents  内容
     */
    public static void createSheet(Sheet sheet, LinkedHashMap<String, String> titles, List<HashMap<String, Object>> contents){
        //创建行
        Row row = sheet.createRow(0);
        int i = 0;
        //存储标题的映射，及所在列的编号（位置）的map
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String title : titles.keySet()){
            //创建格
            Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
            //给格中赋值
            cell.setCellValue(title);
            //存储标题的映射，及所在列的编号（位置）
            hashMap.put(titles.get(title), i);
            i++;
        }

        i = 1;
        //遍历内容列表
        for (HashMap<String, Object> content : contents){
            //从第二行开始创建，第一行是标题
            Row hssfRow = sheet.createRow(i);
            //遍历映射，key为映射值，value为该映射所在的位置
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()){
                //根据映射值取出行内容中每个格子的值
                Object value = content.get(entry.getKey());
                if (value == null)
                    continue;
                //根据所处位置创建格子
                Cell cell = hssfRow.createCell(entry.getValue(), Cell.CELL_TYPE_STRING);
                //给格子赋值
                cell.setCellValue((String)value);
            }
            i++;
        }
    }

}
