package com.mosaiker.sign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    private long uId;

    @Id
    @Column(name = "u_id", nullable = false)
    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (uId != player.uId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (uId ^ (uId >>> 32));
    }
}
