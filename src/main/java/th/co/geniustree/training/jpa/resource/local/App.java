/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.jpa.resource.local;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Rain
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("train"); //Persistence Unit

        //em is Shell
        EntityManager em = emf.createEntityManager();

        // Transaction Boundary
        em.getTransaction().begin();
        
        Faculty eng = new Faculty(1, "Engineering");
        Student st1 = new Student(1, "Rainy", new Date());
        Student st2 = new Student(2, "Thanthathon", new Date());
        Student st3 = new Student(3, "Lovelove", new Date());
        eng.getStudents().add(st1);
        st1.setFaculty(eng);
        eng.getStudents().add(st2);
        eng.getStudents().add(st3);
        em.persist(eng);
        
        Query createQuery = em.createQuery("select f from Faculty f order by f.id"); // Select => beans (all row)
        List<Faculty> resultList = createQuery.getResultList();
        print(resultList);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void print(List<Faculty> resultList) {
        for (Faculty faculty : resultList) {
            System.out.println(faculty.getId() + "\t" + faculty.getName());
        }
    }

}
