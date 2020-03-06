package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entity.*;

@FeignClient(name="speedresult-repository")
public interface CrudFeignService {
	
	@RequestMapping(value="api/SpeedResult/save",method=RequestMethod.POST)
	String save(@RequestBody SpeedResult speedresult);
	
	@RequestMapping(value = "api/speedresult/{name}",method=RequestMethod.GET)
	List<SpeedResult> findByName(@PathVariable("name") String name);

}
