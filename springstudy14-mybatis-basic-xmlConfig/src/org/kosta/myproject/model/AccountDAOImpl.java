package org.kosta.myproject.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
	private SqlSessionTemplate template;
	
	@Autowired
	public AccountDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
		System.out.println("AccountDAOImple DI: "+template);
	}

	@Override
	public void registerAccount(AccountVO accountVO) {
		template.insert("account.registerAccount", accountVO);
	}

	@Override
	public void registerAccountByMap(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		template.insert("account.registerAccountByMap", map);
	}

	@Override
	public List<AccountVO> findAllAccountVOList() {
		// TODO Auto-generated method stub
		return template.selectList("account.findAllAccountVOList");
	}

	@Override
	public List<Map<String, Object>> findAllAccountMapList() {
		// TODO Auto-generated method stub
		return template.selectList("account.findAllAccountMapList");
				
	}
}
