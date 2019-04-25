package org.springmvc.dao_junior;

import org.apache.ibatis.annotations.Param;
import org.springmvc.pojo_junior.RegisterInfoJunior;

import java.util.List;

public interface RegisterInfoJuniorMapper {
    int deleteByPrimaryKey(String checknum);

    int insert(RegisterInfoJunior record);

    int insertSelective(RegisterInfoJunior record);

    RegisterInfoJunior selectByPrimaryKey(String checknum);

    int updateByPrimaryKeySelective(RegisterInfoJunior record);

    int updateByPrimaryKey(RegisterInfoJunior record);

    List<RegisterInfoJunior> selectByFlag(String flag);

    RegisterInfoJunior selectByRecordId(String checknum);

    RegisterInfoJunior selectByCheckNum(String checknum);

    int updateInfo(@Param("examItemCode") String examItemCode,@Param("examItemName") String examItemName,@Param("Age") Integer Age,@Param("AgeType") String AgeType,
                   @Param("patName") String patName,@Param("patGender") String patGender,@Param("checkNum") String checkNum);
}