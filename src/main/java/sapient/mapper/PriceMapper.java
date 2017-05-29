package sapient.mapper;

import org.springframework.stereotype.Component;
import sapient.domain.PriceDto;
import sapient.model.Price;

@Component
public class PriceMapper {

    public PriceDto mapToDto(Price price) {
        return new PriceDto(price.getProductName(), price.getPrice());
    }
}
