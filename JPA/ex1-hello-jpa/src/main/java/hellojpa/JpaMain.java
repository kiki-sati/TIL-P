package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaMain {
	public static void main(String[] args) {
		//데이터 베이스와 연결
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		//애플리케이션 로딩 시점에 처음 만들어야한다.
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); //트렌젝션 시작

		Member member = null;
		try {

	/*		//등록
			member = new Member();
			member.setId(2L);
			member.setName("HelloB");

			em.persist(member);

			// 찾기
			Member findMember = em.find(Member.class, 1L);

			//삭제
			em.remove(findMember);*/

			//수정
/*
			Member findMember2 = em.find(Member.class, 1L);
			findMember2.setName("HelloJPA");
*/

			List<Member> result = em.createQuery("select m from Member as m", Member.class)
				.setFirstResult(1)
				.setMaxResults(10)
				.getResultList();

			for (Member mem : result) {
				System.out.println("member = " + mem.getName());

			}

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();

	}
}
