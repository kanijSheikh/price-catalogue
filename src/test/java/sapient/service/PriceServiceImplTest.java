package sapient.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sapient.exception.EntityNotFoundException;
import sapient.model.Price;
import sapient.repositories.PriceRepository;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceImplTest {

    private static final String PRODUCT_NAME = new Random().toString();
    private static final String PRODUCT_PRICE = new Random().toString();
    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private PriceRepository priceRepository;

    @Test
    public void getPriceForGivenProduct() {
        Price expectedPrice = new Price(PRODUCT_NAME, PRODUCT_PRICE);
        when(priceRepository.getPriceBy(PRODUCT_NAME)).thenReturn(expectedPrice);

        Price actualPrice = priceService.get(PRODUCT_NAME);

        verify(priceRepository).getPriceBy(PRODUCT_NAME);
        assertEquals(expectedPrice,actualPrice );
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundExceptionWhenPriceIsNull() {
        when(priceRepository.getPriceBy(PRODUCT_NAME)).thenReturn(null);

        priceService.get(PRODUCT_NAME);
    }
}