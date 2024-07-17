package com.highway.ventilation.domain.jetpan;

import lombok.Getter;
import lombok.Setter;

/**
 * 제트팬
 */
@Getter
@Setter
public class JetPan {

    private String id; //기본키
    private String link; //링크(fk)키
    private String makrNm; //제조사명
    private String modelNm; //모델명
    private String instlLc; //설치위치
    private String instlDe; //설치일자
    private int instlMilg; //설치이정
    private int pero; //내구연한
    private char deleteAt; //삭제여부
    private int xCrdnt; //x좌표
    private int yCrdnt; //y좌표
    private String venVsMsrinsNo; //가시도(fk)키
    private String cmoMsrinsNo; //일산화탄소(fk)키
    private String wdPblmrlSmNo; //풍향(fk)키
    private String inshltNo; //백엽상(fk)키


}

