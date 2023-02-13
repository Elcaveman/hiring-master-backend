package com.example.hiringMaster.dto.profile;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileIdDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
