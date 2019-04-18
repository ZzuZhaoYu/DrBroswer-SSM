package org.springmvc.dao;

import org.springmvc.pojo.Source;

import java.util.List;

public interface SourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);

    List<Source> getAllSource();

    String getReportImageBasePath(String id);
}