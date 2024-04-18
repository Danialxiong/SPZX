package com.xiong.spzx.manager.test;

import com.alibaba.excel.EasyExcel;
import com.xiong.spzx.model.vo.product.CategoryExcelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @title EasyExcelTest
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 21:42
 */
public class EasyExcelTest {

    public static void main(String[] args) {
        read();
       // write();
    }

    public static void read(){
        //1.定义读取excel文件路径
        String fileName = "/Users/xiong/Desktop/test.xlsx";
        //2.调用方法实现读取操作
        ExcelListener<CategoryExcelVo> objectExcelListener = new ExcelListener<>();
        EasyExcel.read(fileName, CategoryExcelVo.class, objectExcelListener)
                .sheet().doRead();
        //3.获取读取的数据
        List<CategoryExcelVo> data = objectExcelListener.getData();
        for (CategoryExcelVo categoryExcelVo : data) {
            System.out.println(categoryExcelVo);
        }
    }


    public static void write(){
        //1.定义写入excel文件路径
        String fileName = "/Users/xiong/Desktop/test.xlsx";

        List<CategoryExcelVo> list = new ArrayList<>() ;
        list.add(new CategoryExcelVo(1L , "数码办公" , "",0L, 1, 1)) ;
        list.add(new CategoryExcelVo(11L , "华为手机" , "",1L, 1, 2)) ;
        //2.调用方法实现写入操作
        EasyExcel.write(fileName, CategoryExcelVo.class)
                .sheet("分类的数据")
                .doWrite(list);
    }
}
