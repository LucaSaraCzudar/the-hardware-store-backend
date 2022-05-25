package hardwarestore.product;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private static final String NAME = "productName";
    private static final Float PRICE = 10.5F;
    private static final ProductType PRODUCT_TYPE = ProductType.OTHER;
    private static final String DESCRIPTION = RandomStringUtils.random(1000, true, true);
    private static final String IMAGE = RandomStringUtils.random(100000, true, true);;

    Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product(NAME, PRICE, PRODUCT_TYPE, DESCRIPTION, IMAGE);
    }

    @Test
    void getProductType() {
       assertEquals(product.getProductType(), PRODUCT_TYPE);
    }

    @Test
    void getDescription() {
        assertEquals(product.getDescription(), DESCRIPTION);
    }

    @Test
    void getImageBase64() {
        assertEquals(product.getImageBase64(), IMAGE);
    }

    @Test
    void setProductType() {
        product.setProductType(ProductType.CPU);
        assertEquals(product.getProductType(), ProductType.CPU);
    }

    @Test
    void setDescription() {
        String mockDescription = RandomStringUtils.random(1000, true, true);
        product.setDescription(mockDescription);
        assertEquals(product.getDescription(), mockDescription);
    }

    @Test
    void setImageBase64() {
        String mockImage = RandomStringUtils.random(100000, true, true);
        product.setImageBase64(mockImage);
        assertEquals(product.getImageBase64(), mockImage);
    }
}
