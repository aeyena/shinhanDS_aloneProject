package com.shinhan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
public class DeptVO {
	 private int department_id;
	 private String department_name;
	 private int manager_id;
	 private int location_id;
}
