package com.zengkai;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		//让每个测试用例启动之前都构建这样一个启动项
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	//测试接口/car/all
	@Test
	public void allCars() throws Exception{
		//MockMvcRequestBuilders构建GET请求
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/car/all")
						//请求参数
//						.param("token", "asfsafqfEQFFA$@%%4")
						//请求编码和数据格式为json和UTF8
						.contentType(MediaType.APPLICATION_JSON_UTF8))
						//期望的返回值 或者返回状态码	
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andReturn().getResponse().getContentAsString()
				;
						//.andExpect(MockMvcResultMatchers.jsonPath("$.carInfo.model").value("zyy"));
		System.out.println(result);

	}

	//测试接口/car/allRecord
	@Test
	public void allRecord() throws Exception{
		//MockMvcRequestBuilders构建GET请求
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/car/allRecord")
				//请求参数
				.param("userName", "zeng")
				//请求编码和数据格式为json和UTF8
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				//期望的返回值 或者返回状态码
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString()
				;
		//.andExpect(MockMvcResultMatchers.jsonPath("$.carInfo.model").value("zyy"));
		System.out.println(result);

	}

	//测试接口 /car/rental
	@Test
	public void rentalCar() throws Exception{
		String content = "{\"userName\":\"zeng\",\"model\":\"Toyota Camry\",\"startDate\":\"2021-5-15\",\"endDate\":\"2021-5-17\"}";

		//MockMvcRequestBuilders构建POST请求
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/car/rental")
				//请求编码和数据格式为json和UTF8
				.contentType(MediaType.APPLICATION_JSON)
				//请求的参数，为json的格式
				.content(content))
				//期望的返回值 或者返回状态码
//				.andExpect(MockMvcResultMatchers.status().isOk())
				//返回请求的字符串信息
				.andReturn().getResponse().getContentAsString();
		System.out.println("结果：" + result);

	}

	//测试 /car/returnCar接口
	@Test
	public void returnCar() throws Exception{
		String content = "{\"recordId\": 9}";

		//MockMvcRequestBuilders构建POST请求
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/car/returnCar")
				//请求编码和数据格式为json和UTF8
				.contentType(MediaType.APPLICATION_JSON)
				//请求的参数，为json的格式
				.content(content))
				//期望的返回值 或者返回状态码
//				.andExpect(MockMvcResultMatchers.status().isOk())
				//返回请求的字符串信息
				.andReturn().getResponse().getContentAsString();
		System.out.println("结果：" + result);

	}
}