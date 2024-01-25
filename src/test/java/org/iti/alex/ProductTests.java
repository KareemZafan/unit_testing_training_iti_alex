package org.iti.alex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTests {

    @Test
    @DisplayName("test price increase")
    void testIncreasingPriceBy200(){
        Product product = new Product();
        product.setPrice(1000);
        assertEquals("Primary", product.getCode());
        product.increasePrice(200);
        assertEquals(1200,product.getPrice());
        assertEquals("RED1200", product.getCode());
    }

}
