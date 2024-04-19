package com.highway.ventilation.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketSampleController {

    @MessageMapping("/sample")
    @SendTo("/topic/sample")
    public Object sample(Object whatcomehere) throws Exception{
        Thread.sleep(1000);
        Object str = "메시지? 데이터? 가공하는곳 그리고 반환을 하여 topic한테 보내줌";
        /**
         * 이부분에 데이터 가공한걸 db에 저장하고 잘 저장이 되었다고 문자 반환 하자.
         */
        return str;
    }
}
