package org.kosta.myproject.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountDAO {

	void registerAccount(AccountVO accountVO);

	void registerAccountByMap(HashMap<String, Object> map);

	List<AccountVO> findAllAccountVOList();

	List<Map<String, Object>> findAllAccountMapList();

}