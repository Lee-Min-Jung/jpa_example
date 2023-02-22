package com.example.jpa_example.controller;

import com.example.jpa_example.domain.Member;
import com.example.jpa_example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping(path="/join")
    public Long joinMember(@RequestBody Member member) throws Exception{
        return memberService.join(member);
    }

}
