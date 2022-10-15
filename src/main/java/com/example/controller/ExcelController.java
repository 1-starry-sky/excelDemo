package com.example.controller;


import com.example.common.entity.Result;
import com.example.entity.PrivateCalculation;
import com.example.mapper.PrivateCalculationMapper;
import com.example.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping("/privateCalculation/*")
@RestController
@RequestMapping(value = "/privateCalculation", produces = "application/json;charset=utf-8")
@Api(tags = "Excel相关操作")
public class ExcelController {
    @Autowired
    private  PrivateCalculationMapper privateCalculationMapper;


    /**
     * 通过表示类的自定义注解来选择需要导出字段及相关配置和数据
     * @param map
     * @param response
     * @return
     */
    @RequestMapping(value = "exportExcel",method = RequestMethod.POST)

    @ApiOperation( value = "导出Excel",notes = "通过表示类的自定义注解来选择需要导出字段及相关配置及数据")
    public Result exportExcel(@RequestBody Map<String,Object> map, HttpServletResponse response) {

        try {
            String startTime= (String) map.get("startTime");
            String endTime= (String) map.get("endTime");
            List<PrivateCalculation> privateCalculationList= privateCalculationMapper.getAllPrivateCalculation(startTime,endTime);
            System.out.println("privateCalculationList = " + privateCalculationList);
            ExcelUtil.export(response,"隐私计算需求评估表",privateCalculationList,PrivateCalculation.class);

            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }

    /**
     * 通过类的自定义注解来选择需要导出字段及相关配置的excel模板
     * @param response
     * @return
     */
//    @RequestMapping(value = "exportExcel1",method = RequestMethod.GET)
    @GetMapping (value = "exportExcelModelByWriter")
    @ApiOperation( value = "导出Excel模板文件",notes = "通过类的自定义注解来选择需要导出字段及相关配置的excel模板")
    public Result exportExcelModelByWriter(HttpServletResponse response) {

        try {

            List<Object> head = Arrays.asList("姓名","年龄","性别","头像");

            // 用户1数据

            List<Object> privateCalculation1= new ArrayList<>();

            //数据汇总
            List<List<Object>> sheetDataList = new ArrayList<>();
            sheetDataList.add(head);
            sheetDataList.add(privateCalculation1);
//            sheetDataList.add(privateCalculation2);

            ExcelUtil.export(response,"隐私计算需求评估表", sheetDataList);
            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }
    /**
     * 通过类的自定义注解来选择需要导出字段及相关配置的excel模板(带示列值)
     * @param response
     * @return
     */
//    @RequestMapping(value = "exportExcel1",method = RequestMethod.GET)
    @GetMapping (value = "exportExcelModelByWriter1")
    @ApiOperation( value = "导出Excel模板文件",notes = "通过类的自定义注解来选择需要导出字段及相关配置的excel模板(带示列值)")
    public Result exportExcelModelByWriter1(HttpServletResponse response) {


        try {




//            FileInputStream in;
//            in=new FileInputStream("D:\\桌面文件\\6c894cbdf6078021941be41a613875f.jpg");
//
//            int i=in.available();
//            byte[]data=new byte[i];
//            in.read(data);
//            in.close();
            List<Object> head = Arrays.asList("姓名","年龄","性别","头像");

            // 用户1数据

            List<Object> user1= new ArrayList<>();
            user1.add("张三");
            user1.add("18");
            user1.add("男");
            user1.add(new URL("https://img-blog.csdnimg.cn/1ad115e3fc06423ea16b0b89e9e821ba.png"));
            //图片文件  我这儿使用的是本地文件
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("D://桌面文件/6c894cbdf6078021941be41a613875f.jpg"));
//            user1.add(new FileOutputStream("D://桌面文件/6c894cbdf6078021941be41a613875f.jpg"));
            InputStream inputstream = new FileInputStream(new File("C://Users/lenovo/Pictures/Saved Pictures/111.png"));
//            user1.add(inputstream);
            List<Object> privateCalculation1= new ArrayList<>();
//            privateCalculation1.add("张三");
            //数据汇总
            List<List<Object>> sheetDataList = new ArrayList<>();
            sheetDataList.add(head);
            sheetDataList.add(user1);
//            sheetDataList.add(privateCalculation2);

            ExcelUtil.export(response,"隐私计算需求评估表", sheetDataList);
            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }
    /**
     * 通过方法中自定义内容去导出excel模板
     * @param response
     * @return
     */
    @GetMapping (value = "exportExcelModelByClass")
    @ApiOperation( value = "导出Excel模板文件",notes = "通过方法中自定义内容去导出excel模板")
    public Result exportExcelModelByClass(HttpServletResponse response) {

        try {

            ExcelUtil.export(response,"隐私计算需求评估表",null,PrivateCalculation.class);//
            ExcelUtil.exportTemplate(response,"表",PrivateCalculation.class,true);
            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }
    /**
     * 通过方法中自定义内容去导出excel模板(带示列值)
     * @param response
     * @return
     */
    @GetMapping (value = "exportExcelModelByClass1")
    @ApiOperation( value = "导出Excel模板文件",notes = "通过方法中自定义内容去导出excel模板")
    public Result exportExcelModelByClass1(HttpServletResponse response) {

        try {

            ExcelUtil.exportTemplate(response,"表",PrivateCalculation.class,true);
            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }
    /**
     *通过自定义内容excel文件
     * @param response
     * @return
     */
//    @RequestMapping(value = "exportExcel1",method = RequestMethod.GET)
    @GetMapping (value = "exportExcelModelByWriter2")
    @ApiOperation( value = "导出Excel文件",notes = "通过自定义内容excel文件")
    public Result exportExcelModelByWriter2(HttpServletResponse response) {

        try {

            List<Object> head = Arrays.asList("姓名","年龄","性别","头像");

            // 用户1数据

            List<Object> privateCalculation1= new ArrayList<>();
            privateCalculation1.add("张三");
            privateCalculation1.add("18");
            privateCalculation1.add("男");
            privateCalculation1.add("1");
            // 用户2数据
            List<Object> privateCalculation2= new ArrayList<>();
            privateCalculation2.add("李四");
            privateCalculation2.add("18");
            privateCalculation2.add("男");
            privateCalculation2.add("1");

            //数据汇总
            List<List<Object>> sheetDataList = new ArrayList<>();
            sheetDataList.add(head);
            sheetDataList.add(privateCalculation1);
            sheetDataList.add(privateCalculation2);

            //用户n
            String startTime=null;
            String endTime=null;
            List<PrivateCalculation> privateCalculationList= privateCalculationMapper.getAllPrivateCalculation(startTime,endTime);
            for (int i = 0; i < privateCalculationList.size(); i++) {
                List<Object> privateCalculationN= new ArrayList<>();
                 privateCalculationN.add(privateCalculationList.get(i).getName());
                 privateCalculationN.add(privateCalculationList.get(i).getType());
                 privateCalculationN.add(privateCalculationList.get(i).getCompanyName());
                 sheetDataList.add(privateCalculationN);
            }
            ExcelUtil.export(response,"隐私计算需求评估表", sheetDataList);
            return new Result<>(0, "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(-1, "发生错误");
        }
    }
}
