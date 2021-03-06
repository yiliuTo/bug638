package com.example.servicebusmultibindersdemo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface CustomProcessor {

    String INPUT = "input";

    String OUTPUT = "output";

    String INPUT1 = "input1";

    String OUTPUT1 = "output1";

    @Input(CustomProcessor.INPUT)
    SubscribableChannel input();

    @Output(CustomProcessor.OUTPUT)
    MessageChannel output();

    @Input(CustomProcessor.INPUT1)
    SubscribableChannel input1();

    @Output(CustomProcessor.OUTPUT1)
    MessageChannel output1();

}
