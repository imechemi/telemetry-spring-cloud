package com.example.myspringcloudproj.processor;

public class Telemetry {

    private String deviceId;

    public Telemetry(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
