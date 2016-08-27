package Project1.model;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class BookInfo implements Serializable {
    private int id;
    private int bid;
    private int inout;
    private int state;
    private int lost;

    public BookInfo() {
    }

    public BookInfo(int id, int bid, int inout, int state, int lost) {
        this.id = id;
        this.bid = bid;
        this.inout = inout;
        this.state = state;
        this.lost = lost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getInout() {
        return inout;
    }

    public void setInout(int inout) {
        this.inout = inout;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookInfo)) return false;

        BookInfo bookInfo = (BookInfo) o;

        if (id != bookInfo.id) return false;
        if (bid != bookInfo.bid) return false;
        if (inout != bookInfo.inout) return false;
        if (state != bookInfo.state) return false;
        return lost == bookInfo.lost;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bid;
        result = 31 * result + inout;
        result = 31 * result + state;
        result = 31 * result + lost;
        return result;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", bid=" + bid +
                ", inout=" + inout +
                ", state=" + state +
                ", lost=" + lost +
                '}';
    }
}
