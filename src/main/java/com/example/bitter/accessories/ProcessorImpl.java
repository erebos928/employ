package com.example.bitter.accessories;

public class ProcessorImpl implements Processor {
    @Override
    public State process(State state) {
        State s = State.builder().date(state.getDate()).temprature(state.getTemprature() + 2).build();
        return s;
    }
}
