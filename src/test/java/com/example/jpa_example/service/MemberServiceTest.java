package com.example.jpa_example.service;


import com.example.jpa_example.domain.Member;
import com.example.jpa_example.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트")
    public void 회원가입() throws Exception {
        // Given
        Member member = new Member();
        member.setName("lee");

        // When
        Long saveId = memberService.join(member);

        // Then
        Assertions.assertThat(member).isEqualTo(memberRepository.findById(saveId).get());
    }

    @Test
    public void 중복_회원_예외() throws Exception {

        //Given
        Member member1 = new Member();
        member1.setName("lee");

        Member member2 = new Member();
        member2.setName("lee");

        //When
        memberService.join(member1);
        memberService.join(member2);

        //Then
        fail("예외가 발생해야 한다.");
    }
}