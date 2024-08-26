package com.nhatanh.centerlearn.admin.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class SaveTimeslotModel {
    private final int period;
    private final LocalTime timeStart;
    private final LocalTime timeEnd;
    private final String status;
    private final String description;
}
