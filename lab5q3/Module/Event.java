package com.example.lab5q3.Module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {

    private String ID;
    private String description;
    private int capacity;
    private String startDate;
    private String endDate;
}
