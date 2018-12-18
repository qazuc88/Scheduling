package com.paiban.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paiban.Application.PaibanService;
import com.paiban.Domain.Repository.PaibanMapper;
import com.paiban.Infrastructure.util.Message;
import com.paiban.entity .Paiban;
import com.paiban.entity .PaibanExample;

@Controller
public class PaibanController{
    @Resource
    PaibanMapper mapper;
    @RequestMapping(path = "/paibanlist", method = RequestMethod.GET)
    public String List() {
         return "paiban/list";
    }
    

    /**
     * 插入单条数据
     * @param record the record you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    @Transactional
    public Paiban insertOne(@RequestBody Paiban record) {
        mapper.insertSelective(record);
        return record;
    }


    /**
     * 批量插入
     * @param records the records you want to create
     * @return created records(with primary key if your mapper supports it)
     */
    @RequestMapping(path = "batch", method = RequestMethod.POST)
    @Transactional
    public List<Paiban> insertBatch(@RequestBody List<Paiban> records) {
        for (Paiban record : records) {
            mapper.insertSelective(record);
        }
        return records;
    }

    /**
     * 更新单条数据
     * @param record the records you want to update
     * @return affected row count
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    @Transactional
    public int updateOne(@RequestBody Paiban record) {
        return mapper.updateByPrimaryKey(record);

    }

    /**
     * 批量更新数据
     * @param records the records you want to update
     * @return affected row count
     */
    // TODO: 2018/3/25 update batch
    @RequestMapping(path = "batch", method = RequestMethod.PUT)
    @Transactional
    public long updateBatch(@RequestBody List<Paiban> records) {
        int count = 0;
        for (Paiban record : records) {
            count += mapper.updateByPrimaryKey(record);
        }
        return count;
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
        return mapper.deleteByPrimaryKey(id);
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
        long count = 0;
        for (Integer id : ids) {
            count += mapper.deleteByPrimaryKey(id);
        }
        return count;
    }

}