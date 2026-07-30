package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.GoodsService;
import com.sist.vo.GoodsVO;

import lombok.RequiredArgsConstructor;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class GoodsController {
	private final GoodsService gService;
	
	@GetMapping("goods/list.do")
	public String goods_list(String page, Model model)
	{
		if(page == null)
			page = "1";
		int curpage = Integer.parseInt(page);
		
		final int ROWSIZE = 12;
		int start = (ROWSIZE*curpage)-(ROWSIZE - 1);
		int end = ROWSIZE * curpage;
		
		List<GoodsVO> list = gService.goodsListData(start);
		int totalpage = gService.goodsTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage)
			endPage = totalpage;
		
		for(int i = 0; i < 12; i++)
		{
			System.out.println(list.get(i).getNo());
			
		}
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_jsp", "../goods/list.jsp");
		
		return "main/main";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model)
	{
		GoodsVO vo = gService.goodsDetailData(no);
		model.addAttribute("vo", vo);
		System.out.println(vo);
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		
		return "main/main";
	}
	
}
