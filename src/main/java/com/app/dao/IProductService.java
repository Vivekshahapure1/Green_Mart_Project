package com.app.dao;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {

	// method to get all product list
	List<Product> getAllProducts();

	// method to delete product details
	String deleteProductDetails(long productId);

	// method to save product details(add product)
	Product addProductdetails(Product transientProduct);

	// method to fetch product details by id
	Product getProductDetailsId(long productId);

	// method to update existing product details
	Product updateProductDetails(Product detachedProduct);

}
