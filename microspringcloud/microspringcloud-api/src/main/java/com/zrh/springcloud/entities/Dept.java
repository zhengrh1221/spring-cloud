package com.zrh.springcloud.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor 
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{

	private Long deptno;// 部门编号

	private String dname;// 部门名称

	private String db_source;// 从哪个数据库中来的
	
	private List<Employee> employeeList;

}
