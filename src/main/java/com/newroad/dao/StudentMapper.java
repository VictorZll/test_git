package com.newroad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newroad.entity.Student;

public interface StudentMapper {
    int insert(Student record);
    /**
     * 添加的方法
     * @param record
     * @return
     */
    int insertSelective(Student record);
    /**
     * 获得全部数据
     * @return
     */
    List<Student> getAll();
    /**
     * 获得总数
     * @return
     */
    Integer getCount();
    /**
     * 分页查询
     * @param offset 当前页码
     * @param rows	每页展示记录数
     * @return
     */
    List<Student> listByPage(@Param("offset")Integer offset,@Param("rows")Integer rows);
    /**
     * 根据id获得学生信息
     * @param id
     * @return
     */
    Student getById(Integer id);
    /**
     * 删除的方法
     * @param id
     * @return
     */
    Integer removeById(Integer id);
    /**
     * 修改的方法
     * @param stu
     * @return
     */
    Integer updateById(@Param("stu") Student stu);
 
}