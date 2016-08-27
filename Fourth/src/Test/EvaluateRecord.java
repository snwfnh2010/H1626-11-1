package Test;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class EvaluateRecord implements Serializable{
    private int id;
    private int uid;
    private String content;
    private String conTime;

    public EvaluateRecord() {
    }

    public EvaluateRecord(int id, int uid, String content, String conTime) {
        this.id = id;
        this.uid = uid;
        this.content = content;
        this.conTime = conTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConTime() {
        return conTime;
    }

    public void setConTime(String conTime) {
        this.conTime = conTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EvaluateRecord)) return false;

        EvaluateRecord that = (EvaluateRecord) o;

        if (id != that.id) return false;
        if (uid != that.uid) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return conTime != null ? conTime.equals(that.conTime) : that.conTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (conTime != null ? conTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EvaluateRecord{" +
                "id=" + id +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", conTime='" + conTime + '\'' +
                '}';
    }
}
