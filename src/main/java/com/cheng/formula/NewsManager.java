/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheng.formula;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author james
 */
public class NewsManager {
    
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure();
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();
        
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        
        News n = new News();
        n.setTitle("疯狂Java联盟成立了");
        n.setContent("疯狂Java联盟成立了，"
                + "网站地址http://www.crazyit.org");
        
        sess.save(n);
        		sess.save(n);
        tx.commit();
        sess.close();
        sf.close();
    }
}
