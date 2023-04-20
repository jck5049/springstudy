package com.gdu.app06.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	private int board_no;		// 번호
	private String title;		// 제목
	private String content;		// 내용
	private String writer;		// 작성자
	private String created_at;	// 작성일자
	private String modified_at;	// 수정일자
	

}
