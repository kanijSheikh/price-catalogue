package sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sapient.domain.PriceDto;
import sapient.mapper.PriceMapper;
import sapient.model.Price;
import sapient.service.PriceService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PriceControllerRest {
    @Autowired
    private PriceControllerRest priceControllerRest;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private PriceService priceService;

    public static final String PRICE_BY_PRODUCT_NAME = "/product/{productName}/price";

    @RequestMapping(value = PRICE_BY_PRODUCT_NAME, method = GET,
            produces = {"application/json"})
    public PriceDto getProductPrice(@PathVariable("productName") String productName) {
        Price price = priceService.get(productName);
        return priceMapper.mapToDto(price);
    }


}
