package com.example.bitter.accessories;

import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
@Profile("constant")
public class ProcessorImpl2 implements Processor {
    @Override
    public State process(State state) {
        return State.builder().temprature(-90).date(LocalDate.now()).build();
    }
}
