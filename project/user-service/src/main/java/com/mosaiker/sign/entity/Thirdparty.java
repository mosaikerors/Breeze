package com.mosaiker.sign.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thirdparty {
    private long uId;
    private String company;

    @Id
    @Column(name = "u_id", nullable = false)
    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "company", nullable = false, length = 128)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thirdparty that = (Thirdparty) o;

        if (uId != that.uId) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (uId ^ (uId >>> 32));
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
