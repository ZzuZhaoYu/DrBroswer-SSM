package org.springmvc.service;

import org.springmvc.pojo.RegisterInfo;
import org.springmvc.pojo_junior.RegisterInfoJunior;

import java.util.List;

public interface FetchInfoFromMultiSourceService {
    List<RegisterInfoJunior> getCheckedListByHosId(String id);

    int updateJuniorHosReport();
}
