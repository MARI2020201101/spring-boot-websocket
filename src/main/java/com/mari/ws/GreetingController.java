package com.mari.ws;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

public class GreetingController {

    //requestMapping된 url(/hello) 로 들어오는 메시지가 있을때
    //모든 /topic/greetings 의 구독자들에게 응답을 전달한다
    @RequestMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception{
        //1초 쉰후 응답. 이거 조절해서 그냥 막바로 메시지 던질 수도 있다
        Thread.sleep(1000);

        String name = message.getName();
        //htmlEscape 란? 위험문자들 자동변환 -
        //ex) <> -> &lt; &dt;같이해준다
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(name) + "!");
    }
}
