package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.aspectj.weaver.ast.Or;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) 	//생성사 사용을 막기 위한 제약
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY) //멤버와 다대 일 관계, 실무에선 쓰면 안된다.
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //order를 퍼시스트 하면 안에 OrderItem도 강제로 퍼시스트 한다.
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery")
	private Delivery delivery;

	private LocalDateTime orderDate; //주문시간 자바 8에서는 하이버네이터가 자동으로 지원해준다.

	@Enumerated(EnumType.STRING)
	private OrderStatus status; //주문상태 [ORDER, CANCEL]

	//==연관관계 메서드==//
	public void setMember(Member member) {
		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	//==생성메서드//
	public static Order creatOrder(Member member, Delivery delivery, OrderItem... orderItems) {
		Order order = new Order();
		order.setMember(member);
		order.setDelivery(delivery);
		Arrays.stream(orderItems)
			.forEach(order::addOrderItem);
		order.setStatus(OrderStatus.ORDER);
		order.setOrderDate(LocalDateTime.now());
		return order;
	}

	//==비지니스 로직==//
	/**
	 * 주문취소
	 */
	public void cancel() {
		if (delivery.getStatus() == DeliveryStatus.COMP) { //배송 완료일때
			throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
		}
		this.setStatus(OrderStatus.CANCEL);
		for (OrderItem orderItem : orderItems) {
			orderItem.cancel();
		}
	}

	//==조회 로직==//
	/**
	 * 전체 주문 가격 조회
	 */
	public int getTotalPrice() {
/*		int totalPrice = 0;
		for (OrderItem orderItem : orderItems) {
			totalPrice = +orderItem.getTotalPrice();
		}*/

		//람다 활용하면 깔끔하게 가능
		return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
	}

}
