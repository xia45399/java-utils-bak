package com.summer;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<JSONObject> handleExcel(File file, String[] field) throws IOException {
        return null;
    }

    public static List<JSONObject> handleExcel(InputStream inputStream, String[] field) throws IOException {
        return null;
    }

    public static <T> List<T> handleExcel(File file, String[] field, Class<T> clazz) throws IOException {
        return null;
    }

    public static <T> List<T> handleExcel(InputStream inputStream, String[] field, Class<T> clazz) throws IOException {
        return null;
    }

    public static List<JSONObject> handleXls(File file, String[] field) throws IOException {
        return handleXls(new FileInputStream(file), field, JSONObject.class);
    }

    public static List<JSONObject> handleXls(InputStream inputStream, String[] field) throws IOException {
        return handleXls(inputStream, field, JSONObject.class);
    }

    public static <T> List<T> handleXls(File file, String[] field, Class<T> clazz) throws IOException {
        return handleXls(new FileInputStream(file), field, clazz);
    }

    public static <T> List<T> handleXls(InputStream inputStream, String[] field, Class<T> clazz) throws IOException {
        int column = field.length;
        List<T> list = new ArrayList<>();
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        int sheetSize = hssfWorkbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetSize; sheetIndex++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetIndex);
            //获取最大行数
            int rows = hssfSheet.getPhysicalNumberOfRows();
            //当前页循环读取每一行
            rows = hssfSheet.getLastRowNum();
            rows = rows == 0 ? 0 : ++rows;
            for (int rowNum = 1; rowNum < rows; rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 0; i < column; i++) {
                        HSSFCell cell = hssfRow.getCell(i);
                        if (cell != null) {
                            cell.setCellType(CellType.STRING);
                            String value = cell.getStringCellValue();
                            jsonObject.put(field[i], value);
                        }
                    }
                    T object = JSONObject.toJavaObject(jsonObject, clazz);
                    list.add(object);
                }
            }
        }
        return list;
    }


    public static List<JSONObject> handleXlsx(File file, String[] field) throws IOException {
        return handleXlsx(new FileInputStream(file), field, JSONObject.class);
    }

    public static List<JSONObject> handleXlsx(InputStream inputStream, String[] field) throws IOException {
        return handleXlsx(inputStream, field, JSONObject.class);
    }

    public static <T> List<T> handleXlsx(File file, String[] field, Class<T> clazz) throws IOException {
        return handleXlsx(new FileInputStream(file), field, clazz);
    }

    public static <T> List<T> handleXlsx(InputStream inputStream, String[] field, Class<T> clazz) throws IOException {
        int column = field.length;
        List<T> list = new ArrayList<>();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        int sheetSize = xssfWorkbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetSize; sheetIndex++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
            //获取最大行数
            int rows = xssfSheet.getPhysicalNumberOfRows();
            //当前页循环读取每一行
            rows = xssfSheet.getLastRowNum();
            rows = rows == 0 ? 0 : ++rows;
            for (int rowNum = 1; rowNum < rows; rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    JSONObject jsonObject = new JSONObject();
                    for (int i = 0; i < column; i++) {
                        XSSFCell cell = xssfRow.getCell(i);
                        if (cell != null) {
                            cell.setCellType(CellType.STRING);
                            String value = cell.getStringCellValue();
                            jsonObject.put(field[i], value);
                        }
                    }
                    T object = JSONObject.toJavaObject(jsonObject, clazz);
                    list.add(object);
                }
            }
        }
        return list;
    }
}
