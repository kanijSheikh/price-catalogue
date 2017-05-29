package sapient.repositories;

import sapient.model.Price;

public interface PriceRepository {

    Price getPriceBy(String productName);

}
