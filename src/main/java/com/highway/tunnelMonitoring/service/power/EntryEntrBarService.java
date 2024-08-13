package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.power.EntryEntrBar;
import com.highway.tunnelMonitoring.dto.Result;
import com.highway.tunnelMonitoring.dto.power.eltgnr.EltgnrMonitorDTO;
import com.highway.tunnelMonitoring.dto.power.entryentrbar.EntryEntrBarDTO;
import com.highway.tunnelMonitoring.dto.power.entryentrbar.EntryEntrBarMonitorDTO;
import com.highway.tunnelMonitoring.mapper.power.EntryEntrBarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryEntrBarService {

    private final EntryEntrBarMapper entryEntrBarMapper;

    public Result<EntryEntrBar> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<EntryEntrBar> list = entryEntrBarMapper.findAll(offset, size);
        int total = entryEntrBarMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    public EntryEntrBar findOne(String entry_entr_bar_no){ return entryEntrBarMapper.findOne(entry_entr_bar_no); }

    public void enroll(EntryEntrBarDTO entryEntrBarDTO){
        entryEntrBarMapper.enroll(entryEntrBarDTO);
    }

    public void update(EntryEntrBarDTO entryEntrBarDTO){
        entryEntrBarMapper.update(entryEntrBarDTO);
    }

    public void delete(String entry_entr_bar_no){
        entryEntrBarMapper.delete(entry_entr_bar_no);
    }

    public Result<EntryEntrBarMonitorDTO> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EntryEntrBarMonitorDTO> list = entryEntrBarMapper.monitor(offset, size);
        int total = entryEntrBarMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
