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
public class App1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("train"); //Persistence Unit

        //em is Shell
        EntityManager em = emf.createEntityManager();

        // Transaction Boundary
        em.getTransaction().begin();
        
        Faculty fac = em.find(Faculty.class, 1);
        printSt(fac.getStudents());
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void print(List<Faculty> resultList) {
        for (Faculty faculty : resultList) {
            System.out.println(faculty.getId() + "\t" + faculty.getName());
        }
    }
    private static void printSt(List<Student> resultList) {
        for (Student st : resultList) {
            System.out.println(st.getId() + "\t" + st.getName());
        }
    }

}
