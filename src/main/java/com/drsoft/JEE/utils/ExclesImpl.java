package com.drsoft.JEE.utils;

import com.drsoft.JEE.pojo.User;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.util.Date;
import java.util.List;


public class ExclesImpl {

    public void export(String[] titles, List lists, ServletOutputStream out) throws Exception{
        try{
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();

            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");

            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

            HSSFRow row = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
                hssfCell = row.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            }

            List<User> list =lists;


            for (int i = 0; i < lists.size(); i++) {
                row = hssfSheet.createRow(i+1);
               User user = list.get(i);

                // 第六步，创建单元格，并设置值
                int  id = 0;
                if(user.getId() != null){
                    id = user.getId();
                }
                row.createCell(0).setCellValue(id);
                String getLoginName = "";
                if(user.getLoginName() != null){
                    getLoginName = user.getLoginName();
                }

                row.createCell(1).setCellValue(getLoginName);
                String userName=null;
                if(user.getUserName() !=null){
                    userName = user.getUserName();
                }
                row.createCell(2).setCellValue(userName);
                String phone=null;
                if(user.getPhone() !=null){
                    phone = user.getPhone();
                }
                row.createCell(3).setCellValue(phone);
                String email=null;
                if(user.getEmail() !=null){
                    email = user.getEmail();
                }
                row.createCell(4).setCellValue(email);
                String idCard=null;
                if(user.getIdCard() !=null){
                    idCard = user.getIdCard();
                }
                row.createCell(5).setCellValue(idCard);
                String roles=null;
                if(user.getRoles() !=null){
                    roles = user.getRoles();
                }
                row.createCell(6).setCellValue(roles);
                Date createTime=null;
                if(user.getCreateTime() !=null){
                    createTime = user.getCreateTime();
                }
                row.createCell(7).setCellValue(createTime);
            }

            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");

        }
    }
}