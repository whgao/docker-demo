package org.exampledriven.client.review;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "review-service", fallback = ReviewServiceFeignClientFallback.class)
public interface ReviewServiceFeignClient extends ReviewRestOperations {

}
