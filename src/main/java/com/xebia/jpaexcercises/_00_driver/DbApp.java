package com.xebia.jpaexcercises._00_driver;


import com.xebia.jpaexcercises._06_temporal.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class DbApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Test Employee");
        employee.setDateOfBirth(new Date());
        employee.setRegisteredAt(new Date());
        /*File file = new File("C:\\Users\\Sakshi.Grover\\Downloads\\capture.png");
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
            employee.setPicture(bFile);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        Employee foundEmployee = entityManager.find(Employee.class, 1L);
        System.out.println(foundEmployee);
        entityManager.close();
        entityManagerFactory.close();
    }
}
