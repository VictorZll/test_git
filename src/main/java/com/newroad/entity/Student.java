package com.newroad.entity;

import java.math.BigDecimal;

public class Student {
    private BigDecimal stuno;

    private String stuname;

    private String stusex;

    private Short stuage;

    private BigDecimal stuid;

    public BigDecimal getStuno() {
        return stuno;
    }

    public void setStuno(BigDecimal stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public Short getStuage() {
        return stuage;
    }

    public void setStuage(Short stuage) {
        this.stuage = stuage;
    }

    public BigDecimal getStuid() {
        return stuid;
    }

    public void setStuid(BigDecimal stuid) {
        this.stuid = stuid;
    }

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stusex=" + stusex + ", stuage=" + stuage
				+ ", stuid=" + stuid + "]";
	}

	public Student(BigDecimal stuno, String stuname, String stusex, Short stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stusex = stusex;
		this.stuage = stuage;
	}

	public Student() {
		super();
	}
    
}