package cn.itcast.crm.pojo;

public class QueryVo {

	// 客户名称
	private String custName;
	// 客户来源
	private String custSource;
	// 客户行业
	private String custIndustry;
	// 客户级别
	private String custLevel;

	// 分页
	// 当前页码数
	private Integer page = 1;
	// 每页显示的数据条数
	private Integer rows = 10;
	// 数据库中从哪一条数据开始查
	private Integer start;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "QueryVo [custName=" + custName + ", custSource=" + custSource + ", custIndustry=" + custIndustry
				+ ", custLevel=" + custLevel + ", page=" + page + ", rows=" + rows + ", start=" + start + "]";
	}

}
