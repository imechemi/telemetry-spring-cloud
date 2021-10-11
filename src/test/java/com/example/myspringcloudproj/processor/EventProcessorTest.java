package com.example.myspringcloudproj.processor;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class EventProcessorTest {

    @Autowired
    private OutputDestination outputDestination;

    @InjectMocks
    private EventProcessor eventProcessor;

    @Test
    void shouldPublishEvent() {
        Telemetry telemetry = new Telemetry("device-id-0");
        eventProcessor.process(telemetry);

        Message<byte[]> message = outputDestination.receive(10000, "process-out-0");
        assertThat(message).isNotNull();
        assertThat(new String(message.getPayload())).isEqualTo("hello foo");
    }
}
