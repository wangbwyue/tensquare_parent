package com.tensquare.base.pojo;

import javax.persistence.*;

/**
 * @描述
 * @创建人 wangyue
 * @创建时间2019/6/129:52
 */

@Entity//必须有
@Table(name="tb_label")//可以不写，默认表名和类名一样，只是驼峰命名修改成下划线命名
public class Label {

    @Id//必须，只表示唯一不能null
    //@GeneratedValue(GenerationType.AUTO)
    private String id;//
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    //@Transient表示这个字段不和数据库做关联
    private String recommend;//是否推荐

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
