package hello.itemservice.domain.item;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

	ItemRepository itemRepository = new ItemRepository();

	@AfterEach
	void afterEach() {
		itemRepository.clearStore();
	}

	@Test
	void save() {
		//given - 저장
		Item item = new Item("itemA", 10000, 10);

		//when
		Item saveItem = itemRepository.save(item);

		//then - 저장할때 id가 세팅되기때문에 id값을 가져올 수 있따.
		Item findItem = itemRepository.findById(item.getId());
		assertThat(findItem).isEqualTo(saveItem);
	}

	@Test
	void findById() {

		//given

		//when

		//then
	}

	@Test
	void findAll() {

		//given
		Item item1 = new Item("item1", 10000, 10);
		Item item2 = new Item("item2", 20000, 20);

		itemRepository.save(item1);
		itemRepository.save(item2);

		//when
		List<Item> result = itemRepository.findAll();

		//then
		assertThat(result.size()).isEqualTo(2); //길이
		assertThat(result).contains(item1, item2); //아이템 두개를 가지고 있는가?
	}

	@Test
	void updateItem () {
		//given
		Item item1 = new Item("item1", 10000, 10);

		Item saveItem = itemRepository.save(item1);
		Long itemId = saveItem.getId();

		//when
		Item updateParam = new Item("item2", 20000, 30);
		itemRepository.update(itemId, updateParam );

		//then
		Item findItem = itemRepository.findById(itemId);
		assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
		assertThat(findItem.getItemName()).isEqualTo(updateParam.getPrice());
		assertThat(findItem.getItemName()).isEqualTo(updateParam.getQuantity());
	}

}