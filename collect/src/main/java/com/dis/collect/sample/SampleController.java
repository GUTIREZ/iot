package com.dis.collect.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="sample")
public class SampleController {
	
	@Autowired
	SampleRepository sampleRepository;
	
	@RequestMapping
	public String home() {
		return "welcome";
	}
	
    @RequestMapping(value="hello")
    String hello() {
        return "Hello World!";
    }
    
    @RequestMapping(value="/hi/{name}/{email}")
	public String insertUserParam1(@PathVariable String name,@PathVariable String email) {
        
        return "hi "+name+email;
	}
    
	@RequestMapping(value="/save/{name}/{email}")
	public SampleDomain insertSampleParam(@PathVariable String name,@PathVariable String email) {
		
		SampleDomain sample = new SampleDomain();
		sample.setName(name);
		sample.setEmail(email);
		sample = sampleRepository.create(sample); 
        
        return sample;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteSampleParam(@PathVariable Integer id) {
		sampleRepository.delete(id); 
        
        return "删除成功";
	}
}