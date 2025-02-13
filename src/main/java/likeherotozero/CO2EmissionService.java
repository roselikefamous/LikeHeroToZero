package likeherotozero;

import javax.persistence.*;
import java.util.List;

public class CO2EmissionService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("likeHeroPU");


    public CO2Emission getLatestEmissionForCountry(String country) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<CO2Emission> query = em.createQuery(
                    "SELECT e FROM CO2Emission e " +
                            "WHERE e.country = :country ORDER BY e.yearValue DESC",
                    CO2Emission.class
            );
            query.setParameter("country", country);
            query.setMaxResults(1);
            List<CO2Emission> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }


    public List<CO2Emission> findAllForCountry(String country) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<CO2Emission> query = em.createQuery(
                    "SELECT e FROM CO2Emission e " +
                            "WHERE e.country = :country ORDER BY e.yearValue DESC",
                    CO2Emission.class
            );
            query.setParameter("country", country);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    public void addEmission(CO2Emission emission) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(emission);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
}
