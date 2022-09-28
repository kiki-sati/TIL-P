package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) //읽기만을 위한 성능최적화. 읽기가 아닌 쓰기는 무조건 이걸 쓰면 안된다. (데이터변경이 안됨), 트렌젝션 안에서 데이터 변경이 이루어진다.
@RequiredArgsConstructor //생성사 인젝션 처리,이건 final에 대한 생성자만 생성해줌,  최신버전 스프링에서는 생성자가 하나만 있으면 자동으로 인젝션 처리를 해준다. (@Autowired를 안해도 됨) -> 롬복을 이용한 생성자 자동 생성 @AllArgsConstructor(이건 다)
public class MemberService {

	private final MemberRepository memberRepository; // 컴파일 시점에 체크할 수 있기 때문에 final을 적용해주기.

	/**
	 * 회원가입
	 */
	@Transactional //따로 설정하면 우선순위로 적용됨. readyOnly = false가 디폴트값
	public Long join(Member member) {

		validateDuplicateMember(member); //중복 회원 검증
		memberRepository.save(member);

		// DB에 저장이 안되도 pk값이 저장되어 진다.
		return member.getId();

	}

	private void validateDuplicateMember(Member member) {

		//EXCEPTION
		//멀티쓰레드를 고려해서 DB에서 member - Name을 유니크값으로 제약조건을 달아주는게 좋다.
		List<Member> findMembers = memberRepository.findByName(member.getName());
		if (!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	//회원 전체 조회

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	//회원 단건 조회
	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}

}
