package com.paiban.entity;

import java.io.Serializable;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class People implements Serializable {
    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public static final Boolean NOT_DELETED = false;

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public static final Boolean DELETED = true;

    /**
     *
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    private String peoplename;

    /**
     *
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    private Boolean isDelete;

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column people.Id
     *
     * @return the value of people.Id
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public People withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column people.Id
     *
     * @param id the value for people.Id
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column people.peoplename
     *
     * @return the value of people.peoplename
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public String getPeoplename() {
        return peoplename;
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public People withPeoplename(String peoplename) {
        this.setPeoplename(peoplename);
        return this;
    }

    /**
     * This method sets the value of the database column people.peoplename
     *
     * @param peoplename the value for people.peoplename
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public void setPeoplename(String peoplename) {
        this.peoplename = peoplename;
    }

    /**
     * This method returns the value of the database column people.IsDelete
     *
     * @return the value of people.IsDelete
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public People withIsDelete(Boolean isDelete) {
        this.setIsDelete(isDelete);
        return this;
    }

    /**
     * This method sets the value of the database column people.IsDelete
     *
     * @param isDelete the value for people.IsDelete
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", peoplename=").append(peoplename);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    public void andLogicalDeleted(boolean deleted) {
        setIsDelete(deleted ? DELETED : NOT_DELETED);
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
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
        People other = (People) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPeoplename() == null ? other.getPeoplename() == null : this.getPeoplename().equals(other.getPeoplename()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    /**
     *
     * @mbg.generated Fri Nov 09 10:19:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPeoplename() == null) ? 0 : getPeoplename().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}