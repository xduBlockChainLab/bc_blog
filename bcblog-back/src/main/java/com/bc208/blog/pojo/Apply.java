package com.bc208.blog.pojo;

import lombok.Data;

@Data
public class Apply {
    private String email;
    private String phone;
    private int sort;
    private String description;
    private int year;
    private String[] interests;
    private int way;

}
