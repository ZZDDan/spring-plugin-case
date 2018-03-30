package com.rxx.mypro.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title      :BaseEntity
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:23
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键  */
	private String id;
	/** 版本号 */
	private String version;
	/** 创建日期 */
	private Date createDate;
	/** 更新日期 */
	private Date updateDate;
	
	/** 主键  */
	public String getId() {
		return id;
	}

	/** 主键  */
	public void setId(String id) {
		this.id = id;
	}
	/** 版本号 */
	public String getVersion() {
		return version;
	}
	/** 版本号 */
	public void setVersion(String version) {
		this.version = version;
	}
	/** 创建日期 */
	public Date getCreateDate() {
		return createDate;
	}
	/** 创建日期 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/** 更新日期 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/** 更新日期 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
