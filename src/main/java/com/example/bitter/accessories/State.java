package com.example.bitter.accessories;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class State {
    private int temprature;
    private LocalDate date;
}
