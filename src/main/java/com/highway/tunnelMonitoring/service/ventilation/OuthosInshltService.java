package com.highway.tunnelMonitoring.service.ventilation;

import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousInshlt;
import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.ventilation.inshlt.OuthousWetherSttus;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OuthosInshltService implements CrudService<OuthousInshlt> {

    private final OuthosInshltMapper outhosInshltMapper;

    @Override
    public Result<OuthousInshlt> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<OuthousInshlt> list = outhosInshltMapper.findAll(offset, size);
        int total = outhosInshltMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    public OuthousInshlt findOne(String inshlt_no){ return outhosInshltMapper.findOne(inshlt_no); }

    @Override
    public void enroll(OuthousInshlt outhousInshlt){
        outhosInshltMapper.enroll(outhousInshlt);
    }

    @Override
    public void update(OuthousInshlt outhousInshlt){
        outhosInshltMapper.update(outhousInshlt);
    }

    @Override
    public void delete(OuthousInshlt outhousInshlt){
        outhosInshltMapper.delete(outhousInshlt);
    }

    public Result<OuthousWetherSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<OuthousWetherSttus> list = outhosInshltMapper.monitor(offset, size);
        int total = outhosInshltMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
