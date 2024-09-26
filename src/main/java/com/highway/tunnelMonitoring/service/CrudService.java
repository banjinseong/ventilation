package com.highway.tunnelMonitoring.service;

import com.highway.tunnelMonitoring.domain.Result;

public interface CrudService<T> {
    Result<T> findAll(String linkId, int page, int size, String sort_column, String sort_direction);
//    T findOne(ID id);
    void enroll(T dto);
    void update(T dto);
    void delete(T dto);
}
