package com.quest.demographics.entity;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Record Database Entity
 * @Author - Alan Kavanagh
 */
@Entity
@Table(name = "RECORD")
public class RecordEntity implements Serializable {

	@Id
	@Column(name = "PPS")
    private String pps; // unique
	
	@Column(name = "NAME")
    private String name;

	@Column(name = "DOB")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	@Temporal(TemporalType.DATE)
    private Date dob; // must be over 16 and date not in future
    
	@Column(name = "MOBILE")
    private String mobile;
	
	@Column(name = "CREATE_DT")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="UTC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDt;
	
	public RecordEntity() {}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPps() { return pps; }
	public void setPps(String pps) { this.pps = pps; }
	public Date getDob() { return dob; }
	public void setDob(Date dob) { this.dob = dob; }
	public String getMobile() { return mobile; }
	public void setMobile(String mobile) { this.mobile = mobile; }
	public Date getCreateDt() { return createDt; }
	public void setCreateDt(Date createDt) { this.createDt = createDt; }
	
}
