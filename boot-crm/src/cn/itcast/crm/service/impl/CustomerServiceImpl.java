package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.controller.CustomerController;
import cn.itcast.crm.mapper.CustomerMapper;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		// 设置查询条件,从哪一条数据开始查第一页0，第二页10，第三页
		// 计算公式 (page-1)*rows
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

		// 根据条件分页查询数据
		List<Customer> list = this.customerMapper.queryCustomerByQueryVo(queryVo);

		// 根据条件查询数据总记录数
		int total = this.customerMapper.queryCountByQueryVo(queryVo);

		// 封装返回结果Page
		Page<Customer> page = new Page<>(total, queryVo.getPage(), queryVo.getRows(), list);

		// 返回结果page
		return page;
	}

	@Override
	public Customer queryCustomerById(Long id) {
		Customer customer = this.customerMapper.queryCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		this.customerMapper.deleteCustomerById(id);
	}

}
