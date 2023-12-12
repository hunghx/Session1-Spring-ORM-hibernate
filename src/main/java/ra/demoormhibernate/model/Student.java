package ra.demoormhibernate.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    // định nghĩa khóa chính
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    private String address;
    @Column(length = 15)
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Boolean sex;

    public Student() {
    }

    public Student(Long id, String name, String address, String phone, Date birthday, Boolean sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
