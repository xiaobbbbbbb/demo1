package com.example.demo.requsetVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "基础请求数据")
public class TestVo implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 商家id
     */
    @ApiModelProperty(value = "商家id", dataType = "String", required = true)
    private String shopId;

    /**
     * id
     */
    @ApiModelProperty(value = "id", dataType = "String", required = true)
    private String id;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestVo{" +
                "shopId='" + shopId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
