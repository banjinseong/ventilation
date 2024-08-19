package com.highway.tunnelMonitoring.service;

import com.highway.tunnelMonitoring.domain.Result;

public interface CrudService<T> {
    Result<T> findAll(int page, int size);
//    T findOne(ID id);
    void enroll(T dto);
    void update(T dto);
    void delete(T dto);
}
