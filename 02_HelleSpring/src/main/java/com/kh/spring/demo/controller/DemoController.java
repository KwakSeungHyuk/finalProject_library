package com.kh.spring.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DemoService;
import com.kh.spring.demo.model.vo.Dev;

@Controller
public class DemoController {

	@Autowired
	private DemoService service;
	
	
	
	@RequestMapping("/demo/demoList.do")
	public String demoList(Model m) {
		List<Dev> list=service.selectDemoList();
		m.addAttribute("list",list);
		return "demo/demoList";
	}
	
	
	
	
	
	@RequestMapping("/demo/demo.do")
	public String demo() {
		//화면전환용
		return "demo/demo";//viewresolver가 앞에는 /WEB-INF/views/ 뒤에는 .jsp
		// /WEB-INF/views/demo/demo.jsp;
	}
	
	//controller객체의 메소드는 서블릿에서 doGet/doPost메소드의 역할을 하게됨.
	//프론트에서 전송되는 데이터는 controller객체의 매소드에서 파라미터값으로 받게됨.
	//파라미터로 받을 수 있는 값! -> 파라미터로 선언하면 자동으로 스프링 대입!
	/* -- 매개변수를 선언만 하면 됨! --
	 * 1. HttpServlerRequest
	 * 2. HttpServletReseponse
	 * 3. HttpSession 
	 * 4. java.util.Locale(지역설정정보)
	 * 5. InputStream/Reader
	 * 6. OutputStream/Writer
	 * == 파라미터값을 자동으로 객체로 받을 수 있음 Command객체 ==
	 * 7. Vo객체, Map ->파라미더 값을 자동으로 대입해서 받음
	 * 8. Model -> 데이터 공유 객체로 기본 request와 비슷 
	 * 9. ModelAndView -> 데이터공유 객체 및 view에 대한 정보까지 같이 저장하는 객체
	 * 
	 * -- 특정 어노테이션을 선언하여 값을 받는 매게변수 --
	 * @RequestParam(value="parameter이름", 옵션.....) 변수선언
	 * @RequestHeader(value="해더key값") 변수선언 -> Header의 정보를 가져오는 것
	 * @CookieValue(value="쿠키key값") 변수선언 -> Cookie 값
	 * 
	 * -- 추가 매소드 선언부에 선언하는 어노테이션 --
	 * @PathVariable("값") -> restful방식으로 구현할때 URL에 있는 데이터를 가져올때 사용
	 *
	 * @ResponseBody -> 클라이언트에게 응답할때 매소드 리턴값을 JSON형태로 반환해주는 어노테이션
	 * 
	 */
	
	
	//서블릿과 동일하게 사용하기
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest req, HttpServletResponse res,
			HttpSession session) {
		Dev dev=new Dev();
		dev.setDevName(req.getParameter("devName"));
		dev.setDevAge(Integer.parseInt(req.getParameter("devAge")));
		dev.setDevEmail(req.getParameter("devEmail"));
		dev.setDevGender(req.getParameter("devGender"));
		dev.setDevLang(req.getParameterValues("devLang"));
		
		///HttpSession session=req.getSession();
		
		req.setAttribute("demo", dev);
		
		
		//저장된 session출력하기
		System.out.println("세션값 : "+session.getAttribute("userId"));
		
		
		return "demo/demoResult";
	}
	
	
	//@RequestParam어노테이션이용하기 
	//-> 클라이언트가 전송하는 값을 1:1로 매개변수로 바로 받을 수 있음 
	@RequestMapping("/demo/demo2.do")
//	public String param(
//			@RequestParam(value="devName") String devName,
//			@RequestParam(value="devAge",required = false,
//			defaultValue="1") int devAge,
//			@RequestParam(value="devEmail") String devEmail,
//			@RequestParam(value="devGender",required = false) String devGender,
//			@RequestParam(value="devLang") String[] devLang
//			,Model m) {
	public String param(String devName, int devAge, String devEmail, 
			String devGender,String[] devLang, Model m) {	
		System.out.println(devName+devAge+devEmail+devGender);
		
		Dev d=Dev.builder().devName(devName).devAge(devAge).devEmail(devEmail)
		.devGender(devGender).devLang(devLang).build();
		
		
		//Model객체를 이용해서 서버데이터 전송하기
		//데이터를 저장할때 key/value형식으로 저장. -> addAttribute()
		m.addAttribute("demo",d);//request와 생존주기 동일
		
		
		for(String l : devLang) {
			System.out.print(l+" ");
		}
		
		
		return "demo/demoResult";
	}
	
	//Command객체로 파라미터값 받아오기
	//Command객체로 지정된 객체의 멤버변수와 파라미터의 key값이 일치해야 대입을 해줌
	//default생성자로 생성 후 setter로 값을 대입 -> 메소드명명규칙을 준수!
	//주의 기본 자료형을 제외한 자료형(객체자료형)이 있으면 대입이 제한.
	@RequestMapping("/demo/demo3.do")
	public String demo3(Dev dev,Model m) {
		m.addAttribute("demo",dev);
		
		return "demo/demoResult";
	}
	
	//기본자료형 -> 배열 X	
	@RequestMapping("/demo/demo4.do")
	public String demo4(@RequestParam Map param,String[] devLang, Model m) {
		System.out.println(param);
		for(String d : devLang) {
			System.out.println(d);
		}
		param.put("devLang",devLang);
		
		m.addAttribute("demo",param);
		
		return "demo/demoResult";
	}
	
	//추가데이터 매개변수로 받기 Header정보, Cookie
	@RequestMapping("/demo/demo5.do")
	public String demo5(@RequestHeader(value="User-agent") String userAgent,
			@RequestHeader(value="Referer") String prevPage,
			@CookieValue(value="choco",required = false) String snack) {
		System.out.println(userAgent);
		System.out.println(prevPage);
		System.out.println(snack);
		return "demo/demo";
	}
	
	@RequestMapping("/demo/insertDev.do")
	public String insertDev(Dev dev) {
		//Service의 인서트서비스 호출
		int rsult=service.insertDemo(dev);
		
		return "demo/demo";
	}
}
