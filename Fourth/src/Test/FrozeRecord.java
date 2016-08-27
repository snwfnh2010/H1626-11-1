package Test;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class FrozeRecord implements Serializable{
    private int id;
    private int uid;
    private String frozenTime;
    private String unfrozenTime;

    public FrozeRecord() {
    }

    public FrozeRecord(int id, int uid, String frozenTime, String unfrozenTime) {
        this.id = id;
        this.uid = uid;
        this.frozenTime = frozenTime;
        this.unfrozenTime = unfrozenTime;
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

    public String getFrozenTime() {
        return frozenTime;
    }

    public void setFrozenTime(String frozenTime) {
        this.frozenTime = frozenTime;
    }

    public String getUnfrozenTime() {
        return unfrozenTime;
    }

    public void setUnfrozenTime(String unfrozenTime) {
        this.unfrozenTime = unfrozenTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrozeRecord)) return false;

        FrozeRecord that = (FrozeRecord) o;

        if (id != that.id) return false;
        if (uid != that.uid) return false;
        if (frozenTime != null ? !frozenTime.equals(that.frozenTime) : that.frozenTime != null) return false;
        return unfrozenTime != null ? unfrozenTime.equals(that.unfrozenTime) : that.unfrozenTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + (frozenTime != null ? frozenTime.hashCode() : 0);
        result = 31 * result + (unfrozenTime != null ? unfrozenTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FrozeRecord{" +
                "id=" + id +
                ", uid=" + uid +
                ", frozenTime='" + frozenTime + '\'' +
                ", unfrozenTime='" + unfrozenTime + '\'' +
                '}';
    }
}
