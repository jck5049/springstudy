package com.gdu.app02.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// getter, setter, toString을 다 가지고 있다.
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private String name;
	private int age;
}
