package org.example.eclipselink_example;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IgniteEclipseLinkExample {
    public static void main(String[] args) {

        try(Ignite ignite = Ignition.start("config/example-cache.xml")) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("myPU");
                EntityManager em = null;

                // Populating data
                try {
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    CacheTestObject emp = new CacheTestObject(1l, "Jane", "Doe");
                    em.merge(emp);
                    em.getTransaction().commit();

                    final CacheTestObject emp2 = em.find(CacheTestObject.class, 1l);

                    System.out.println("Find in the same entity manager: " + emp2.getFirstName() + " " + emp2.getLastName());

                }
                finally {
                    if (em != null) {
                        em.close();
                    }
                }

                System.out.println("<<< Populating done >>>");

                try {
                    em = emf.createEntityManager();
                    final CacheTestObject emp = em.find(CacheTestObject.class, 1l);

                    System.out.println("Find in new entity manager: " + emp.getFirstName() + " " + emp.getLastName());

                }
                finally {
                    if (em != null) {
                        em.close();
                    }
                }
            }
            finally {
                if (emf != null) {
                    emf.close();
                }
            }
        }
    }
}
