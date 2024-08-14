package com.highway.tunnelMonitoring.service.power;

import com.highway.tunnelMonitoring.domain.Result;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBar;
import com.highway.tunnelMonitoring.domain.power.entryentrbar.EntryEntrBarSttus;
import com.highway.tunnelMonitoring.mapper.power.EntryEntrBarMapper;
import com.highway.tunnelMonitoring.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntryEntrBarService implements CrudService<EntryEntrBar, String> {

    private final EntryEntrBarMapper entryEntrBarMapper;

    @Override
    public Result<EntryEntrBar> findAll(int page, int size) {
        int offset = (page - 1) * size;
        List<EntryEntrBar> list = entryEntrBarMapper.findAll(offset, size);
        int total = entryEntrBarMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }

    @Override
    public EntryEntrBar findOne(String entry_entr_bar_no){ return entryEntrBarMapper.findOne(entry_entr_bar_no); }

    @Override
    public void enroll(EntryEntrBar entryEntrBar){
        entryEntrBarMapper.enroll(entryEntrBar);
    }

    @Override
    public void update(EntryEntrBar entryEntrBar){
        entryEntrBarMapper.update(entryEntrBar);
    }

    @Override
    public void delete(String entry_entr_bar_no){
        entryEntrBarMapper.delete(entry_entr_bar_no);
    }

    public Result<EntryEntrBarSttus> monitor(int page, int size) {
        int offset = (page - 1) * size;
        List<EntryEntrBarSttus> list = entryEntrBarMapper.monitor(offset, size);
        int total = entryEntrBarMapper.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        return new Result<>(list, total, page, totalPages);
    }
}
