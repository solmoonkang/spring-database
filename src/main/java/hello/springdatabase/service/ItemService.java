package hello.springdatabase.service;

import hello.springdatabase.domain.Item;
import hello.springdatabase.repository.ItemSearchCond;
import hello.springdatabase.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
