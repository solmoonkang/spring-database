package hello.springdatabase.config;

import hello.springdatabase.repository.ItemRepository;
import hello.springdatabase.repository.jpa.JpaItemRepositoryV2;
import hello.springdatabase.repository.jpa.SpringDataJpaItemRepository;
import hello.springdatabase.service.ItemService;
import hello.springdatabase.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final SpringDataJpaItemRepository springDataJpaItemRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(springDataJpaItemRepository);
    }
}
