package com.github.brunoslvb.api;

import com.github.brunoslvb.api.models.Product;

import com.github.database.rider.cdi.api.DBRider;

import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProductTest {

    @Test
    @DataSet("product1.yml")
    public void test(){
        Assertions.assertEquals(1, Product.count());
    }

}
