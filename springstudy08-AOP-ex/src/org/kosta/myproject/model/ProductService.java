package org.kosta.myproject.model;

public interface ProductService {

	void deleteProduct(String id);

	void findProductById(String id);

	void findProductListByMaker(String maker);

	void findProductListByPriceAndMaker(int price, String maker);

}