package com.paiban.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class Paiban implements Serializable {
    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public static final Boolean NOT_DELETED = false;

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public static final Boolean DELETED = true;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private String peopleName;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Integer month;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Integer day;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Integer year;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private String remark;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Date date;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private Boolean ISDELETE;

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column paiban.Id
     *
     * @return the value of paiban.Id
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Id
     *
     * @param id the value for paiban.Id
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column paiban.PeopleName
     *
     * @return the value of paiban.PeopleName
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public String getPeopleName() {
        return peopleName;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withPeopleName(String peopleName) {
        this.setPeopleName(peopleName);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.PeopleName
     *
     * @param peopleName the value for paiban.PeopleName
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    /**
     * This method returns the value of the database column paiban.Month
     *
     * @return the value of paiban.Month
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Integer getMonth() {
        return month;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withMonth(Integer month) {
        this.setMonth(month);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Month
     *
     * @param month the value for paiban.Month
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * This method returns the value of the database column paiban.Day
     *
     * @return the value of paiban.Day
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Integer getDay() {
        return day;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withDay(Integer day) {
        this.setDay(day);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Day
     *
     * @param day the value for paiban.Day
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * This method returns the value of the database column paiban.Year
     *
     * @return the value of paiban.Year
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withYear(Integer year) {
        this.setYear(year);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Year
     *
     * @param year the value for paiban.Year
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method returns the value of the database column paiban.Remark
     *
     * @return the value of paiban.Remark
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Remark
     *
     * @param remark the value for paiban.Remark
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column paiban.Date
     *
     * @return the value of paiban.Date
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withDate(Date date) {
        this.setDate(date);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.Date
     *
     * @param date the value for paiban.Date
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method returns the value of the database column paiban.ISDELETE
     *
     * @return the value of paiban.ISDELETE
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Boolean getISDELETE() {
        return ISDELETE;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public Paiban withISDELETE(Boolean ISDELETE) {
        this.setISDELETE(ISDELETE);
        return this;
    }

    /**
     * This method sets the value of the database column paiban.ISDELETE
     *
     * @param ISDELETE the value for paiban.ISDELETE
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void setISDELETE(Boolean ISDELETE) {
        this.ISDELETE = ISDELETE;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", peopleName=").append(peopleName);
        sb.append(", month=").append(month);
        sb.append(", day=").append(day);
        sb.append(", year=").append(year);
        sb.append(", remark=").append(remark);
        sb.append(", date=").append(date);
        sb.append(", ISDELETE=").append(ISDELETE);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    public void andLogicalDeleted(boolean deleted) {
        setISDELETE(deleted ? DELETED : NOT_DELETED);
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Paiban other = (Paiban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPeopleName() == null ? other.getPeopleName() == null : this.getPeopleName().equals(other.getPeopleName()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getISDELETE() == null ? other.getISDELETE() == null : this.getISDELETE().equals(other.getISDELETE()));
    }

    /**
     *
     * @mbg.generated Mon Oct 29 04:04:48 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPeopleName() == null) ? 0 : getPeopleName().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getISDELETE() == null) ? 0 : getISDELETE().hashCode());
        return result;
    }
}