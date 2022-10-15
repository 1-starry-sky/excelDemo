package com.example.mapper;


import com.example.entity.PrivateCalculation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface PrivateCalculationMapper {


    @Insert("INSERT INTO  yw_privacy_evaluate(id,name,phone_number,email,company_name,company_industry,business_scene,business_model,is_privacy_calculation,privacy_calculation_power" +
            ",is_extra_power,need_extra_power,require_description,account,user_id) " +
            "VALUES(#{id},#{name},#{phoneNumber},#{email},#{companyName},#{companyIndustry},#{businessScene},#{businessModel},#{isPrivacyCalculation},#{privacyCalculationPower}" +
            ",#{isExtraPower},#{needExtraPower},#{requireDescription},#{account},#{userId})")
    int savaPrivateCalculation(PrivateCalculation privateCalculation) ;

//    @Select("select * from yw_privacy_evaluate where id =#{id}")
    @Select("select id ,name,phone_number phoneNumber,email,company_name companyName" +
            "  ,company_industry companyIndustry ,business_scene businessScene,business_model businessModel,is_privacy_calculation isPrivacyCalculation" +
            ",privacy_calculation_power  privacyCalculationPower,is_extra_power isExtraPower,need_extra_power needExtraPower " +
            ",require_description requireDescription ,modify_time modifyTime ,account ,user_id userId from yw_privacy_evaluate where id =#{id} ")
    PrivateCalculation getOnePrivateCalculation(String id) ;

    @Select("<script>"+
            " select id ,name,phone_number phoneNumber,email,company_name companyName,company_industry companyIndustry " +
            ",business_scene businessScene,business_model businessModel,is_privacy_calculation isPrivacyCalculation," +
            "privacy_calculation_power  privacyCalculationPower,is_extra_power isExtraPower,need_extra_power needExtraPower ," +
            "require_description requireDescription ,modify_time modifyTime ,account ,user_id userId from yw_privacy_evaluate" +
            "        <where>" +
            "            <if test=\"startTime!=null and startTime!=''\">" +
            "                 modify_time >= #{startTime}" +
            "            </if>" +
            "            <if test=\"endTime!=null and endTime!=''\">" +
            "                and modify_time &lt;= #{endTime}" +
            "            </if> " +
            "        </where>"+
           "order by modify_time  DESC"+
            "</script>"
    )
   List<PrivateCalculation> getAllPrivateCalculation(@Param("startTime") String startTime,@Param("endTime") String endTime);



    @Select("select id ,name,phone_number phoneNumber,email,company_name companyName" +
            "  ,company_industry companyIndustry ,business_scene businessScene,business_model businessModel,is_privacy_calculation isPrivacyCalculation" +
            ",privacy_calculation_power  privacyCalculationPower,is_extra_power isExtraPower,need_extra_power needExtraPower " +
            ",require_description requireDescription ,modify_time modifyTime ,account ,user_id userId from yw_privacy_evaluate where user_id =#{userId}  order by modify_time DESC")
    List<PrivateCalculation> getOwnPrivateCalculation(String userId) ;
}
