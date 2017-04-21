package org.exampledriven.schema.product;

/**
 * Created by magnus on 04/03/15.
 */
public class Product {
    private int productId;
    private String name;
    private int weight;

    public Product() {

    }

    public Product(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", weight=" + weight + "]";
	}
    
    
}
