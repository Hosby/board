package com.hoyun.board.service;

import java.util.List;


import com.hoyun.board.repository.BoardDTO;


public interface BoardService {
	
	// 게시판 목록 불러오기
	 List<BoardDTO> selectContent(BoardDTO boardDTO);
	
	// 게시판 상세글 불러오기
	public BoardDTO selectDetailContent(BoardDTO boardDTO);
	
	// 게시판 상세글 수정하기
	public void updateContent(BoardDTO boardDTO);
	
	// 게시판 게시글 작성하기
	public void insertContent(BoardDTO boardDTO);
	
	// 게시판 상세글 삭제하기
	public void deleteContent(int indexNum);
	
}