package sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sapient.exception.EntityNotFoundException;
import sapient.model.Price;
import sapient.repositories.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price get(String productName) {
        Price price = priceRepository.getPriceBy(productName);
        if (price == null) {
            throw new EntityNotFoundException();
        }
        return price;
    }

}
