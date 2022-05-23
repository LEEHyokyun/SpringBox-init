package org.kosta.myproject.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

	int getTotalCount();

	List<String> findMakerList();

	ProductVO findProductByNo(int productNo);

	List<ProductVO> findProductListByMakerAndPrice(ProductVO paramVO);

	List<ProductVO> findProductListLessThanPrice(int price);

}
