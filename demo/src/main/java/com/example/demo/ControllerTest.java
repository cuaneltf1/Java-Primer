package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import com.example.entity.SpeedResult;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration

public class ControllerTest {
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
	@Test
	void getSpeedResult() throws Exception {
		String speedResult = "{\"subjectName\": \"Drop tennis ball\",  \"speed\": {\"duration\": 11,\"distance\": {\"unit\": 2.5,\"distanceUnit\": \"Yards\"   }  },  \"experimentTime\": \"02-03-2020 12:25:00\" }";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/experiment")
				.content(speedResult).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	void convertSpeedResult() throws Exception {
		String speedResult = "{\"subjectName\": \"Drop tennis ball\",  \"speed\": {\"duration\": 11,\"distance\": {\"unit\": 2.5,\"distanceUnit\": \"Yards\"   }  },  \"experimentTime\": \"02-03-2020 12:25:00\" }";

		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/experiment?subjectName=\\{name}&convertTo= {unit}")
				.content(speedResult).contentType(MediaType.APPLICATION_JSON).param("Drop tennis bal","Feet"))		
		.andExpect(status().isOk()).andDo(print());
	}


}