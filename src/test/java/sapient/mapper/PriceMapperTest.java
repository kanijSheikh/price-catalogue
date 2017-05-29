package sapient.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import sapient.domain.PriceDto;
import sapient.model.Price;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PriceMapperTest {

    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PRICE = "PRICE";

    @InjectMocks
    private PriceMapper priceMapper;

    @Test
    public void shouldMapToDto() {

        PriceDto priceDto = priceMapper.mapToDto(new Price(PRODUCT_NAME, PRICE));

        assertEquals(PRODUCT_NAME, priceDto.getProductName());
        assertEquals(PRICE, priceDto.getPrice());
    }
}