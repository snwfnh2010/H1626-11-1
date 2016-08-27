package Project1.model;

import java.io.Serializable;

/**
 * Created by snwfnh on 2016/8/25.
 */
public class Book implements Serializable {
    private int id;
    private String name;
    private int count;
    private String type;
    private String author;
    private int discount;
    private int hasLended;

    public Book() {
    }

    public Book(int id, String name, int count, String type, String author, int discount, int hasLended) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.type = type;
        this.author = author;
        this.discount = discount;
        this.hasLended = hasLended;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getHasLended() {
        return hasLended;
    }

    public void setHasLended(int hasLended) {
        this.hasLended = hasLended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (count != book.count) return false;
        if (discount != book.discount) return false;
        if (hasLended != book.hasLended) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (type != null ? !type.equals(book.type) : book.type != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + discount;
        result = 31 * result + hasLended;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", discount=" + discount +
                ", hasLended=" + hasLended +
                '}';
    }
}
