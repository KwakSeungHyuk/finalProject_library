package com.kh.spring.memo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.memo.model.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemoController {
	@Autowired
	private MemoService service;
	
	@RequestMapping("/memo/memo.do")
	public ModelAndView memo(ModelAndView mv) {
		log.debug("memo메소드 실행중");
		mv.addObject("list", service.selectMemoList());
		mv.setViewName("memo/memo");
		return mv;
	}
	
	@RequestMapping("/memo/memoInsert.do")
	public String memoInput(@RequestParam Map param) {
			int result=service.memeInsert(param);
			return "redirect:/memo/memo.do";
	}
	
	
}
