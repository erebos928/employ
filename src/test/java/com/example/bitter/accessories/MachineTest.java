package com.example.bitter.accessories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class MachineTest {
    @Mock
    ProcessorImpl mockProcessor;
    @InjectMocks
    Machine machine;
    @Captor
    ArgumentCaptor<State> captor;
    @Test
    void processTest() {

        State currentState = State.builder().temprature(18).date(LocalDate.now()).build();
        machine.setCurrentState(currentState);
        Mockito.when(mockProcessor.
                process(ArgumentMatchers.argThat(s -> s.getTemprature() == 18))).
                thenReturn(State.builder().date(currentState.getDate()).temprature(21).build());
        machine.changeState();
        Mockito.verify(mockProcessor).process(captor.capture());
        Assertions.assertNotNull(captor.getValue());
        Assertions.assertEquals(18,captor.getValue().getTemprature());
        Assertions.assertNotNull(machine.getCurrentState());
        Assertions.assertEquals(21,machine.getCurrentState().getTemprature());
    }
    @Test
    void testConstant(){

    }
}