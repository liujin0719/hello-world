package cn.itcast.crm.service;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.utils.Page;

public interface CustomerService {

	/**
	 * 根据条件分页查询客户
	 * 
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

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
