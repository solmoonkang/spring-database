package hello.springdatabase.config;

import hello.springdatabase.repository.ItemRepository;
import hello.springdatabase.repository.jdbctemplate.JdbcTemplateItemRepositoryV3;
import hello.springdatabase.service.ItemService;
import hello.springdatabase.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV3Config {

    private final DataSource dataSource;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new JdbcTemplateItemRepositoryV3(dataSource);
    }

}
