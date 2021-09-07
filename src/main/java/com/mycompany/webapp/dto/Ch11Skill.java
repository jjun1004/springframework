package com.mycompany.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//롬복 사용
@Data
// 기본 생성자
@NoArgsConstructor
// 매개변수 있는 생성자 생성
@AllArgsConstructor
public class Ch11Skill {
	private int code;
	private String label;
	
	/*	public Ch11Skill() {
		}*/
	
	/*	public Ch11Skill(int code, String label) {
			this.code = code;
			this.label = label;
		}*/
}