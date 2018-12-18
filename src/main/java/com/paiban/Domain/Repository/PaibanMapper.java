package com.paiban.Domain.Repository;

import com.paiban.entity.Paiban;
import com.paiban.entity.PaibanExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaibanMapper {
    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    long countByExample(PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int deleteByExample(PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int insert(Paiban record);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int insertSelective(Paiban record);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    List<Paiban> selectByExample(PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    Paiban selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    Paiban selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") Paiban record, @Param("example") PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int updateByExample(@Param("record") Paiban record, @Param("example") PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int updateByPrimaryKeySelective(Paiban record);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int updateByPrimaryKey(Paiban record);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int logicalDeleteByExample(@Param("example") PaibanExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 03:57:55 CST 2018
     */
    int logicalDeleteByPrimaryKey(Integer id);
}