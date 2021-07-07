package com.flamexander.hibernate.homework;

import com.flamexander.hibernate.PrepareDataApp;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BuyerService {
    public void findProducts(Serializable id) {
        PrepareDataApp.forcePrepareData();
        SessionFactory factory = new Configuration()
                .configure("configs/productsCon/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
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
