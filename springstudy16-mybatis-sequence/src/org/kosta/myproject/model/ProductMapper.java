package org.kosta.myproject.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

	int getTotalCount();

	List<String> findMakerList();

	ProductVO findProductByNo(int productNo);

	List<ProductVO> findProductListByMakerAndPrice(ProductVO paramVO);

	List<ProductVO> findProductListLessThanPrice(int price);

	List<ProductVO> findProductListByLowPriceAndHighPrice(Map<String, Integer> paramMap);

	List<ProductVO> findProductListLikeKeyword(String keyword);

	List<ProductVO> findAllProductListOrderByNoDesc();

	int registerProduct(ProductVO pvo);

	int registerProductWithSequence(ProductVO pvo);

	int deleteProductByMaker(String maker);

}
