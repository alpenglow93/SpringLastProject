package com.sist.vo;
/*
 * 	NO         NOT NULL NUMBER         
	NAME       NOT NULL VARCHAR2(51)   
	SUBJECT    NOT NULL VARCHAR2(2000) 
	CONTENT    NOT NULL CLOB           
	PWD        NOT NULL VARCHAR2(10)   
	REGDATE             DATE           
	HIT                 NUMBER         
	GROUP_ID            NUMBER         
	GROUP_STEP          NUMBER         
	GROUP_TAB           NUMBER         
	ROOT                NUMBER         
	DEPTH               NUMBER         
			
						
		depth : 하위에 답변이 달려있는지
		
					   DESC ASC
					no	gi	gs	gt	root	depth
		AAA			1	1	0	0	0		2
		 =>BBB		2	1	1	1	1		2
		  => DDD	4	1	2	2	2		0
		  => CCC	3	1	3	2	2		0
		 => EEE		5	1	1	1	1		0
		 
		Transaction : 일괄처리
		
		insert
		insert
		insert
		성공시 commit
		하나라도 실패시 rollback
		  
 */
import java.util.*;
import lombok.Data;

@Data
public class BoardVO {
	private int no,hit,group_id,group_step,group_tab,root,depth;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
