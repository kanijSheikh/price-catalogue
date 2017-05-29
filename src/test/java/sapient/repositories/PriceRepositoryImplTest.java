package sapient.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sapient.model.Price;
import sapient.service.PriceServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceRepositoryImplTest {
    private static final String PRODUCT_NAME = "PRODUCT_NAME";
    private static final String PODUCT_PRICE = "PODUCT_PRICE";
    private static final String PRICE_BY_PRODUCT_NAME_QUERY = "FROM Price p where p.name =:productName";

    @InjectMocks
    private PriceRepositoryImpl priceRepository;

    @Mock
    private EntityManager entityManager;
    @Mock
    private TypedQuery mockedQuery;

    @Test
    public void shouldGetPriceForGivenProduct()  {
        when(entityManager.createQuery(eq(PRICE_BY_PRODUCT_NAME_QUERY), eq(Price.class))).thenReturn(mockedQuery);
        Price expectedPrice = new Price(PRODUCT_NAME, PODUCT_PRICE);
        when(mockedQuery.getSingleResult()).thenReturn(expectedPrice);

        Price actualPrice = priceRepository.getPriceBy(PRODUCT_NAME);

        Mockito.verify(mockedQuery).setParameter("productName", PRODUCT_NAME);
        verify(mockedQuery).getSingleResult();
        assertEquals(actualPrice, expectedPrice);
    }
}
