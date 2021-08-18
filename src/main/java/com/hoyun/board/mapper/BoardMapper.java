package com.hoyun.board.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hoyun.board.repository.BoardDTO;

@Mapper
public interface BoardMapper {
	
	// 게시글 전체 조회하기
	public List<BoardDTO> selectBoardList(BoardDTO boardDTO);
	
	// 게시글 상세 조회하기
	public BoardDTO selectBoardDetail(BoardDTO boardDTO);
	
	// 게시글 추가하기
	public void insertContent(BoardDTO boardDTO);
	
	// 게시글 수정하기
	public int updateContent(BoardDTO boardDTO);
	
	// 게시글 삭제하기
	public int deleteContent(int indexNum);
	
}
