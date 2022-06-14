package com.jdbc.repository;

import com.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    public void save_test() throws Exception {
        Member member = new Member("memberV8", 1000);
        repository.save(member);

        Member byId = repository.findById(member.getMemberId());
        log.info("byId = {}, ", byId);
        assertEquals(member, byId);

        repository.update(member.getMemberId(), 20000);
        Member byId2 = repository.findById(member.getMemberId());
        assertEquals(byId2.getMoney(), 20000);
    }
}