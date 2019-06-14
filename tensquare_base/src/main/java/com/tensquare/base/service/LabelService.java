package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @描述
 * @创建人 wangyue
 * @创建时间2019/6/1210:01
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }
    /**
     * 根据ID查询标签
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    /**
     * 增加标签
     * @param label
     */
    public void insert(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }
    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }
    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public Page<Label> findSearch(Map searchMap, int page, int size){
        //通过内部类方式，创建条件对象Specification
        Specification specification = getSpecification(searchMap);
        PageRequest pageRequest=PageRequest.of(page-1,size);
        return labelDao.findAll(specification,pageRequest);
    }
    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Specification getSpecification(Map searchMap) {
        return new Specification<Label>() {
                public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    List<Predicate> predicateList=new ArrayList<>();
                    //判断传过来的参数是否存在
                    if(searchMap.get("labelname")!=null && !"".equals(searchMap.get("labelname"))){
                        predicateList.add(cb.like(root.get("labelname").as(String.class), "%"+ (String)searchMap.get("labelname")+"%" ) );
                    }
                    if(searchMap.get("state")!=null && !"".equals(searchMap.get("state"))){
                        predicateList.add(cb.equal(root.get("state").as(String.class), (String)searchMap.get("state") ) );
                    }
                    if(searchMap.get("recommend")!=null && !"".equals(searchMap.get("recommend"))){
                        predicateList.add(cb.equal( root.get("recommend").as(String.class), (String)searchMap.get("recommend") ) );
                    }
                    return cb.and( predicateList.toArray( new Predicate[predicateList.size()]) );
                }
            };
    }
}
