package com.flamexander.hibernate.homework;

import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudProductsApp {
    private static SessionFactory factory;

    public static void main(String[] args) {
        init();
        create();
    }

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/productsCon/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void delete() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void update() {
        try (Session session = factory.getCurrentSession()) {
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
        try (Session session = factory.getCurrentSession()) {
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
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }
}
