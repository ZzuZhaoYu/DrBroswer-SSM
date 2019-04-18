package org.springmvc.dao_junior;

import org.apache.ibatis.annotations.Param;
import org.springmvc.dto.ReportJuniorDto;
import org.springmvc.pojo_junior.ReportJunior;

import java.util.Date;

public interface ReportJuniorMapper {
    int deleteByPrimaryKey(String reportcode);

    int insert(ReportJunior record);

    int insertSelective(ReportJunior record);

    ReportJunior selectByPrimaryKey(String reportcode);

    int updateByPrimaryKeySelective(ReportJunior record);

    int updateByPrimaryKey(ReportJunior record);

    int updateReportPath(String checknum);

    ReportJunior selectByChecknum(String checknum);

    int insertInto(ReportJuniorDto reportJuniorDto);

    int updateFlagByCheckNum(@Param("flag") String flag,@Param("checknum") String checknum);

    int deleteReportByCheckNum(String checknum);
}