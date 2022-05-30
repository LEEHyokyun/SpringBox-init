package org.kosta.myproject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
	public int getTotalCustomerCount();

	public CustomerVO findCustomerById(String id);

	public int registerCustomer(CustomerVO cvo);

	public List<CustomerVO> findAddressList(String address);

	public List<String> getTotalAddressList();

	public int checkDuplicateId(String id);
}
