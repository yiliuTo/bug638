package com.example.servicebusmultibindersdemo;


import com.microsoft.azure.spring.integration.core.AzureHeaders;
import com.microsoft.azure.spring.integration.core.api.Checkpointer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;


@EnableBinding(CustomProcessor.class)
public class SinkExample {

    @StreamListener(CustomProcessor.INPUT)
    public void handleMessage(String message, @Header(AzureHeaders.CHECKPOINTER) Checkpointer checkpointer) {
        System.out.println(String.format("[1] New message received: '%s'", message));
        checkpointer.success().handle((r, ex) -> {
            if (ex == null) {
                System.out.println(String.format("[1] Message '%s' successfully checkpointed", message));
            }
            return null;
        });
    }

    @StreamListener(CustomProcessor.INPUT1)
    public void handleMessage1(String message, @Header(AzureHeaders.CHECKPOINTER) Checkpointer checkpointer) {
        System.out.println(String.format("[2] New message received: '%s'", message));
        checkpointer.success().handle((r, ex) -> {
            if (ex == null) {
                System.out.println(String.format("[2] Message '%s' successfully checkpointed", message));
            }
            return null;
        });
    }
}