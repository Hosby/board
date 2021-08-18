package com.hoyun.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hoyun.board.mapper.BoardMapper;
import com.hoyun.board.repository.BoardDTO;
import com.hoyun.board.service.BoardService;


@org.springframework.stereotype.Controller
//@RestController
@RequestMapping("/board")
public class Controller {
	
	@Autowired
	private BoardService s;
	
	@Autowired
	private BoardMapper m;
	
	ModelAndView mav = new ModelAndView();
	
	@GetMapping("/ping")
	public ResponseEntity<String> healthCheck() {
		System.out.println("####health check");
		return ResponseEntity.ok("pong");
	}
	
	// 게시판 리스트 페이지 이동하기
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView goContent() {
		System.out.println("goContent 진입");
		mav.setViewName("index");
		return mav;
	}
	
	// 게시판 리스트 요청값에 의해 axios로 값 가져오기
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<BoardDTO> list(BoardDTO boardDTO) {
		System.out.println("Controller list 진입");
		return s.selectContent(boardDTO);
	}
	
	// 게시글 상세보기로 이동하기
	@ResponseBody
	@RequestMapping(value = "/{indexNum}", method = RequestMethod.GET)
	public ModelAndView goDetailContent(@PathVariable int indexNum) {
		System.out.println("Controller goDetailContent 진입");
		mav = new ModelAndView();
		mav.setViewName("detailContent");
		return mav;
	}
	
	// 게시글 상세보기
	@ResponseBody
	@RequestMapping(value = "/{indexNum}/detailContent", method = RequestMethod.GET)
	public BoardDTO selectDetailContent(@PathVariable int indexNum, BoardDTO boardDTO) {
		System.out.println("Controller selectDetailContent 진입");
		
		return s.selectDetailContent(boardDTO);
	}
	
	// 추가 페이지 이동
	// 매핑값이 같아도 get 과 post 분리되었기 때문에 각각 다른 요청을 할 수 있다.
	@RequestMapping(value = "/addContent", method = RequestMethod.GET)
	public ModelAndView goAddContent() {
		mav.setViewName("addContent");
		return mav;
	}
	
	// 게시판 등록하기
	@ResponseBody
	@RequestMapping(value = "/addContent", method = RequestMethod.POST)
	public void addContent(BoardDTO boardDTO) {
		
		System.out.println("Controller addContent 진입");
		
		m.insertContent(boardDTO);
	}
	
	// 게시글 수정하기
	@ResponseBody
	@RequestMapping(value = "/{indexNum}/updateContent", method = {RequestMethod.GET, RequestMethod.PUT})
	public void updateContent(@PathVariable int indexNum, BoardDTO boardDTO) {
		System.out.println("Controller updateContent 진입");
		s.updateContent(boardDTO);
	}
	
	// 게시글 삭제하기
	@ResponseBody
	@RequestMapping(value = "/{indexNum}/deleteContent", method = {RequestMethod.GET, RequestMethod.POST})
	public void deleteContent(@PathVariable int indexNum) {
		System.out.println("Controller deleteContent 진입");
		
		s.deleteContent(indexNum);
	}
	
}
