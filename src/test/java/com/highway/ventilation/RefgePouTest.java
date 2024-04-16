package com.highway.ventilation;

import com.highway.ventilation.domain.RefgePouVO;
import com.highway.ventilation.mapper.RefgePouMapper;
import com.highway.ventilation.service.RefgePouService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class RefgePouTest {

    @Autowired
    private RefgePouMapper refgePouMapper;

    @Autowired
    private RefgePouService refgePouService;

    @Test
    public void 방화문_조회_테스트() throws Exception{
        //given

        //when
        List<RefgePouVO> list = refgePouMapper.findAll();
        //then
        Assertions.assertThat(list.size()).isEqualTo(3);
    }
}
