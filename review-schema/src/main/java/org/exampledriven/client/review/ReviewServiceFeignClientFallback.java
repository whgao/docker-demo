package org.exampledriven.client.review;

import java.util.ArrayList;
import java.util.List;

import org.exampledriven.schema.review.Review;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ReviewServiceFeignClientFallback implements ReviewServiceFeignClient {

	//@Override
	public List<Review> getReviews(
		@RequestParam(value = "productId",  required = true) 
		int productId) {
		return new ArrayList<Review>();
	}

}
