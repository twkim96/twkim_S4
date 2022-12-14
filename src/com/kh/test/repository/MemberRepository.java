package com.kh.test.repository;

import com.kh.test.domain.Member;
import com.kh.test.dto.MemberDtoRequest;

import java.sql.Connection;

public interface MemberRepository {
    public Member loginMember(String id, String passwd);
    public int dupIdChk(String id);
    public int insertMember(Member member);
    public int updateMember(Member member);
    public int deleteMember(Member member);

}
