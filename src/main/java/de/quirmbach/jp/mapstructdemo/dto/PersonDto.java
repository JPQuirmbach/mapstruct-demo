package de.quirmbach.jp.mapstructdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {

    private String personId;
    private String firstName;
    private String surName;
}
