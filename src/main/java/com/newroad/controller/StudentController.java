package com.newroad.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.newroad.entity.Student;
import com.newroad.service.StudentServiceIf;

@Controller
public class StudentController {
	@Resource
	StudentServiceIf studentServiceImp;
	
	@RequestMapping(value="/main")
	public String list1() {
		return "login";
	}
	@RequestMapping("/liststu.do")
	public ModelAndView list(HttpServletRequest req,HttpServletResponse resp) {
		Student student=new Student(new BigDecimal(123),"张三","男",(short)12,new BigDecimal(1));
		List<Student> students=new ArrayList<Student>();
		Collections.addAll(students, student);
		ModelAndView mv=new ModelAndView();
		mv.addObject("students", students);
		mv.setViewName("jsp/listStudent");
		System.out.println("aaa");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/listByPage")
	public Map<String, Object> listByPage(@RequestParam("page")Integer page,@RequestParam("rows")Integer rows){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Student> students=studentServiceImp.listByPage(page, rows);
		int count=studentServiceImp.getCount();
		map.put("rows", students);
		map.put("total", count);
		return map;
	}
	
	@ResponseBody
	@GetMapping("/getById")
	//@RequestParam("id")Integer id,
	public Student getById(ModelAndView mv) {
		int id=(int) mv.getModelMap().get("id");
		return studentServiceImp.getById(id);
	}
	@GetMapping("/editById")
	public ModelAndView editById(@RequestParam("id")Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("jsp/add");
		return mv;
	}

}
