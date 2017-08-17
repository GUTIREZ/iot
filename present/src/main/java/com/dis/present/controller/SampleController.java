package com.dis.present.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="sample")
public class SampleController {
	@RequestMapping
	public String home() {
		return "welcome";
	}
	
    @RequestMapping(value="hello")
    String hello() {
        return "Hello World!";
    }
}