package sapient.service;

import sapient.model.Price;

public interface PriceService {

    Price get(String productName);

}