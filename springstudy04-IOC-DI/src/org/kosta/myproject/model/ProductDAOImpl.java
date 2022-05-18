package org.kosta.myproject.model;

import org.springframework.stereotype.Repository;

@Repository // 영속성 계층 (data access layer)
public class ProductDAOImpl implements ProductDAO {

	@Override
	public String findProductById(String id) {
		// TODO Auto-generated method stub
		return id+"에 대한 상품정보가 출력됩니다.";
	}

}
