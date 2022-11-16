package nurbek_test;

import nurbek_test.entity.School;
import nurbek_test.entity.Student;
import nurbek_test.entity.Teacher;
import nurbek_test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.sql.Select;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Student student =new Student("Ali","Asanov","-",27);
     create(student);*/
       /* Teacher teacher=new Teacher("Oleg","Derminov","fitnes",29);
     create(teacher);*/
        /*  School school=new School("№12","st:Suiunbaev S. 12");
     create(school);*/
        System.out.println(getById(3));

    }

    public static int create(School school){         //создаем таблицу
        Session session = HibernateUtil.getSession().openSession();  //открываем Сешен
        session.beginTransaction();//начинаем транзакцию
        session.save(school);// сохранаем в базу
        session.getTransaction().commit();//получаем транзакцию,и сохранаем изминения
        session.close();//закрываем сешен
        System.out.println("Add successfully:"+ school);
        return school.getSchool_id();
    }

    public static int create(Teacher teacher){         //создаем таблицу
        Session session = HibernateUtil.getSession().openSession();  //открываем Сешен
        session.beginTransaction();//начинаем транзакцию
        session.save(teacher);// сохранаем в базу
        session.getTransaction().commit();//получаем транзакцию,и сохранаем изминения
        session.close();//закрываем сешен
        System.out.println("Add successfully:"+ teacher);
        return teacher.getTeach_id();
    }
    public static int create(Student student1){         //создаем таблицу
        Session session = HibernateUtil.getSession().openSession();  //открываем Сешен
        session.beginTransaction();//начинаем транзакцию
        session.save(student1);// сохранаем в базу
        session.getTransaction().commit();//получаем транзакцию,и сохранаем изминения
        session.close();//закрываем сешен
        System.out.println("Add successfully:"+ student1);
        return student1.getId();
    }
    public static Teacher  getById(int id){          //получаем данные через ID ,или выводим данные
        Session session=HibernateUtil.getSession().openSession();   //открываем Сешен
        session.beginTransaction();         //начинаем транзакцию

        Teacher teacher=session.get(Teacher.class,id);   //получаем: студент.класс - id
        System.out.println(teacher.getGetStudent());
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    public static List<Student> getAllStudent(){    //select
       Session session =HibernateUtil.getSession().openSession();
            session.beginTransaction();
            List<Student> students=session.createQuery("from Student where age>17 and nameStudent='Asamat'").getResultList();
            session.getTransaction().commit();
            session.close();
            System.out.println("Finded"+students.size());
            return students;
    }
    public static Student update1(int id,String name,String surname,String course,int age){ //данныйларды озгортобуз
        Session session =HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student=session.get(Student.class,id);
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        student.setCourse(course);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("successfully update");
        return student;
    }

    public static School update3(int id,String address){ //данныйларды озгортобуз
        Session session =HibernateUtil.getSession().openSession();
        session.beginTransaction();
        School student=session.get(School.class,id);
        student.setSchool_id(id);
        student.setAddress(address);
        session.getTransaction().commit();
        session.close();
        System.out.println("successfully update3");
        return student;
    }

    public static Student update(int id,String name,int age){ //данныйларды озгортобуз
        Session session =HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student=session.get(Student.class,id);
        student.setId(id);
    student.setName(name);
//        student.setSurname(surname);
//        student.setCourse(course);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("successfully update");
        return student;
    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student=session.get(Student.class,id );
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Delete +++");
    }
    public static void deletAll(){ // удаляеть все данные из таблицы
        Session session=HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query= session.createQuery("DELETE FROM Student");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("successfully deleted all tre");
    }
}
