package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

@Repository // 컴포넌트 스캔의 대상이 됨
public class ItemRepository {

	/*
	* 싱글톤을 사용하기 때문에 멀티스레드 환경에서 여러개가 동시에 사용하게되면 해쉬맵을 사용하면 안된다.
	* 사용하고 싶다면  ConcurrentHashMap<>() 을 사용해야함.
	* */

	private static final Map<Long, Item> store = new HashMap<>(); // static
	private static long sequence = 0L; //static

	public Item save(Item item) {
		item.setId(++sequence);
		store.put(item.getId(), item);
		return item;
	}

	public Item findById(Long id) {
		return store.get(id);
	}

	public List<Item> findAll() {
		return new ArrayList<>(store.values());
	}

	public void update(Long itemId, Item updateParam) {
		Item findItem = findById(itemId);

		//사실상 id를 사용하지 않기 떄문에 아래 3개를 위한 객체를 따로 생성하는게 맞다.
		// ex. ItemParamDtd (파라미터 3개만 넣기)
		// 중복인 것 같아도 명확하게 나누는게 낫다.
		// 중복 vs 명확 = 명확
		findItem.setItemName(updateParam.getItemName());
		findItem.setPrice(updateParam.getPrice());
		findItem.setQuantity(updateParam.getQuantity());
	}

	// test용. HashMap 데이터가 다 날라간다.
	public void clearStore() {
		store.clear();
	}
}
