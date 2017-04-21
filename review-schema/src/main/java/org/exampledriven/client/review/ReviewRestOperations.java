package org.exampledriven.client.review;

import java.util.List;

import org.exampledriven.schema.review.Review;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRestOperations {
	
	@RequestMapping(value = "/review", method = RequestMethod.GET, produces = "application/json")
	List<Review> getReviews(
		@RequestParam(value = "productId",  required = true) 
		int productId);
}
