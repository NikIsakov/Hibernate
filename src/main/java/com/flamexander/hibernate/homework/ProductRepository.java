package com.flamexander.hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductRepository {
    private static SessionFactory sessionFactory;

    @Autowired
    public ProductRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public static void delete() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void update() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.evict(product);
            product.setCost(555);
            System.out.println(product);
            session.update(product);
            session.getTransaction().commit();
            System.out.println(product);

        }
    }

    public static void create() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product("Product #",1200);
            System.out.println(product);
            session.saveOrUpdate(product);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void read() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }
}
