package com.mari.ws;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {

    //hello message를 받으면 -> greeting으로 응답할 것이다.
    private String content;
}
