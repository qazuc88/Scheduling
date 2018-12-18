package com.paiban.Application.Implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.paiban.Application.PaibanService;
import com.paiban.Domain.Repository.PaibanMapper;
import com.paiban.Domain.Repository.PeopleMapper;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity.Paiban;
import com.paiban.entity.PaibanExample;
import com.paiban.entity.People;
import com.paiban.entity.PeopleExample;
@Service
public class PaibanServiceImpl implements PaibanService {
	@Resource
	PaibanMapper mapper;
	@Resource
	PeopleMapper peoplemapper;

	public Message GetList(String field// 要搜索的字段
			, String type// 搜索类型，支持in,notIn,like,notLike,equals,notEquals....
			, String sort// 排序字段
			, String order// 排序方式
			, Integer page// limit
			, Integer limit// limit
			, String peopleName, String startdate, String enddate
	// , @RequestParam(value = "offset", required = false, defaultValue = "0")
	// @Max(1000) @Min(0) Integer offset// offset
	) {
		Message msg = new Message();

		PaibanExample example = new PaibanExample();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM");

		if (startdate != null && startdate.length() > 0) {
			try {
				Date date = dateformat.parse(startdate);
				example.createCriteria().andDateGreaterThanOrEqualTo(date);
			} catch (ParseException e) {
				e.printStackTrace();
				msg.code = 500;
				msg.msg = e.getMessage();
				return msg;
			}
		}
		if (enddate != null && enddate.length() > 0) {
			try {
				Date date = dateformat.parse(enddate);
				example.createCriteria().andDateLessThan(date);
			} catch (ParseException e) {
				e.printStackTrace();
				msg.code = 500;
				msg.msg = e.getMessage();
				return msg;
			}
		}
		if (peopleName != null && peopleName.length() > 0) {
			example.createCriteria().andPeopleNameLike("%" + peopleName + "%");
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
		msg.code = 0;
		return msg;
	}

	public Message Startpaiban(String selectmonth) {

		PaibanExample paibansearch = new PaibanExample();

		Message msg = new Message();

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM");
		Date month = new Date();
		try {
			// dateformat.setTimeZone(TimeZone.getTimeZone(Config.TimeZone));
			month = dateformat.parse(selectmonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.msg = e.getMessage();
			msg.code = -1;
			return msg;
		}
		Calendar startcalendar = Calendar.getInstance();
		// startcalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		startcalendar.setTime(month);

		Calendar endcalendar = Calendar.getInstance();
		// endcalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		endcalendar.setTime(month);
		endcalendar.add(Calendar.MONTH, 1);
		int daycount = endcalendar.get(Calendar.DAY_OF_YEAR) - startcalendar.get(Calendar.DAY_OF_YEAR);

		System.out.println(month);
		System.out.println(startcalendar);
		System.out.println(endcalendar);

		paibansearch.createCriteria().andDateBetween(startcalendar.getTime(), endcalendar.getTime());
		long count = mapper.countByExample(paibansearch);
		if (count > 0) {
			msg.code = 400;
			msg.msg = "当前月已经存在排班";
			return msg;
		}
		Random random = new Random();
		random.nextInt(30);
		List<People> list = peoplemapper.selectByExample(new PeopleExample());
		List<People> randomlist = new ArrayList<People>();
		while (list.size() > 0) {
			int size = list.size();
			int index = 0;
			if (size > 1) {
				index = random.nextInt(size - 1);
			}
			People p = list.get(index);
			randomlist.add(p);
			list.remove(index);
		}

		System.out.println(daycount);
		System.out.println(randomlist);

		List<Paiban> data = new ArrayList<Paiban>();
		for (int i = 0, j = daycount, k = randomlist.size(); i < j; i++) {
			int index = i % k;
			People p = randomlist.get(index);
			Paiban item = new Paiban();

			Calendar calendar = Calendar.getInstance();
			// calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
			calendar.setTime(month);
			calendar.add(Calendar.DAY_OF_YEAR, i);
			Date date = calendar.getTime();
			item.setDate(date);
			System.out.println(date);
			item.setPeopleName(p.getPeoplename());
			data.add(item);
			System.out.println(item);
			mapper.insertSelective(item);
		}
		msg.code = 0;
		msg.data = data;
		return msg;
	}

	@Override
	public long DeleteBatch(List<Integer> ids) {
		long count = 0;
		for (Integer id : ids) {
			count += mapper.deleteByPrimaryKey(id);
		}
		return count;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public long UpdateBatch(@RequestBody List<Paiban> records) {
		int count = 0;
		for (Paiban record : records) {
			count += mapper.updateByPrimaryKey(record);
		}
		return count;
	}

	@Override
	public int updateByPrimaryKey(Paiban record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Paiban> insertBatch(@RequestBody List<Paiban> records) {
		for (Paiban record : records) {
			mapper.insertSelective(record);
		}
		return records;
	}

	@Override
	public int insertSelective(Paiban record) {		
		return mapper.insertSelective(record);
	}
}
