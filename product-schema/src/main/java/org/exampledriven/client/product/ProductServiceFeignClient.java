package org.exampledriven.client.product;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "product-service", fallback = ProductServiceFeignClientFallback.class)
public interface ProductServiceFeignClient extends ProductRestOperations {

}
