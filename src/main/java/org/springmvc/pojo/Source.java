package org.springmvc.pojo;

public class Source {
    private String id;

    private String hosId;

    private String ip;

    private String account;

    private String pwd;

    private String reportImagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHosId() {
        return hosId;
    }

    public void setHosId(String hosId) {
        this.hosId = hosId == null ? null : hosId.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getReportImagePath() {
        return reportImagePath;
    }

    public void setReportImagePath(String reportImagePath) {
        this.reportImagePath = reportImagePath == null ? null : reportImagePath.trim();
    }
}