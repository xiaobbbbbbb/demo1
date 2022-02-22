package com.example.demo;

/**
 * 数据库实体表对应的bean
 */
@DbTabel(name = "user")
public class User {
    @SQLString(name="id",value = 50,constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name="name",value = 20)
    private String name;

    @SQLInteger(name = "age")
    private Integer age;

    @SQLString(name = "remark",value = 255,constraint = @Constraints(allowNull = true))
    private String remark;
}
