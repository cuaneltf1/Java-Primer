package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.DistanceUnit;
import com.example.entity.SpeedResult;
import com.example.exception.BadDataException;
import com.example.exception.BadRequestException;

public class SpeedResultController {
	
	@Autowired
	private CrudFeignService crudFeignService;
	private ConvertFeignService convertFeignService;
	
	@RequestMapping(value="/api/experiment", method=RequestMethod.POST)
	String getSpeedResult(@RequestBody SpeedResult speedresult) {
		        try {
		        	if(speedresult.getUnit()>0)return crudFeignService.save(speedresult);
		        } catch (IllegalArgumentException e) {
		            throw new BadRequestException();
		        }

		        throw new BadDataException();
	}
	
//	Method: GET URL: /api/experiment?subjectName="Drop tennis ball”&convertTo=”Feet" 
	@RequestMapping(value="/api/experiment?subjectName=\\{name}&convertTo= {unit}", method=RequestMethod.GET)
	List<SpeedResult> convertSpeedResult(@PathVariable("name") String name, @PathVariable("unit") String unit) {
		List<SpeedResult> list = crudFeignService.findByName(name);
		List<SpeedResult> res = null;
		for (SpeedResult speedResult: list) {
			DistanceUnit fromUnit = speedResult.getDistanceUnit();			
			Double newUnit = convertFeignService.convert(speedResult.getUnit(),fromUnit.toString(),unit);
			speedResult.setDistanceUnit(DistanceUnit.valueOf(unit));
			speedResult.setUnit(newUnit);
			res.add(speedResult);
		}
		return res;
	}

}
