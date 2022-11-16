package nurbek_test.entity;

import javax.persistence.*;


@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int school_id;
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany
    @JoinColumn(name= "teach_id")
    private  Teacher teacher;
    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public School()
    {}

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
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
}
