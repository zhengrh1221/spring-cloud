package com.zrh.springcloud.service;

import java.util.List;

import com.zrh.springcloud.entities.Dept;

public interface DeptService {
	
	public Boolean add(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list(); 

}
