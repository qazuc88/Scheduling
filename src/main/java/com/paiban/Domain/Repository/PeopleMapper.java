package com.paiban.Domain.Repository;

import com.paiban.entity.People;
import com.paiban.entity.PeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeopleMapper {
    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    long countByExample(PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int deleteByExample(PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int insert(People record);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int insertSelective(People record);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    List<People> selectByExample(PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    People selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    People selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") People record, @Param("example") PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int updateByExample(@Param("record") People record, @Param("example") PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int updateByPrimaryKeySelective(People record);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int updateByPrimaryKey(People record);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int logicalDeleteByExample(@Param("example") PeopleExample example);

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    int logicalDeleteByPrimaryKey(Integer id);
}