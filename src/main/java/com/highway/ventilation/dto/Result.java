package com.highway.ventilation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Result<T> {
    private List<T> data;
    private int total;
    private int currentPage;
    private int totalPages;
}
