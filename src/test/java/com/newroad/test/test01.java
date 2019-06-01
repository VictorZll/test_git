package com.newroad.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newroad.entity.Student;
import com.newroad.service.StudentServiceIf;
import com.newroad.service.imp.StudentServiceImp;

public class test01 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentServiceImp s=context.getBean(StudentServiceImp.class);
		Integer num=s.updateById(new Student(new BigDecimal(1231), "李四", "男", (short)100));
		System.out.println("num="+num);
	}

}
