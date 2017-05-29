package sapient.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sapient.model.Price;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Price getPriceBy(String productName) {
        String query = "FROM Price p where p.name =:productName";
        TypedQuery<Price> q = entityManager.createQuery(query, Price.class);
        q.setParameter("productName", productName);
        return q.getSingleResult();
    }
}
