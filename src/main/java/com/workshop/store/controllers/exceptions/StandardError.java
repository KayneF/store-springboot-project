package com.workshop.store.controllers.exceptions;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError {
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
                timezone = "GMT")
    private Instant timestamp;
	private Integer status;
	private String error;
	private String mesage;
	private String path;


    public StandardError() {}
    public StandardError(Instant timestamp, Integer status, String error, String mesage, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.mesage = mesage;
        this.path = path;
    }


    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMesage() {
        return mesage;
    }
    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
