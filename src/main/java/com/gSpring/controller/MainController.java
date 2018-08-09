package com.gSpring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private Logger logger = Logger.getLogger(getClass());
		
	@RequestMapping(value = "/")
	@ResponseBody
	public String home(final HttpServletRequest req, HttpServletResponse res,ModelMap mMap) {
		logger.info("메인화면 Controller");
		return "한글";
	}
	
/*
 컨트롤러 메서드 리턴 타입
 - ModelAndView : 뷰 정보 및 모델 정보를 담고 있는 ModelAndView 객체
 - Model : 뷰에 전달할 객체 정보를 담고 있는 Model을 리턴, 뷰 이름은 요청 URL로 부터 결정(RequestTOViewNameTranslator를 통해 뷰 결정)
 - Map : 뷰에 전달할 객체 정보를 담고 있는 Map을 리턴, 뷰 이름은 요청 URL로 부터 결정(RequestTOViewNameTranslator를 통해 뷰 결정)
 - String : 뷰 이름을 리턴
 - View 객체 : View 객체를 직접 리턴, 해당 View 객체를 이용해서 뷰를 생성
 - void : 메서드가 ServletResponse나 HttpServletResponse 타입의 파라미터를 갖는 경우 메서드가 직접 응답을 처리한다고 가정, 
 		    그렇지 않을 경우 요청 뷰 이름은 요청 URL로부터 결정
 - @ResponseBody : 메서드에서 @ResponseBody 애노테이션이 적용된 경우 리턴 객체를 HTTP 응답으로 전송,    
 				   HttpMessageConverter를 이용해서 객체를 HTTP 응답 스트림으로 변환
 */
	
	@RequestMapping(value = "/2131")
	public void test(Model model) {
		model.addAttribute("name", "tester");
		logger.info("Model test");
	}
	
	@RequestMapping(value = "/test1")
	@ResponseBody
	public ModelAndView test(ModelAndView mv) {
		mv.addObject("name", "developer");
//		mv.setViewName("test");
		logger.info("ModelAndView test");		
		return mv;		
	}
}
