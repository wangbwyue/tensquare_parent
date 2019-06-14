package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @描述
 * JpaRepository提供了基本的增删改查JpaSpecificationExecutor用于做复杂的条件查询
 * @创建人 wangyue
 * @创建时间2019/6/129:59
 */

public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label> {

}
