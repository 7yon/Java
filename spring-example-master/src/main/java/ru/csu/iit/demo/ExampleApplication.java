package ru.csu.iit.demo;

import org.hibernate.Session;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User contactEntity = new User();

        contactEntity.setLogin("DASHA");
        contactEntity.setAdmin(false);
        contactEntity.setPassword("123");

        session.save(contactEntity);
        session.getTransaction().commit();
        //SpringApplication.run(ExampleApplication.class, args);
        session.close();
    }
}
