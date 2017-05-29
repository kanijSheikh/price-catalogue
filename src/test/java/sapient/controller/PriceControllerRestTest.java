package sapient.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sapient.domain.PriceDto;
import sapient.mapper.PriceMapper;
import sapient.model.Price;
import sapient.service.PriceService;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceControllerRestTest {

    private static final String PRODUCT_NMAE = "Ferrari Car";
    public static final String PRODUCT_PRICE = "1000$";

    @InjectMocks
    private PriceControllerRest priceControllerRest;

    @Mock
    private PriceService priceService;
    @Mock
    private PriceMapper priceMapper;

    @Test
    public void shouldGetProductPrice() {
        Price priceDomain = new Price(PRODUCT_NMAE, PRODUCT_PRICE);
        PriceDto expectedPrice = new PriceDto(PRODUCT_NMAE, PRODUCT_PRICE);
        when(priceService.get(PRODUCT_NMAE)).thenReturn(priceDomain);
        when(priceMapper.mapToDto(priceDomain)).thenReturn(expectedPrice);

        PriceDto actualPrice = priceControllerRest.getProductPrice(PRODUCT_NMAE);

        assertEquals(expectedPrice, actualPrice);
    }
}