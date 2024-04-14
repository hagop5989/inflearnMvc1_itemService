package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class ItemRepository {

    private static final Map<Long,Item> store = new HashMap<>();
    //static, 원래는 hashmap 쓰면 안됨, 멀티스레드 접근 시 문제 생김, 원래 concurrentHashMap 써야함
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }

    public Item finById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = finById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear(); // 맵 데이터 다 날리기
    }
}
