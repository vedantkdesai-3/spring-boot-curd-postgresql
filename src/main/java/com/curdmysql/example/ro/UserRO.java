package com.curdmysql.example.ro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRO{

    private Long id;
    private String name;
    private String address;

}