package com.example.springbootapi.ui;


import com.example.springbootapi.model.Member;
import com.example.springbootapi.model.MemberCreateRequest;
import com.example.springbootapi.model.MemberUpdateRequest;
import com.example.springbootapi.repository.MemberRepository;
import com.example.springbootapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    // 컨트롤러 - 서비스 - Repository
    private final MemberService memberService;
    /**
     * 회원 생성 API
     * [POST] /api/members
     * @return
     */
    @PostMapping("/api/members")
    public ResponseEntity<Member> createMember(@RequestBody MemberCreateRequest request){
        Member createMember = memberService.createMember(request);
        return new ResponseEntity<>(createMember, HttpStatus.OK); //200
    }

    /**
     * 특정 회원 조회 API
     * [GET] /api/members/{memberId}
     * @return
     */

    @GetMapping("/api/members/{memberId}")
    public ResponseEntity<Member> findMember(@PathVariable Long memberId){
        Member findMember = memberService.findMember(memberId);
        return new ResponseEntity<>(findMember, HttpStatus.OK);
    }

    /**
     * 전체 회원 조회 API
     * [GET] /api/members
     * @return
     */

    @GetMapping("/api/members")
    public ResponseEntity<List<Member>> findAllMember(){
        List<Member> allMember = memberService.findAllMember();
        return new ResponseEntity<>(allMember, HttpStatus.OK);
    }

    /**
     * 회원 수정 API
     * [PATCH] /api/members/{memberId}
     * @param memberId
     * @return
     */

    @PatchMapping("/api/members/{memberId}")
    public ResponseEntity<String> updateMember(
            @PathVariable Long memberId, @RequestBody MemberUpdateRequest request){
        memberService.updateMember(memberId, request);
        return new ResponseEntity<>( memberId + "번 회원의 이름이 정상적으로 수정되었습니다.", HttpStatus.OK);
    }

    /**
     * 특정 회원 삭제 API
     * [DELETE] /api/members/{memberId}
     * @param memberId
     * @return
     */

    @DeleteMapping("/api/members/{memberId}")
    public ResponseEntity<String> deletMember(@PathVariable Long memberId){
        memberService.deletMember(memberId);
        return new ResponseEntity<>( memberId + "번 회원의 이름이 정상적으로 삭제되었습니다.", HttpStatus.OK);
    }

    /**
     * 전체 회원 삭제 API
     * [DELETE] /api/members
     * @return
     */
    @DeleteMapping("/api/members")
    public ResponseEntity<String> deleteAllMember(){
        memberService.deletAllMember();
        return new ResponseEntity<>( "모든 회원이 삭제되었습니다.", HttpStatus.OK);
    }

}
