package com.kh.test.repository;

import com.kh.test.domain.Member;
import com.kh.test.dto.MemberDtoRequest;
import common.jdbcDriver.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDbRepository implements MemberRepository{
    @Override
    public Member loginMember(String id, String passwd) {
        Member member = null;
        Connection conn = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWD = ?";
        try{
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, passwd);
            rs = pstmt.executeQuery();
            if(rs.next()){
                member = new Member.Builder(rs.getString("id"))
                        .setPasswd(rs.getString("passwd"))
                        .setName(rs.getString("name"))
                        .setEmail(rs.getString("email"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcTemplate.close(conn);
            JdbcTemplate.close(pstmt);
            JdbcTemplate.close(rs);
        }
        return member;
    }

    @Override
    public int dupIdChk(String id) {
        Connection connection = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int result = 0;
        String query = "select count(*) from member where id = ?";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            rset = pstmt.executeQuery();
            if(rset.next()){
                result = rset.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcTemplate.close(connection);
            JdbcTemplate.close(pstmt);
            JdbcTemplate.close(rset);
        }
        return result;
    }

    @Override
    public int insertMember(Member member) {
        Connection connection = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "insert into member values(?, ?, ?, ?)";
        try{
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPasswd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcTemplate.close(connection);
            JdbcTemplate.close(pstmt);
        }
        return result;
    }

    @Override
    public int updateMember(Member member) {
        Connection connection = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        return 0;
    }

    @Override
    public int deleteMember(Member member) {
        Connection connection = JdbcTemplate.getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        return 0;
    }
}
