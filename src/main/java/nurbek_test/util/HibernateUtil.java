package nurbek_test.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private  static final SessionFactory session=buildSessionFactory() ;

    private static SessionFactory buildSessionFactory(){
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch(Throwable e)
        {
            System.out.println("session not create: "+ e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public  static  SessionFactory getSession()
    {
        return session;  }
    public  static  void shuntDown()
    {
        getSession().close();
    }

}


