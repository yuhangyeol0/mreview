package com.example.mreview.repository;

import com.example.mreview.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.stream.IntStream;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMember(){

        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .email("r"+ i + "@zerock.org")
                    .pw("1111")
                    .nickname("reviewer" + i).build();
            memberRepository.save(member);
        });
    }
    @Commit
    @Transactional
    @Test
    public void testDeleteMember(){

        Long mid = 1L; //Member의 mid

        Member member = Member.builder().mid(mid).build();

        //FK를 가진 Review먼저 삭제
        //순서주의
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);

    }
}