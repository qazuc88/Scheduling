package com.paiban.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paiban.Application.PaibanService;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.Paiban;
import com.paiban.entity.PaibanExample;
import com.paiban.entity.People;
import com.paiban.entity.PeopleExample;

import kye.Config;

@Service
@RestController
@RequestMapping(path = "api/paiban")
public class PaibanRestController {

@Resource 
PaibanService service;

	@RequestMapping(path = "/getlist", method = RequestMethod.GET)
	@Transactional
	@ResponseBody
	public Message getList(@RequestParam(value = "field", required = false) String field// 要搜索的字段
			, @RequestParam(value = "type", defaultValue = "none") String type// 搜索类型，支持in,notIn,like,notLike,equals,notEquals....

			, @RequestParam(value = "sort", required = false, defaultValue = "date") String sort// 排序字段
			, @RequestParam(value = "order", required = false, defaultValue = "desc") String order// 排序方式
			, @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page// limit
			, @RequestParam(value = "limit", required = false, defaultValue = "100") @Min(0) Integer limit// limit
			, String peopleName, String startdate, String enddate
	// , @RequestParam(value = "offset", required = false, defaultValue = "0")
	// @Max(1000) @Min(0) Integer offset// offset
	) {
		return service.GetList(field// 要搜索的字段
				, type// 搜索类型，支持in,notIn,like,notLike,equals,notEquals....

				, sort// 排序字段
				, order// 排序方式
				,   page// limit
				, limit// limit
				,  peopleName,  startdate,  enddate);
	}

	@ResponseBody
	@RequestMapping(path = "/startpaiban")
	@RequiresRoles("admin")
	public Message Startpaiban(@RequestParam("selectmonth") String selectmonth) {
		return service.Startpaiban(selectmonth);
	}

	/**
	 * 插入单条数据
	 * 
	 * @param record the record you want to create
	 * @return created records(with primary key if your mapper supports it)
	 */
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Transactional
	public int insertOne(@RequestBody Paiban record) {
		return service.insertSelective(record);
	}

	/**
	 * 批量插入
	 * 
	 * @param records the records you want to create
	 * @return created records(with primary key if your mapper supports it)
	 */
	@RequestMapping(path = "batch", method = RequestMethod.POST)
	@Transactional
	public List<Paiban> insertBatch(@RequestBody List<Paiban> records) {
		return service.insertBatch(records);
	}

	/**
	 * 更新单条数据
	 * 
	 * @param record the records you want to update
	 * @return affected row count
	 */
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public int updateOne(@RequestBody Paiban record) {
		return service.updateByPrimaryKey(record);
	}

	/**
	 * 批量更新数据
	 * 
	 * @param records the records you want to update
	 * @return affected row count
	 */
	// TODO: 2018/3/25 update batch
	@RequestMapping(path = "batch", method = RequestMethod.PUT)
	@Transactional
	public long UpdateBatch(@RequestBody List<Paiban> records) {
				return service.UpdateBatch(records);
	}

	/**
	 * delete a record by id
	 *
	 * @param id the id of the record you want to delete
	 * @return affected row count
	 */
	// TODO: 2018/3/25 delete one
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public int deleteOne(@PathVariable("id") Integer id) {
		return service.deleteByPrimaryKey(id);
	}

	/**
	 * batch delete
	 *
	 * @param ids the ids of the records you want to delete
	 * @return affected row count
	 */
	@RequestMapping(path = "", method = RequestMethod.DELETE)
	@Transactional
	public long deleteBatch(@RequestParam("id") List<Integer> ids) {
		return service.DeleteBatch(ids);
	}

}