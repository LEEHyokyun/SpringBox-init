package org.kosta.myproject.model;

public interface ProductService {

	void setProductDAO(ProductDAO productDAO);

	String findProductById(String id);

}