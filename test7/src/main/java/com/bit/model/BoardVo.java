package com.bit.model;

import java.util.Date;

public class BoardVo {
	private int num, viewCnt;
	private String userId, title, content;
	private Date wrdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrdate() {
		return wrdate;
	}
	public void setWrdate(Date wrdate) {
		this.wrdate = wrdate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", viewCnt=" + viewCnt + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", wrdate=" + wrdate + "]";
	}
	
	
	
}
