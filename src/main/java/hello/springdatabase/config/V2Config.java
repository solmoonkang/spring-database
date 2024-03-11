package hello.springdatabase.config;

import hello.springdatabase.repository.ItemRepository;
import hello.springdatabase.repository.jpa.JpaItemRepositoryV3;
import hello.springdatabase.repository.v2.ItemQueryRepositoryV2;
import hello.springdatabase.repository.v2.ItemRepositoryV2;
import hello.springdatabase.service.ItemService;
import hello.springdatabase.service.ItemServiceV2;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class V2Config {

    private final EntityManager entityManager;

    private final ItemRepositoryV2 itemRepositoryV2; // SpringDataJPA

    @Bean
    public ItemService itemService() {
        return new ItemServiceV2(itemRepositoryV2, itemQueryRepository());
    }

    @Bean
    public ItemQueryRepositoryV2 itemQueryRepository() {
        return new ItemQueryRepositoryV2(entityManager);
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(entityManager);
    }
}
