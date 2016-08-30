package Project1.model;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private int point;
    private int level;

    public User() {

    }

    public User(String name, String password) {
       this(0,name,password,0,0);
    }

    public User(String name, String password, int point, int level) {
        this(0,name,password,point,level);
    }

    public User(int id, String name, String password, int point, int level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.point = point;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (point != user.point) return false;
        if (level != user.level) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + point;
        result = 31 * result + level;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", level=" + level +
                '}';
    }
}
