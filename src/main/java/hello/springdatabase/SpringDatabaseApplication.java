package hello.springdatabase;

import hello.springdatabase.config.JpaConfig;
import hello.springdatabase.config.QuerydslConfig;
import hello.springdatabase.config.SpringDataJpaConfig;
import hello.springdatabase.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Slf4j
@Import(QuerydslConfig.class)
@SpringBootApplication(scanBasePackages = "hello.springdatabase.web")
public class SpringDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDatabaseApplication.class, args);
    }

    @Bean
    @Profile("local")
    public TestDataInit testDataInit(ItemRepository itemRepository) {
        return new TestDataInit(itemRepository);
    }


    /**
     *     @Bean
     *     @Profile("test")
     *     public DataSource dataSource() {
     *         log.info("🗑️ 메모리 데이터베이스 초기화");
     *
     *         DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
     *         driverManagerDataSource.setDriverClassName("org.h2.Driver");
     *         driverManagerDataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
     *         driverManagerDataSource.setUsername("sa");
     *         driverManagerDataSource.setPassword("");
     *
     *         return driverManagerDataSource;
     *     }
     */
}
