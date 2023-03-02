package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.ConMgr;

public class BoardDao {
	
	// 전체 리스트 조회
	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<>();
		String sql = "select num, userId, title, wrdate, viewCnt from board";
		
		try(
				Connection conn = ConMgr.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				BoardVo bean = new BoardVo();
				bean.setNum(rs.getInt("num"));
				bean.setUserId(rs.getString("userId"));
				bean.setTitle(rs.getString("title"));
				bean.setWrdate(rs.getDate("wrdate"));
				bean.setViewCnt(rs.getInt("viewCnt"));
				list.add(bean);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// 게시판 하나를 조회
	public BoardVo getBoard(int num) {
		BoardVo bean = new BoardVo();
		String sql = "select * from board where num = ?";
		try(
				Connection conn = ConMgr.getConnection();
				) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setUserId(rs.getString("userId"));
				bean.setTitle(rs.getString("title"));
				bean.setWrdate(rs.getDate("wrdate"));
				bean.setContent(rs.getString("content"));
				bean.setViewCnt(rs.getInt("viewCnt"));
			}
			
			pstmt.close();
			sql = "update board set viewCnt = viewCnt + 1 where num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return bean;
	}
	
	// 게시판 작성
	public void insertBoard(BoardVo bean) {
		String sql = "insert into board(userId, title, content) values(?,?,?)";
		try (
			Connection conn = ConMgr.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, bean.getUserId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 수정
	public void updateBoard(BoardVo bean) {
		String sql = "update board set title=?, content=? where num=?";
		try (
				Connection conn = ConMgr.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
				pstmt.setString(1, bean.getTitle());
				pstmt.setString(2, bean.getContent());
				pstmt.setInt(3, bean.getNum());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	// 게시판 삭제
	public void deleteBoard(int num) {
		String sql = "delete from board where num = ?";
		try(
				Connection conn = ConMgr.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}










