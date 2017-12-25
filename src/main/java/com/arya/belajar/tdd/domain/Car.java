package com.arya.belajar.tdd.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    private String type;
    private String name;
}
