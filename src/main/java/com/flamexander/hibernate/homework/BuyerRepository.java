package com.flamexander.hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class BuyerRepository {
    private static SessionFactory sessionFactory;

    @Autowired
    public BuyerRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public static void delete() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, 1L);
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }

    public static void update() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, 1L);
            System.out.println(buyer);
            session.evict(buyer);
            buyer.setName("Alex");
            System.out.println(buyer);
            session.update(buyer);
            session.getTransaction().commit();
            System.out.println(buyer);

        }
    }

    public static void create() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = new Buyer("Bob");
            System.out.println(buyer);
            session.saveOrUpdate(buyer);
            System.out.println(buyer);
            session.getTransaction().commit();
            System.out.println(buyer);
        }
    }

    public static void read() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, 1L);
            System.out.println(buyer);
            session.getTransaction().commit();
            System.out.println(buyer);
        }
    }


}
