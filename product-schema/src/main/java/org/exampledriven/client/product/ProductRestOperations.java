package org.exampledriven.client.product;

import org.exampledriven.schema.product.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ProductRestOperations {
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = "application/json")
    Product getProduct(@PathVariable("productId") int productId);
}
