package com.fiberhome.common;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelProcess {

     static Logger logger = Logger.getLogger(ExcelProcess.class);

    /**
     *
     * @param
     * @return
     */
    public  Workbook getWorkBook(MultipartFile multipartFile){
        String filename = multipartFile.getOriginalFilename();

        Workbook workbook = null;
        try {
            InputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());
            if(filename.endsWith(".xls")){
                workbook = new HSSFWorkbook(inputStream);
            }else if (filename.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return workbook;
        }
    }

    public  Workbook getWorkBook(String path){
        Workbook workbook = null;
        try {

            if(path.endsWith(".xls")){
                workbook = new HSSFWorkbook(new FileInputStream(path));
            }else if (path.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(new FileInputStream(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return workbook;
        }
    }


    public String[] getExcelTitles(Workbook workbook){
        Row row = workbook.getSheetAt(0).getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        String[] titles = new String[colNum];
        for (int i = 0 ; i <colNum ; i++){
            titles[i] = row.getCell(i).getStringCellValue();
            System.out.println(titles[i]);
        }
        System.out.println(titles.toString());
        return titles;
    }

    public void closeWorkBook(Workbook workbook){
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param workbook
     * @param sheetId
     * @param startRowNum
     * @param cls
     * @return
     */
    public List importExcelContent2BeanList(Workbook workbook, int sheetId, int startRowNum, Class<?> cls){
        Sheet sheet = workbook.getSheetAt(sheetId);
        int rowNum = sheet.getPhysicalNumberOfRows();
        if(rowNum == 0){
            System.out.println("空文件");
            return null;
        }
        int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
        List list = new ArrayList<>();

        boolean annotationflg = true;
        for(Field f : cls.getDeclaredFields()){
            Annotation[] annotations =  f.getAnnotations();

            for(Annotation annotation : annotations){
                if(annotation.annotationType().getName() == "javax.persistence.Id"){
                    annotationflg = false;
                }
            }
        }

        if(annotationflg && cls.getDeclaredFields().length != colNum){
            return null;
        }else if( !annotationflg && cls.getDeclaredFields().length != colNum+1){
            return null;
        }

        for (int i = startRowNum; i< rowNum ;i++){
            Object object = null;
            Row row = sheet.getRow(i);
            List l = new ArrayList<String>();
            for(int j = 0;j < colNum; j++){
                String cValue = getCellValue(row.getCell(j));
                l.add(cValue);
            }
            System.out.println();
            try {
                Constructor constructor = cls.getDeclaredConstructor(List.class);
                object = constructor.newInstance(l);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            list.add(object);
        }
        return list;
    }

    /**
     *
     * @param workbook
     * @param sheetId
     * @param startRowNum
     * @param cls
     * @return
     */
    public List importExcelContent2BeanList(Workbook workbook, int sheetId, int startRowNum, Class<?> cls, String time){
        Sheet sheet = workbook.getSheetAt(sheetId);
        int rowNum = sheet.getPhysicalNumberOfRows();
        if(rowNum == 0){
            System.out.println("空文件");
            return null;
        }
        int colNum = sheet.getRow(5).getPhysicalNumberOfCells();
        System.out.println(colNum);
        List list = new ArrayList<>();

        boolean annotationflg = true;
        for(Field f : cls.getDeclaredFields()){
            Annotation[] annotations =  f.getAnnotations();

            for(Annotation annotation : annotations){
                if(annotation.annotationType().getName() == "javax.persistence.Id"){
                    annotationflg = false;
                }
            }
        }

        System.out.println(annotationflg);
        System.out.println(cls.getDeclaredFields().length);
        if(annotationflg && cls.getDeclaredFields().length-1 != colNum){
            logger.info("");
            return null;
        }else if( !annotationflg && cls.getDeclaredFields().length-1 != colNum+1){
            return null;
        }

        for (int i = startRowNum; i< rowNum ;i++){
            Object object = null;
            Row row = sheet.getRow(i);
            List l = new ArrayList<String>();
            for(int j = 0;j < colNum; j++){
                String cValue = getCellValue(row.getCell(j));
                l.add(cValue);
            }
            l.add(time);
            try {
                Constructor constructor = cls.getDeclaredConstructor(List.class);
                object = constructor.newInstance(l);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            list.add(object);
        }
        return list;
    }

    private String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellTypeEnum() == CellType.NUMERIC){
            cell.setCellType(CellType.STRING);
        }

        //判断数据的类型
        switch (cell.getCellTypeEnum()){

            case NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK: //空值
                cellValue = "";
                break;
            case ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }


}
