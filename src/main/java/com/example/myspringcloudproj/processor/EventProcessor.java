package com.example.myspringcloudproj.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor {

    @Autowired
    private StreamBridge streamBridge;

    public void process(Telemetry event) {
        streamBridge.send("process-out-0", event);
    }
}
