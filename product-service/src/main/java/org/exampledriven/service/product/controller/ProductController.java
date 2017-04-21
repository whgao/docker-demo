package org.exampledriven.service.product.controller;

import org.exampledriven.client.product.ProductRestOperations;
import org.exampledriven.schema.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController implements ProductRestOperations {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return
     */
//    @RequestMapping(value = "/product/{productId}", produces = "application/json")
    public Product getProduct(@PathVariable int productId) {
        LOG.info("/product called, productId={}", productId);

        return new Product(productId, "name" + productId, 123);
    }
}
