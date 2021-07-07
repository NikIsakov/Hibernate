package com.flamexander.hibernate.homework;

import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

public class ProductsBuyerApp {
    public static void main(String[] args) {
//        PrepareDataApp.forcePrepareData();
//        SessionFactory factory = new Configuration()
//                .configure("configs/productsCon/hibernate.cfg.xml")
//                .buildSessionFactory();

//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Buyer buyer = session.get(Buyer.class, 2L);
//            System.out.println(buyer);
//            System.out.println("Products: ");
//            for (Product p : buyer.getProducts()) {
//                System.out.println(p.getTitle());
//            }
//            buyer.getProducts().clear();
//            session.getTransaction().commit();
//        } finally {
//            factory.close();
//            if (session != null) {
//                session.close();
//            }
//        }

        BuyerService buyerService = new BuyerService();
        buyerService.findProducts(2L);

//        ProductService productService = new ProductService();
//        productService.findBuyers(2L);
    }




}
