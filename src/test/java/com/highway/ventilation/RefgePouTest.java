package com.highway.ventilation;

import com.highway.ventilation.domain.RefgePouVO;
import com.highway.ventilation.dto.RefgePouGetDTO;
import com.highway.ventilation.mapper.RefgePouMapper;
import com.highway.ventilation.service.RefgePouService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RefgePouTest {

    @Autowired
    private RefgePouMapper refgePouMapper;

    @Autowired
    private RefgePouService refgePouService;

    @Test
    public void 방화문_조회_테스트() throws Exception{
        //given

        //when
        List<RefgePouVO> list = refgePouService.findAll();
        //then
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void 방화문_등록_테스트() throws Exception{
        //given
        RefgePouGetDTO refgePouGetDTO = new RefgePouGetDTO();
        refgePouGetDTO.setMakr_nm("123");
        refgePouGetDTO.setInstl_de("42");
        refgePouGetDTO.setInstl_lc("52");
        refgePouGetDTO.setInstl_milg(2);
        refgePouGetDTO.setX_crdnt(123);
        refgePouGetDTO.setY_crdnt(456);
        //when
        refgePouService.enroll(refgePouGetDTO);
        List<RefgePouVO> list = refgePouService.findAll();
        //then
        Assertions.assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void 방화문_업데이트_테스트() throws Exception{
        //given
        String pouNo = String.format("%-11s", "pou1");
        RefgePouGetDTO refgePouGetDTO = new RefgePouGetDTO();
        refgePouGetDTO.setInstl_lc("54");
        refgePouGetDTO.setX_crdnt(123);
        refgePouGetDTO.setPou_no(pouNo);
        //when
        refgePouService.update(refgePouGetDTO);
        /**
         * db상에선 no로 체크 되어있기 때문에 좀 골치아프네 ㅁㅎㅁㅎ
         */

        RefgePouVO vo = refgePouService.findOne(pouNo);

        //then
        Assertions.assertThat(vo.getX_crdnt()).isEqualTo(123);
    }

    @Test
    public void 방화문_삭제_테스트() throws Exception{
        //given
        String pouNo = String.format("%-11s", "pou1");
        //when
        refgePouService.delete(pouNo);
        List<RefgePouVO> list = refgePouService.findAll();
        //then
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
