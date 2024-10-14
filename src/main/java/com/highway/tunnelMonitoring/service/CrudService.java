package com.highway.tunnelMonitoring.service;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.lght.Lght;

public interface CrudService<T> {
    Result<T> findAll(String linkId, int page, int size, String sortColumn, String sortDirection);
//    T findOne(ID id);
    void enroll(T dto);
    void update(T dto);
    void delete(T dto);

}
