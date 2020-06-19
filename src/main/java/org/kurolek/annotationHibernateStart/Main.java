package org.kurolek.annotationHibernateStart;

import org.hibernate.SessionFactory;
import org.kurolek.annotationHibernateStart.entity.Weapon;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        System.out.println("Start");

        Weapon weapon = new Weapon();
        weapon.setName("Some weapon");
        entityManager.getTransaction().begin();
        entityManager.persist(weapon);
        entityManager.getTransaction().commit();

        Weapon weapon1 = entityManager.find(Weapon.class, 1L);
        System.out.println("Our weapon - " + weapon1.getName());

        entityManager.close();
        sessionFactory.close();

        System.out.println("End");
    }
}
