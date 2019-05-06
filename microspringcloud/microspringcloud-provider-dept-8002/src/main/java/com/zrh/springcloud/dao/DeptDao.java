package com.zrh.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zrh.springcloud.entities.Dept;

@Mapper 
public interface DeptDao {

	
	public Boolean addDept(Dept dept);
	 
	public Dept findById(Long id);
	
	public List<Dept> findALL();
	
}
