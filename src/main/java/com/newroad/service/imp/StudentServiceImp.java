package com.newroad.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newroad.dao.StudentMapper;
import com.newroad.entity.Student;
import com.newroad.service.StudentServiceIf;
@Service
@Transactional
public class StudentServiceImp implements StudentServiceIf {
	@Resource
	StudentMapper dao;
	
	@Override
	public List<Student> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Student> listByPage(Integer page, Integer rows) {
		double count=getCount();
		System.out.println("count="+count);
		int pageCount=(int) Math.ceil(count/rows);
		if(page<pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		Integer offset=(page-1)*rows;
		rows=page*rows;
		return dao.listByPage(offset, rows);
	}

	@Override
	public Integer getCount() {
		return dao.getCount();
	}
	
	public Student getById(Integer id) {
		return dao.getById(id);
		
	}


}
