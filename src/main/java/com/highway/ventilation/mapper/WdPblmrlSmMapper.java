package com.highway.ventilation.mapper;

import com.highway.ventilation.domain.refgepou.RefgePou;
import com.highway.ventilation.domain.wdpblmrl.WdPblmrlSm;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.dto.WdPblmrlSmGetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WdPblmrlSmMapper {
    
    List<WdPblmrlSm> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int countAll();
    //하나만 조회
    WdPblmrlSm findOne(String wd_pblml_sm_no);
    //데이터 등록
    void enroll(WdPblmrlSmGetDTO wdPblmrlSmGetDTO);
    //데이터 업데이트
    void update(WdPblmrlSmGetDTO wdPblmrlSmGetDTO);

    //데이터 삭제
    void delete(String wd_pblml_sm_no);
}
