package cn.itcast.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.BaseDictService;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {

	// 从配置文件中，读取名字为FROM_TYPE_CODE的值
	@Value("${FROM_TYPE_CODE}")
	private String FROM_TYPE_CODE;
	@Value("${INDUSTRY_TYPE_CODE}")
	private String INDUSTRY_TYPE_CODE;
	@Value("${LEVEL_TYPE_CODE}")
	private String LEVEL_TYPE_CODE;

	@Autowired
	private BaseDictService baseDictService;

	@Autowired
	private CustomerService customerService;

	// http://127.0.0.1:8080/boot-crm/customer/list
	@RequestMapping("list")
	public String list(Model model, QueryVo queryVo) {
		try {
			// 使用重新编码的方式解决乱码问题
			queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 查询客户来源
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode(this.FROM_TYPE_CODE);
		// 查询客户行业
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode(this.INDUSTRY_TYPE_CODE);
		// 查询客户级别
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode(this.LEVEL_TYPE_CODE);

		// 把数据放到 Model中，传递给前台页面
		// 客户来源
		model.addAttribute("fromType", fromType);
		// 所属行业
		model.addAttribute("industryType", industryType);
		// 客户级别
		model.addAttribute("levelType", levelType);

		// 使用CustomerService，根据条件查询数据，获取page对象
		Page<Customer> page = this.customerService.queryCustomerByQueryVo(queryVo);

		// 把查询结果放到Model中，传递给前台页面
		model.addAttribute("page", page);

		// 把查询结果回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());

		return "customer";
	}

	// Request URL: http://127.0.0.1:8080/boot-crm/customer/edit.action?id=14
	// Request Method: GET
	//
	// type:"get",
	// url:"<%=basePath%>customer/edit.action",
	// data:{"id":id},
	/**
	 * 根据id查询客户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer queryCustomerById(Long id) {
		Customer customer = this.customerService.queryCustomerById(id);
		return customer;
	}

	// Request URL: http://127.0.0.1:8080/boot-crm/customer/update.action
	// Request Method: POST
	/**
	 * 修改客户
	 * 
	 * @param customer
	 */
	@RequestMapping("update")
	@ResponseBody // 虽然前端页面中，返回值没有使用，必须要加@ResponseBody注解，返回值是啥都行，不返回也行
	public void updateCustomer(Customer customer) {
		this.customerService.updateCustomer(customer);
	}

	// Request URL: http://127.0.0.1:8080/boot-crm/customer/delete.action
	// Request Method: POST
	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomerById(Long id) {
		this.customerService.deleteCustomerById(id);
		return "hello world~~~";
	}
}
