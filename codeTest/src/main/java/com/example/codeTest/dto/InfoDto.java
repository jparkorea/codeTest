package com.example.codeTest.dto;

import java.util.HashMap;
import java.util.List;

import lombok.Data;


@Data
public class InfoDto {
    public HashMap<String, Object> meta;
    public List<Documents> documents;

    public String query;
}

