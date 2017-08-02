package com.fwh.domain;

import com.fwh.annotation.Column;
import com.fwh.annotation.Table;

/** 
* @author dieeman
* @date 2017年7月17日 上午10:27:29 
* 
*/
@Table(name="test2")
public class test2 {
	@Column(name="id",types="int",lengths="20",primarykey=true)
	private int id;
	@Column(name="name",isnull=false)
	private String name;
	@Column(name="email")
	private String email;
}
