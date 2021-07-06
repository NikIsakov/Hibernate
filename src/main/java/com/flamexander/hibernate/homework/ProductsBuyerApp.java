package com.flamexander.hibernate.homework;

import com.flamexander.hibernate.many_to_many.Book;
import com.flamexander.hibernate.many_to_many.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductsBuyerApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("configs/productsCon/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, 1L);
            System.out.println(buyer);
            System.out.println("Products: ");
            for (Product p : buyer.getProducts()) {
                System.out.println(p.getTitle());
            }
            buyer.getProducts().clear();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
