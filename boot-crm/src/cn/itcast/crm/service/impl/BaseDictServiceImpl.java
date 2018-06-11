package cn.itcast.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.itcast.crm.mapper.BaseDictMapper;
import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Value("${jdbc.driver}")
	private String d;
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		List<BaseDict> list = this.baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		return list;
	}

}
