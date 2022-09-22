package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 단위테스트
* 단위 테스트를 잘 만드는게 좋은 테스트다.
* */

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // Test가 끝날때마다 repository를 한번씩 지운다.
    // Test는 서로 순서, 의존관계없이 설계되어야 한다. 그러기 위해선 하나의 테스트가 끝날때마다 공통 데이터나 저장소가 비워져야한다.ㅇㅇㅇ

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();  //Optional에서 get으로 꺼낸다.

        // 검증
        // new에서 한것과 db에서의 값이 똑같으면 true.


        // 1. 간단한 방법
        // System.out.println("(result == member) = " + (result == member));

        // 2. assert
        // Assertions.assertEquals(member, result);

        // 3. Assertions
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName () {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2  = new Member();
        member2 .setName("spring2");
        repository.save(member2);

        repository.findByName("spring1");

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
