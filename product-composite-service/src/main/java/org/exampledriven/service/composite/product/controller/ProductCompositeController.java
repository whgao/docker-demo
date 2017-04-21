package org.exampledriven.service.composite.product.controller;

import org.exampledriven.client.product.ProductServiceFeignClient;
import org.exampledriven.client.review.ReviewServiceFeignClient;
import org.exampledriven.schema.product.Product;
import org.exampledriven.schema.review.Review;
import org.exampledriven.service.composite.product.model.ProductAggregated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by magnus on 04/03/15.
 */
@RestController
public class ProductCompositeController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeController.class);

    @Autowired
    private ProductServiceFeignClient productServiceFeignClient;

    @Autowired
    private ReviewServiceFeignClient reviewServiceFeignClient;
    
//    @Autowired
//    ProductCompositeIntegration integration;
//
//    @Autowired
//    ServiceUtils util;

    @RequestMapping("/")
    public String getProduct() {
        return "{\"timestamp\":\"" + new Date() + "\",\"content\":\"Hello from ProductAPi\"}";
    }

    @RequestMapping(value = "/product/{productId}", produces = "application/json")
    public ProductAggregated getProduct(@PathVariable int productId) {

    	Product product = productServiceFeignClient.getProduct(productId);
        LOG.debug("Product from feign client: {}", product);
    	
        List<Review> reviews = reviewServiceFeignClient.getReviews(productId);
        LOG.debug("Reviews from feign client: {}", reviews);
        
        return new ProductAggregated(product, /*recommendations,*/ reviews);
    }

//    public ResponseEntity<ProductAggregated> getProduct2(@PathVariable int productId) {
//        // 1. First get mandatory product information
//        ResponseEntity<Product> productResult = integration.getProduct(productId);
//
//        if (!productResult.getStatusCode().is2xxSuccessful()) {
//            // We can't proceed, return whatever fault we got from the getProduct call
//            return util.createResponse(null, productResult.getStatusCode());
//        }
//
////        // 2. Get optional recommendations
////        List<Recommendation> recommendations = null;
////        try {
////            ResponseEntity<List<Recommendation>> recommendationResult = integration.getRecommendations(productId);
////            if (!recommendationResult.getStatusCode().is2xxSuccessful()) {
////                // Something went wrong with getRecommendations, simply skip the recommendation-information in the response
////                LOG.debug("Call to getRecommendations failed: {}", recommendationResult.getStatusCode());
////            } else {
////                recommendations = recommendationResult.getBody();
////            }
////        } catch (Throwable t) {
////            LOG.error("getProduct error", t);
////            throw t;
////        }
//
//
//        // 3. Get optional reviews
//        ResponseEntity<List<Review>> reviewsResult = integration.getReviews(productId);
//        List<Review> reviews = null;
//        if (!reviewsResult.getStatusCode().is2xxSuccessful()) {
//            // Something went wrong with getReviews, simply skip the review-information in the response
//            LOG.debug("Call to getReviews failed: {}", reviewsResult.getStatusCode());
//        } else {
//            reviews = reviewsResult.getBody();
//        }
//
//        return util.createOkResponse(new ProductAggregated(productResult.getBody(), /*recommendations,*/ reviews));
//    }

}
