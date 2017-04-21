package org.exampledriven.client.product;

import org.exampledriven.schema.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFeignClientFallback implements ProductServiceFeignClient {

	//@Override
	public Product getProduct(int productId) {
		return new Product(-1, "Fallback", 0);
	}

}
