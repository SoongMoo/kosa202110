package kosaShoppingMall.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.service.member.MemberDetailService;

@Controller
public class JsonController {
	@RequestMapping(value= "jsonMian")
	public String jsonMain() {
		return "thymeleaf/json/jsonMain";
	}
	
	@RequestMapping("json1")
	public String json1() {
		return "thymeleaf/json/jsonTest";
	}
	
	@Autowired
	MemberDetailService memberDetailService;
	@RequestMapping("ajax")
	public void ajaxView(@RequestParam("id") String id,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("utf-8");
		String personJson;
		MemberDTO member = memberDetailService.execute(id, model);
		if(member != null) {
			personJson = "{"
					+ "\"memberName\": \"" + member.getMemberName() +"\""
					+ ",\"memberAddr\":\"" + member.getMemberAddr() +"\""
					+ "}";
			System.out.println(personJson);
		}else{
	        personJson = "null";
	    }
		try {
			response.getWriter().print(personJson); // json형태의 문자열로 전달
		}catch(Exception e) {}
	}
	
	@RequestMapping("json2")
	public String json2() {
		return "thymeleaf/json/jsonTest1";
	}
	@RequestMapping("ajax1")
	public void ajax1(@RequestParam("id") String id,
			HttpServletResponse response, Model model) {
		ObjectMapper mapper = new ObjectMapper();
		MemberDTO member = memberDetailService.execute(id, model);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(mapper.writeValueAsString(member));
		}catch(Exception e) {}
	}
	@RequestMapping("json3")
	public String ajax1() {
		return "thymeleaf/json/jsonTest2";
	}
	
	@RequestMapping(value= "/ajax2")
	public @ResponseBody MemberDTO AjaxView2(@RequestParam("id") String id,
	        HttpServletResponse response, Model model)  {
		MemberDTO member = memberDetailService.execute(id, model);
	    return member;
	}
	
	@RequestMapping(value= "/json4")
	public String jsonForm4() {
		return "thymeleaf/json/jsonTest3";
	}
	
	@RequestMapping(value= "/ajax3")
	public @ResponseBody ModelAndView ajax3( @RequestParam("id") String id, Model model)  {  
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");	
		//memberDetailService.execute(id, model);
		
		MemberDTO member = memberDetailService.execute(id, model);
		mav.addObject("member", member);
	    //model.addAttribute("member", member);
	    return mav;
	}
}