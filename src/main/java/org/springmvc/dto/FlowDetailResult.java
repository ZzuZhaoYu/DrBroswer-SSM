package org.springmvc.dto;

import java.util.List;

public class FlowDetailResult<T> {
    private String checknum;
    private String patname;
    private String sex;
    private String age;
    private String pattype;
    private String modality;
    private String remotehos;
    private String status;
    private String uploaddocname;
    private String uploaddate;
    private String allocatedocname;
    private String allocatedate;
    private List<T> list;

    public String getChecknum() {
        return checknum;
    }

    public void setChecknum(String checknum) {
        this.checknum = checknum;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPattype() {
        return pattype;
    }

    public void setPattype(String pattype) {
        this.pattype = pattype;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getRemotehos() {
        return remotehos;
    }

    public void setRemotehos(String remotehos) {
        this.remotehos = remotehos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getUploaddocname() {
        return uploaddocname;
    }

    public void setUploaddocname(String uploaddocname) {
        this.uploaddocname = uploaddocname;
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(String uploaddate) {
        this.uploaddate = uploaddate;
    }

    public String getAllocatedocname() {
        return allocatedocname;
    }

    public void setAllocatedocname(String allocatedocname) {
        this.allocatedocname = allocatedocname;
    }

    public String getAllocatedate() {
        return allocatedate;
    }

    public void setAllocatedate(String allocatedate) {
        this.allocatedate = allocatedate;
    }

    public FlowDetailResult(String checknum, String patname, String sex, String age, String pattype, String modality, String remotehos, String status, String uploaddocname, String uploaddate, String allocatedocname, String allocatedate, List<T> list) {
        this.checknum = checknum;
        this.patname = patname;
        this.sex = sex;
        this.age = age;
        this.pattype = pattype;
        this.modality = modality;
        this.remotehos = remotehos;
        this.status = status;
        this.uploaddocname = uploaddocname;
        this.uploaddate = uploaddate;
        this.allocatedocname = allocatedocname;
        this.allocatedate = allocatedate;
        this.list = list;
    }

    public FlowDetailResult() {
    }

    @Override
    public String toString() {
        return "FlowDetailResult{" +
                "checknum='" + checknum + '\'' +
                ", patname='" + patname + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", pattype='" + pattype + '\'' +
                ", modality='" + modality + '\'' +
                ", remotehos='" + remotehos + '\'' +
                ", status='" + status + '\'' +
                ", uploaddocname='" + uploaddocname + '\'' +
                ", uploaddate='" + uploaddate + '\'' +
                ", allocatedocname='" + allocatedocname + '\'' +
                ", allocatedate='" + allocatedate + '\'' +
                ", list=" + list +
                '}';
    }
}
