package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerMapper {

	/**
	 * 根据条件查询结果集
	 * 
	 * @param queryVo
	 * @return
	 */
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

	/**
	 * 根据条件查询总记录数
	 * 
	 * @param queryVo
	 * @return
	 */
	int queryCountByQueryVo(QueryVo queryVo);

	/**
	 * 根据id查询客户
	 * 
	 * @param id
	 * @return
	 */
	Customer queryCustomerById(Long id);

	/**
	 * 修改客户
	 * 
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteCustomerById(Long id);

}
