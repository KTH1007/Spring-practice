package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository MemoryMemberrepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        MemoryMemberrepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        MemoryMemberrepository.save(member);
        //Optional 타입은 get을 이용하여 값을 꺼낼 수 있음
        Member result = MemoryMemberrepository.findById(member.getId()).get();
        //result와 member가 일치하는지 확인
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        MemoryMemberrepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        MemoryMemberrepository.save(member2);

        Member result = MemoryMemberrepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        MemoryMemberrepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        MemoryMemberrepository.save(member2);

        List<Member> result = MemoryMemberrepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
