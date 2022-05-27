package com.cart.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class MinimalProductTest {
    private static final String NAME = "productName";
    private static final Float PRICE = 10.5F;

    MinimalProduct minimalProduct;

    @BeforeEach
    void setUp() {
        this.minimalProduct = new MinimalProduct(NAME, PRICE) {
            @Override
            public String getId() {
                return super.getId();
            }

            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public Float getPrice() {
                return super.getPrice();
            }

            @Override
            public void setId(String id) {
                super.setId(id);
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }

            @Override
            public void setPrice(Float price) {
                super.setPrice(price);
            }

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    @Test
    void getId() {
        assertNull(minimalProduct.getId());
    }

    @Test
    void getName() {
        assertEquals(minimalProduct.getName(), NAME);
    }

    @Test
    void getPrice() {
        assertEquals(minimalProduct.getPrice(), PRICE);
    }

    @Test
    void setId() {
        minimalProduct.setId("exampleId");
        assertEquals(minimalProduct.getId(), "exampleId");
    }

    @Test
    void setName() {
        minimalProduct.setName("Example name");
        assertEquals(minimalProduct.getName(), "Example name");
    }

    @Test
    void setPrice() {
        minimalProduct.setPrice(44.5F);
        assertEquals(minimalProduct.getPrice(), 44.5F);
    }

    @Test
    void testEquals() {
        minimalProduct.setId("exampleId");
        assertEquals(minimalProduct, minimalProduct);

        MinimalProduct minimalProduct2 = new MinimalProduct(NAME, PRICE) {
            @Override
            public String getId() {
                return super.getId();
            }

            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public Float getPrice() {
                return super.getPrice();
            }

            @Override
            public void setId(String id) {
                super.setId(id);
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }

            @Override
            public void setPrice(Float price) {
                super.setPrice(price);
            }

            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };

        assertNotEquals(minimalProduct, minimalProduct2);
        minimalProduct2.setId("exampleId");
        assertEquals(minimalProduct, minimalProduct2);
        minimalProduct2.setName("random name");
        assertNotEquals(minimalProduct, minimalProduct2);
        minimalProduct2.setName(NAME);
        minimalProduct2.setPrice(0.0F);
        assertNotEquals(minimalProduct, minimalProduct2);
    }

    @Test
    void testHashCode() {
        minimalProduct.setId("exampleId");
        assertEquals(minimalProduct.hashCode(), Objects.hash("exampleId", NAME, PRICE));
        assertNotEquals(minimalProduct.hashCode(), Objects.hash(null, NAME, PRICE));
        assertNotEquals(minimalProduct.hashCode(), Objects.hash("exampleId", "random name", PRICE));
        assertNotEquals(minimalProduct.hashCode(), Objects.hash("exampleId", NAME, 0.1F));
    }

    @Test
    void testToString() {
        minimalProduct.setId("exampleId");
        assertEquals(minimalProduct.toString(),"Product{id=exampleId, name='" + NAME + '\'' + ", price='" + PRICE + '\'' + '}');
    }
}
