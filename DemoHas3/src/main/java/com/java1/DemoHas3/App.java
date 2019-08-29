package com.java1.DemoHas3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
         
        Role role = (Role) session.get(Role.class, 2);
 
        User user = new User("Fruzenshtein", "qwerty");
        user.setRole(role);
         
        session.save(user);
         
        session.getTransaction().commit();
         
        session.close();
    }
}
