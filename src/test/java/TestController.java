import static org.junit.Assert.*;

import java.awt.print.Printable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/webmvc-basic-config.xml"})
//@ContextConfiguration
//@ContextConfiguration(classes={AppConfig.class})
//@ContextConfiguration(locations={"/resources/spring/webmvc-basic-config.xml", "/test-config.xml"})
//@ContextConfiguration(classes={AppConfig.class, TestConfig.class})
//@ActiveProfiles("dev")
public class TestController {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mock;
	
	@Before
	public void beforeTest(){
		System.out.println("1.컨트롤러 메서드에 요청을 보내는 목 생성");
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test() throws Exception {
//		fail("Not yet implemented");
//		http://doublesprogramming.tistory.com/175
		RequestBuilder req = MockMvcRequestBuilders.post("/2131")
													.param("key", "value");
		ResultActions rtn = mock.perform(req).andDo(print());
		int body = rtn.andReturn().getResponse().getStatus();//.getContentAsString();
		System.out.println("body : "+body);
	}

}
