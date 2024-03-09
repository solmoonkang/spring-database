package hello.springdatabase.config;

import hello.springdatabase.repository.ItemRepository;
import hello.springdatabase.repository.memory.MemoryItemRepository;
import hello.springdatabase.service.ItemService;
import hello.springdatabase.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
