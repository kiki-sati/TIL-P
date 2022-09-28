package jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;

@Repository //스프링빈으로 등록해준다.
public class MemberRepository {

	@PersistenceContext	//jpa 엔티티 매니저를 자동 주입 해준다.
	private EntityManager em;

	public void save(Member member) {
		em.persist(member);
	}

	//단건조회
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}

	//jpql 사용
	public List<Member> findAll() {
		//엔티티 객체를 대상으로 쿼리를 한다.
		return em.createQuery("select  m from Member m", Member.class).getResultList(); // alt + cmd + n 리턴 합치기
	}

	// 파라미터 바인딩 -> 특정 조회
	public List<Member> findByName(String name) {
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
			.setParameter("name", name)
			.getResultList();
	}
}
