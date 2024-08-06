package com.highway.tunnelMonitoring.mapper.power;

import com.highway.tunnelMonitoring.domain.power.EmgncTlphon;
import com.highway.tunnelMonitoring.domain.power.EntryEntrBar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EntryEntrBarMapper {
    
    List<EntryEntrBar> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    EntryEntrBar findOne(String entry_entr_bar_no);
    //데이터 등록
    void enroll(EntryEntrBar entryEntrBar);
    //데이터 업데이트
    void update(EntryEntrBar entryEntrBar);

    //데이터 삭제
    void delete(String entry_entr_bar_no);
}
