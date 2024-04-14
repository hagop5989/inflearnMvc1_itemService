package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data @Data 는 위험한 방식임, 예측못하게 동작할 수 있음. 다만 DTO 는 괜찮. @Data 가 어떤 기능하는지 확인하고 써야함
@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    // Integer 를 쓰는건 null 을 가정하는 것, 그냥 int 는 null 이 못들어가고 기본값이 0이라 문제가능
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
