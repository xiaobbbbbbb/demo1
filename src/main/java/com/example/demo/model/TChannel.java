package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "easybuy",shards = 1,replicas = 1)
public class TChannel {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String shopId;

    @Field(type = FieldType.Date, name = "create_time", format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    @Field(type = FieldType.Long)
    private Long sendNums;
    @Field(type =FieldType.Text )
    private String linkman;
    @Field(type = FieldType.Text)
    private String name;

    public TChannel(String id , String shopId, String createTime, Long sendNums, String linkman, String name){
        this.id=id;
        this.shopId=shopId;
        this.createTime=createTime;
        this.sendNums=sendNums;
        this.linkman=linkman;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getSendNums() {
        return sendNums;
    }

    public void setSendNums(Long sendNums) {
        this.sendNums = sendNums;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
