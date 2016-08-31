package Project1.model;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class LendRecord implements Serializable {
    private int id;
    private int uid;
    private int biid;
    private int bid;
    private String lendTime;
    private String returnTime;

    public LendRecord() {
    }

    public LendRecord(int id, int uid, int biid, int bid, String lendTime, String returnTime) {
        this.id = id;
        this.uid = uid;
        this.biid = biid;
        this.bid = bid;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
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

    public int getBiid() {
        return biid;
    }

    public void setBiid(int biid) {
        this.biid = biid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LendRecord)) return false;

        LendRecord that = (LendRecord) o;

        if (id != that.id) return false;
        if (uid != that.uid) return false;
        if (biid != that.biid) return false;
        if (bid != that.bid) return false;
        if (lendTime != null ? !lendTime.equals(that.lendTime) : that.lendTime != null) return false;
        return returnTime != null ? returnTime.equals(that.returnTime) : that.returnTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + biid;
        result = 31 * result + bid;
        result = 31 * result + (lendTime != null ? lendTime.hashCode() : 0);
        result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LendRecord{" +
                "id=" + id +
                ", uid=" + uid +
                ", biid=" + biid +
                ", bid=" + bid +
                ", lendTime='" + lendTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }
}