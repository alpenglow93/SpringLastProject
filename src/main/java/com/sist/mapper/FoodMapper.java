package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	// OFFSET 문법 도입 이전엔 이렇게 rownum 사용
	@Select("SELECT no,poster,address,name,num "
			+ "FROM (SELECT no,poster,address,name,rownum as num "
			+ "FROM (SELECT no,poster,address,name "
			+ "FROM food ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	// 매개변수가 여러개일 경우 @Param 사용. sql문의 #{}변수와 이름을 맞춰야한다
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food")
	public int foodTotalPage();
	
	@Select("SELECT no,poster,name,address,time,price,score,theme,content,parking "
			+ "FROM food "
			+ "WHERE no=#{no} ")
	public FoodVO foodDetailData(int no);
}
