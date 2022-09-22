package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.mapper.TimeMapper;

@Controller
public class TimeController {

    @Autowired
    private TimeMapper timeMapper;

    @GetMapping("/now")
    public void now(){
        System.out.println("TimeController now");
        System.out.println(timeMapper.getTime());
    }
}
