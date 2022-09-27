package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

	@Id @GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne //멤버와 다대 일 관계
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "delivery")
	private Delivery delivery;

	private LocalDateTime orderDate; //주문시간 자바 8에서는 하이버네이터가 자동으로 지원해준다.

	@Enumerated(EnumType.STRING)
	private OrderStatus status; //주문상태 [ORDER, CANCEL]
}
