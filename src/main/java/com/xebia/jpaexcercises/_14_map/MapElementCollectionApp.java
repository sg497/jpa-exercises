package com.xebia.jpaexcercises._14_map;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapElementCollectionApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Map<String, PhoneNumbers> phoneNumbers = new HashMap<>();
            PhoneNumbers homePhoneNumbers = new PhoneNumbers(Collections.singletonList("12345"));
            phoneNumbers.put("home", homePhoneNumbers);
            PhoneNumbers officePhoneNumbers = new PhoneNumbers(Collections.singletonList("123458788"));
            phoneNumbers.put("office", officePhoneNumbers);
            Employee employee = new Employee("Test Employee", phoneNumbers);
            entityManager.persist(homePhoneNumbers);
            entityManager.persist(officePhoneNumbers);
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            entityManager.close();

            entityManager = entityManagerFactory.createEntityManager();
            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println(foundEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
