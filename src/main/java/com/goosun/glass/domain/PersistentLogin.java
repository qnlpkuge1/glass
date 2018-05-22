package com.goosun.glass.domain;

import java.io.Serializable;
import java.util.Date;

public class PersistentLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    private String series;
    private String username;
    private String token;
    private Date lastUsed;

    public PersistentLogin() {}

    public PersistentLogin(String series, String username, String token, Date lastUsed) {
        this.series = series;
        this.username = username;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getSeries() {
        return series;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}
