package com.flamexander.hibernate.homework;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProductService {

    public void findBuyers(Serializable id) {
//        PrepareDataApp.forcePrepareData();
        SessionFactory factory = new Configuration()
                .configure("configs/productsCon/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            System.out.println("Products: ");
            for (Buyer b : product.getBuyers()) {
                System.out.println(b.getName());
            }
            product.getBuyers().clear();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }


}
