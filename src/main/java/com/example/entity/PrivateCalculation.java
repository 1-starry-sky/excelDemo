package com.example.entity;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
import com.example.util.ExcelExport;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateCalculation implements Serializable {
    private static final Long serialVersionUID = 1L;
    private  String id;
    @ExcelExport(value = "姓名")
    private String name;
    private  String phoneNumber;
    private  String email;

    @ExcelExport(value = "公司名称")

    private  String companyName;
    @ExcelExport(value = "行业")

    private  String companyIndustry;
    @ExcelExport(value = "业务场景",example = "银行",kv  = "1-银行;2-电力")
    private  String businessScene;
    @ExcelExport(value = "合作模式")
    private  String businessModel;
    private  String isPrivacyCalculation;
    private  String privacyCalculationPower;
    private  String isExtraPower;
    private  String needExtraPower;
    private  String requireDescription;
    private  String account;
    @ExcelExport(value = "填写时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    private  String userId;
    private  String type;












}
