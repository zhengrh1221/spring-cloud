package com.zrh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Employee {
	
	
	private Long empId;
	
	private String empName;
	
	private Long deptno;
	
	private String db_source;
	
	private Dept dept;

}
