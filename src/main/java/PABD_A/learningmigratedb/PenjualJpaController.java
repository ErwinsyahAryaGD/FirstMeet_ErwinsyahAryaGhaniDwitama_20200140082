/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PABD_A.learningmigratedb;

import PABD_A.learningmigratedb.exceptions.NonexistentEntityException;
import PABD_A.learningmigratedb.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USER
 */
public class PenjualJpaController implements Serializable {

    public PenjualJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Penjual penjual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(penjual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPenjual(penjual.getIdPenjual()) != null) {
                throw new PreexistingEntityException("Penjual " + penjual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Penjual penjual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            penjual = em.merge(penjual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = penjual.getIdPenjual();
                if (findPenjual(id) == null) {
                    throw new NonexistentEntityException("The penjual with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Penjual penjual;
            try {
                penjual = em.getReference(Penjual.class, id);
                penjual.getIdPenjual();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The penjual with id " + id + " no longer exists.", enfe);
            }
            em.remove(penjual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Penjual> findPenjualEntities() {
        return findPenjualEntities(true, -1, -1);
    }

    public List<Penjual> findPenjualEntities(int maxResults, int firstResult) {
        return findPenjualEntities(false, maxResults, firstResult);
    }

    private List<Penjual> findPenjualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Penjual.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Penjual findPenjual(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Penjual.class, id);
        } finally {
            em.close();
        }
    }

    public int getPenjualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Penjual> rt = cq.from(Penjual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
