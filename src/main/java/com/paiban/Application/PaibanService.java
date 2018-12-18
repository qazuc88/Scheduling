package com.paiban.Application;

import java.util.List;


import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.Paiban;

public interface PaibanService extends ApplicationService {

	Message Startpaiban(String selectmonth);

	Message GetList(String field, String type, String sort, String order, Integer page, Integer limit,
			String peopleName, String startdate, String enddate);

	long DeleteBatch(List<Integer> ids);

	int deleteByPrimaryKey(Integer id);

	long UpdateBatch(List<Paiban> records);

	int updateByPrimaryKey(Paiban record);

	List<Paiban> insertBatch(List<Paiban> records);

	int insertSelective(Paiban record);

}
