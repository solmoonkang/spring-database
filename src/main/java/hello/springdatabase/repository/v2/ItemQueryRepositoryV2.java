package hello.springdatabase.repository.v2;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.springdatabase.domain.Item;
import hello.springdatabase.repository.ItemSearchCond;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static hello.springdatabase.domain.QItem.item;

@Repository
public class ItemQueryRepositoryV2 {

    private final JPAQueryFactory jpaQueryFactory;

    public ItemQueryRepositoryV2(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        return jpaQueryFactory.select(item)
                .from(item)
                .where(
                        maxPrice(cond.getMaxPrice()),
                        likeItemName(cond.getItemName()))
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return item.itemName.like("%" + itemName + "%");
        }
        return null;
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }
}
