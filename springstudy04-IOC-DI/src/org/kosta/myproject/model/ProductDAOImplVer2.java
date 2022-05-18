package org.kosta.myproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImplVer2 implements ProductDAO {

	@Override
	public String findProductById(String id) {
		// TODO Auto-generated method stub
		return id+"에 대한 상품정보가 출력됩니다(Ver2).";
	}

	//AutoWired는 type으로 확인하여 주입하므로, Spring 입장에서는 중복
}
