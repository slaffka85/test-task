package org.sberteh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Employee entity
 *
 * @author vtsapaev
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String phone;

    /**
     * method return employee's id-value
     * @return employee's id
     */
    @SuppressWarnings("unused")
    public Long getId() {
        return id;
    }

    /**
     * method set employee's id-value
     * @param id employee's id
     */
    @SuppressWarnings("unused")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * method return employee's name
     * @return employee's name
     */
    public String getName() {
        return name;
    }

    /**
     *  method set employee's name
     * @param name employee's name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
