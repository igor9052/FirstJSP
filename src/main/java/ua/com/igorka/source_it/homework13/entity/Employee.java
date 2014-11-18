package ua.com.igorka.source_it.homework13.entity;

import java.io.Serializable;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public class Employee implements Serializable {
    private static final int MAX_AGE = 120;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private int age;
    private String email;
    private long departmentId;

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

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        if (age > MAX_AGE) {
            throw new IllegalArgumentException("age = " + age + ". Age should be less than " + MAX_AGE);
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public long getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (departmentId != employee.departmentId) return false;
        if (id != employee.id) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        return (name != null ? name.equals(employee.name) : employee.name != null);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        return result;
    }
}
