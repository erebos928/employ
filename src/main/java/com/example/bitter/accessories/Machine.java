package com.example.bitter.accessories;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class Machine {
    private State currentState;
    @Autowired
    private Processor processor;
    public void changeState(){
        currentState = processor.process(currentState);
    }
}
