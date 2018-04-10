package com.quhaodian.haodian.data.apps;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.area.data.service.AreaService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelApp {
    public static void main(String[] args) throws IOException {
        System.out.println(ExcelApp.class.getClassLoader().getResource("./"));
        File file = new File("E:\\mvnspace\\quhaodian\\documents\\2016.xls");
        InputStream is = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(is);
        //获得当前sheet工作表
        Sheet sheet = workbook.getSheetAt(0);
        int firstRowNum = sheet.getFirstRowNum();
        //获得当前sheet的结束行
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(lastRowNum);
        List<AreaDTO> areas=new ArrayList<AreaDTO>();
        //循环除了第一行的所有行
        for (int rowNum =718; rowNum <= lastRowNum; rowNum++) {
            //获得当前行
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            //获得当前行的开始列
            int firstCellNum = row.getFirstCellNum();
            //获得当前行的列数
            int lastCellNum = row.getPhysicalNumberOfCells();
            AreaDTO area=new AreaDTO();
            area.setCode(getCellValue(row.getCell(0)));
            area.setName(getCellValue(row.getCell(1)));
            area.setPcode(getCellValue(row.getCell(2)));
            area.setLevel(getCellValue(row.getCell(3)));

            areas.add(area);
        }
        AreaService service = ObjectFactory.get().getBean(AreaService.class);
        for (AreaDTO area : areas) {
            Area item=new Area();
            item.setName(area.getName());
            item.setCode(area.getCode());
            item.setParent(service.findByCode(area.getPcode()));
            service.save(item);
        }
        System.out.println(areas.size());

    }
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}
