package com.paiban.entity;

import java.io.Serializable;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class Login implements Serializable {
    /**
     *
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    private String username;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    private String password;

    /**
     *
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    private Boolean ISDELETE;

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column login.username
     *
     * @return the value of login.username
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public Login withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * This method sets the value of the database column login.username
     *
     * @param username the value for login.username
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns the value of the database column login.password
     *
     * @return the value of login.password
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public Login withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * This method sets the value of the database column login.password
     *
     * @param password the value for login.password
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the value of the database column login.ISDELETE
     *
     * @return the value of login.ISDELETE
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public Boolean getISDELETE() {
        return ISDELETE;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public Login withISDELETE(Boolean ISDELETE) {
        this.setISDELETE(ISDELETE);
        return this;
    }

    /**
     * This method sets the value of the database column login.ISDELETE
     *
     * @param ISDELETE the value for login.ISDELETE
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    public void setISDELETE(Boolean ISDELETE) {
        this.ISDELETE = ISDELETE;
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", ISDELETE=").append(ISDELETE);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
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
        Login other = (Login) that;
        return (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getISDELETE() == null ? other.getISDELETE() == null : this.getISDELETE().equals(other.getISDELETE()));
    }

    /**
     *
     * @mbg.generated Mon Oct 29 01:33:42 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getISDELETE() == null) ? 0 : getISDELETE().hashCode());
        return result;
    }
}