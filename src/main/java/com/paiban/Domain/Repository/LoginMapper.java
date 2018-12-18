package com.paiban.Domain.Repository;

import com.paiban.entity.Login;
import com.paiban.entity.LoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    long countByExample(LoginExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int deleteByExample(LoginExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int insert(Login record);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int insertSelective(Login record);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    List<Login> selectByExample(LoginExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

    /**
     *
     * @mbg.generated Mon Oct 29 01:56:21 CST 2018
     */
    int logicalDeleteByExample(@Param("example") LoginExample example);
}