package org.kosta.myproject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data //기본 생성자, getter, setter, equals, hashCode
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String address;
}
