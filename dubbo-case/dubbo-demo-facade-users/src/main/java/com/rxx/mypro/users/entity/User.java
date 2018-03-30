package com.rxx.mypro.users.entity;


import com.rxx.mypro.common.entity.BaseEntity;

/**
 * @Title      :User
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:41
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;
    private String name;
    private String sex;
    private Integer age;
    private String email;
    private String phone;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
