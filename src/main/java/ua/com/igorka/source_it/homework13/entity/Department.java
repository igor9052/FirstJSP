package ua.com.igorka.source_it.homework13.entity;

import java.io.Serializable;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        return (name != null ? name.equals(that.name) : that.name != null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
