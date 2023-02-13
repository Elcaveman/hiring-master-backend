package com.example.hiringMaster.dto.activity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ActivityFinishedDto {
    private long id;
    private boolean finished;
}
