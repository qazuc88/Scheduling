package com.paiban.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paiban.Domain.Repository.PeopleMapper;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.PaibanExample;
import com.paiban.entity.People;
import com.paiban.entity.PeopleExample;

@Controller
public class PeopleController {
	@Resource
	PeopleMapper mapper;

	@RequestMapping("/people/list")
	public String list() {
		return "people/list";
	}

	@RequestMapping("/api/people/getlist")
	@Transactional
	@ResponseBody
	public Message getList(@RequestParam(value = "field", required = false) String field// 要搜索的字段
			, @RequestParam(value = "type", defaultValue = "none") String type// 搜索类型，支持in,notIn,like,notLike,equals,notEquals....

			, @RequestParam(value = "sort", required = false, defaultValue = "peopleName") String sort// 排序字段
			, @RequestParam(value = "order", required = false, defaultValue = "asc") String order// 排序方式
			, @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page// limit
			, @RequestParam(value = "limit", required = false, defaultValue = "100") @Min(0) Integer limit// limit
			, String peopleName
	// , @RequestParam(value = "offset", required = false, defaultValue = "0")
	// @Max(1000) @Min(0) Integer offset// offset
	) {
		Message msg = new Message();

		PeopleExample example = new PeopleExample();
		if (peopleName != null && peopleName.length() > 0) {
			example.createCriteria().andPeoplenameLike("%" + peopleName + "%");
		}
		Integer offset = (page - 1) * limit;
		// 排序
		if (sort == null || sort.length() == 0) {
			sort = "date";
			order = "desc";
		}
		if (sort != null && order != null) {
			switch (order.toLowerCase()) {
			case "asc":
				example.setOrderByClause(sort + " asc ");
				break;
			case "desc":
				example.setOrderByClause(sort + " desc ");
				break;
			default:
				throw new RuntimeException("unsupported sorting method(only support asc or desc)");
			}
		}

		// 设置基于Limit/Offset分页插件的分页信息,如数据库不支持或使用了PageHelper，请自行更改实现方式
		example.setLimit(limit);
		example.setOffset(offset);
		msg.count = mapper.countByExample(example);
		msg.data = mapper.selectByExample(example);
		msg.code=0;
		return msg;
	}
	@RequestMapping("/api/people/add")
	@Transactional
	@ResponseBody
	public Message Add(String id,String peoplename) {
		Message msg = new Message();
		msg.msg="操作失败";
		msg.code=-1;
		if(peoplename==null||peoplename.trim().length()==0) {
			msg.msg="请输入姓名";
			msg.code=-1;
		}
		People model=new People();
		model.setPeoplename(peoplename);
		int tid=0; 
		if(id!=null&&id.length()>0) {
			
			Integer.parseInt(id);
			model.setId(tid);			
		}
		if (tid > 0) {
			PeopleExample example = new PeopleExample();
			example.createCriteria().andIdEqualTo(model.getId());
			int rowcount = mapper.updateByExampleSelective(model, example);
			if (rowcount > 0) {
				msg.code = 0;
				msg.msg = "更新成功";
			}
		} else {
			int rowcount = mapper.insert(model);
			if (rowcount > 0) {
				msg.code = 0;
				msg.msg = "添加成功";
			}
		}
		return msg;
	}
}
