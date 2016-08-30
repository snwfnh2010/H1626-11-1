package Project1.model;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class OrdBook implements Serializable {
    private int id;
    private int uid;
    private int bid;
    private String ordTime;

    public OrdBook() {
    }

    public OrdBook(int id, int uid, int bid, String ordTime) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.ordTime = ordTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(String ordTime) {
        this.ordTime = ordTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdBook)) return false;

        OrdBook ordBook = (OrdBook) o;

        if (id != ordBook.id) return false;
        if (uid != ordBook.uid) return false;
        if (bid != ordBook.bid) return false;
        return ordTime != null ? ordTime.equals(ordBook.ordTime) : ordBook.ordTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + bid;
        result = 31 * result + (ordTime != null ? ordTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrdBook{" +
                "id=" + id +
                ", uid=" + uid +
                ", bid=" + bid +
                ", ordTime='" + ordTime + '\'' +
                '}';
    }
}
