package com.kuaizhan.kzweixin.dao.mapper.auto;

import com.kuaizhan.kzweixin.dao.po.auto.Account;
import com.kuaizhan.kzweixin.dao.po.auto.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int deleteByPrimaryKey(Long weixinAppid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    List<Account> selectByExampleWithBLOBs(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    Account selectByPrimaryKey(Long weixinAppid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table site_weixin
     *
     * @mbggenerated Tue Jun 13 18:51:40 CST 2017
     */
    int updateByPrimaryKey(Account record);
}