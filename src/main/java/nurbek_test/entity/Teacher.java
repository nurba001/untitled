package nurbek_test.entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teach_id;
    private String name;
    private String surname;
    private String  teach;
    private  int age;



    @ManyToMany
    @JoinColumn(name = "student_id")
    private Student getstudent;
    public Teacher(String name, String surname, String teach,int age) {
        this.age=age;
        this.name = name;
        this.surname = surname;
        this.teach = teach;
    }
    public Teacher()
    {}

    public int getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(int teach_id) {
        this.teach_id = teach_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Student getGetStudent() {
        return getstudent;
    }

    public void setGetstudent(Student getstudent) {
        this.getstudent = getstudent;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teach_id=" + teach_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", teach='" + teach + '\'' +
                ", age=" + age +
                '}';
    }
}