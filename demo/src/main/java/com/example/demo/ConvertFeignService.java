package com.example.demo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="distanceunit-repository")
public interface ConvertFeignService {
	
	@RequestMapping(value="/api/convert/{from}/to/{to}",method=RequestMethod.GET)
    public Double convert(@RequestParam Double unit, @PathVariable String from, @PathVariable String to);
   
}




