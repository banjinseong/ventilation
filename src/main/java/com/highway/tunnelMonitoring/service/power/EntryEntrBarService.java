package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.eltgnr.EltgnrRunHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarFaultHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarRunHistory;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import com.highway.tunnelMonitoring.mapper.power.EntryEntrBarMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryEntrBarService implements CrudService<EntryEntrBar> {

    private final EntryEntrBarMapper entryEntrBarMapper;

    @Override
    public Result<EntryEntrBar> findAll(String linkId, int page, int size, String sort_column, String sort_direction) {
        int offset = (page - 1) * size;
        List<EntryEntrBar> list = entryEntrBarMapper.entryEntrBarFindAll(linkId, offset, size);
        int total = entryEntrBarMapper.entryEntrBarCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

//    @Override
//    public EntryEntrBar findOne(String entry_entr_bar_no){ return entryEntrBarMapper.findOne(entry_entr_bar_no); }

    @Override
    public void enroll(EntryEntrBar entryEntrBar){
        entryEntrBarMapper.entryEntrBarEnroll(entryEntrBar);
    }

    @Override
    public void update(EntryEntrBar entryEntrBar){
        entryEntrBarMapper.entryEntrBarUpdate(entryEntrBar);
    }

    @Override
    public void delete(EntryEntrBar entryEntrBar){
        entryEntrBarMapper.entryEntrBarDelete(entryEntrBar);
    }

    public Result<EntryEntrBarSttus> monitor(String linkId, int page, int size, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EntryEntrBarSttus> list = entryEntrBarMapper.entryEntrBarMonitor(linkId, offset, size, sortColumn, sortDirection);
        int total = entryEntrBarMapper.entryEntrBarMonitorCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public Result<EntryEntrBarFaultHistory> faultHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EntryEntrBarFaultHistory> list = entryEntrBarMapper.entryEntrBarFaultHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = entryEntrBarMapper.entryEntrBarFaultCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }

    public Result<EntryEntrBarRunHistory> runHistory(String linkId, int page, int size, LocalDateTime startDate, LocalDateTime endDate, String sortColumn, String sortDirection) {
        int offset = (page - 1) * size;
        List<EntryEntrBarRunHistory> list = entryEntrBarMapper.entryEntrBarRunHistory(linkId, offset, size, startDate, endDate, sortColumn, sortDirection);
        int total = entryEntrBarMapper.entryEntrBarRunCountAll(linkId);
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);

    }
}
