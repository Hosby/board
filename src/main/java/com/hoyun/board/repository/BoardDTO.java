package com.hoyun.board.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	public BoardDTO() {
		
	}
	
	// 번호 pk
	private int indexNum;
	
	// 작성자 이름
	private String writeName;
	
	// 작성 제목
	private String writeTitle;
	
	// 작성 내용
	private String writeType;

	public int getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}

	public String getWriteName() {
		return writeName;
	}

	public void setWriteName(String writeName) {
		this.writeName = writeName;
	}

	public String getWriteTitle() {
		return writeTitle;
	}

	public void setWriteTitle(String writeTitle) {
		this.writeTitle = writeTitle;
	}

	public String getWriteType() {
		return writeType;
	}

	public void setWriteType(String writeType) {
		this.writeType = writeType;
	}
}

