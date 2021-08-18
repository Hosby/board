package com.hoyun.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoyun.board.mapper.BoardMapper;
import com.hoyun.board.repository.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 게시판 전체 리스트 가져오기
	@Override
	public List<BoardDTO> selectContent(BoardDTO boardDTO) {
		return boardMapper.selectBoardList(boardDTO);
	}
	
	// 게시판 상세 조회하기
	@Override
	public BoardDTO selectDetailContent(BoardDTO boardDTO) {
		System.out.println("ServiceImpl selectDetailContent 진입");
		return boardMapper.selectBoardDetail(boardDTO);
	}
	
	// 게시판 추가하기
	@Override
	public void insertContent(BoardDTO boardDTO) {
		System.out.println("ServiceImpl 진입");
		
		boardMapper.insertContent(boardDTO);
	}

	// 게시판 상세 수정하기
	@Override
	public void updateContent(BoardDTO boardDTO) {
		System.out.println("ServiceImpl updateContent 진입");
		
		boardMapper.updateContent(boardDTO);
	}

	// 게시판 상세 삭제하기
	@Override
	public void deleteContent(int indexNum) {
		System.out.println("ServiceImpl deleteContent 진입");
		boardMapper.deleteContent(indexNum);
	}

}
