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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.newroad.entity.Student;
import com.newroad.service.StudentServiceIf;

@Controller
@SessionAttributes("id")
public class StudentController {
	@Resource
	StudentServiceIf studentServiceImp;
	
	@RequestMapping(value="/main")
	public String list1() {
		return "login";
	}
//	@RequestMapping("/liststu.do")
//	public ModelAndView list(HttpServletRequest req,HttpServletResponse resp) {
//		Student student=new Student(new BigDecimal(123),"张三","男",(short)12,new BigDecimal(1));
//		List<Student> students=new ArrayList<Student>();
//		Collections.addAll(students, student);
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("students", students);
//		mv.setViewName("jsp/listStudent");
//		System.out.println("aaa");
//		return mv;
//	}
	/**
	 * 分页的方法
	 * @param page
	 * @param rows
	 * @return
	 */
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
	/**
	 * 根据id查询记录
	 * @param id
	 * @return 返回json对象 并存到session 实现回填数据
	 */
	@ResponseBody
	@GetMapping("/getById")
	public Student getById(@ModelAttribute("id") Integer id) {
		return studentServiceImp.getById(id);
	}   
	/**
	 * 跳转到add页面
	 * @param id
	 * @param m
	 * @return
	 */
	@GetMapping("/editById")
	public String editById(@RequestParam("id") Integer id,Model m) {
		m.addAttribute("id", id);
		return "jsp/add";
	}
	/**
	 * 删除的方法
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/removeById")
	public Boolean removeById(@RequestParam("id") Integer id) {
		System.out.println(id);
		return studentServiceImp.removeById(id);
	}
	/**
	 * 添加的方法
	 * @param stu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Boolean add(Student stu) {
		int num=studentServiceImp.add(stu);
		return num>0?true:false;		
	}
	/**
	 * 修改的方法
	 * @param stu
	 * @return
	 */
	public Boolean updateById(Student stu) {
		
		
		return studentServiceImp.updateById(stu)>0?true:false;
		
	}
}
