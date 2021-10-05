package com.company.clientappwithredis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetDTO
{
    private int Id;
    private String name;
    private int age;
}
