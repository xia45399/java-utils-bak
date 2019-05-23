package com.summer.utils.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("张三", 12, "南京"));
        list.add(new User("张三", 12, "南京"));
        list.add(new User("张三", 12, "南京"));
        list.add(new User("张三", 12, "南京"));
        try {
            testExcelWrite(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testExcelWrite(List<User> list) throws FileNotFoundException {
        OutputStream out = new FileOutputStream("F:\\myCode\\github\\java-utils\\77.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//            Sheet sheet1 = new Sheet(1, 0);
//            sheet1.setSheetName("第一个sheet");
//            writer.write1(get(list), sheet1);

            Sheet sheet2 = new Sheet(1, 0);
            Table table2=new Table(1);
            List<String> header=new ArrayList<>();
            header.add("aaa");
            header.add("bbb");
            header.add("ccc");
            ArrayList<List<String>> h = new ArrayList<List<String>>();
            h.add(header);
            table2.setHead(h);
            sheet2.setSheetName("第2个sheet");
            writer.write1(get(list), sheet2,table2);


            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<List<Object>> get(List<User> list) {
        List<List<Object>> rows = new ArrayList<>();
        for (User user : list) {
            List<Object> row = new ArrayList<>();
            row.add(user.getName());
            row.add(user.getAge());
            row.add(user.getAddress());
            rows.add(row);
        }
        return rows;
    }


}
