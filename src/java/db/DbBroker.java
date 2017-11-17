/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Ispit;
import domen.Ispitnirok;
import domen.Mesto;
import domen.Polaganje;
import domen.PolaganjePK;
import domen.Student;
import domen.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Milenkovic
 */
public class DbBroker {

    private static DbBroker instance;

    private DbBroker() {

    }

    public static DbBroker getInstance() {
        if (instance == null) {
            instance = new DbBroker();
        }
        return instance;
    }

    public User prijaviKorisnika(User korisnikZaPrijavu) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        List<User> listaKorisnika = em.createQuery("SELECT u FROM User u WHERE u.username = :user AND u.password = :pass").setParameter("user", korisnikZaPrijavu.getUsername()).setParameter("pass", korisnikZaPrijavu.getPassword()).getResultList();
//        em.getTransaction().commit();
//        em.flush();
        if (listaKorisnika.isEmpty()) {
            throw new Exception("Nepostojeci korisnik");
        } else if (listaKorisnika.size() > 2) {
            throw new Exception("Greska pri logovanju!");
        } else {
            return listaKorisnika.get(0);
        }

    }

    public List<Student> vratiStudente() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        List<Student> listaStudenata = em.createQuery("SELECT s FROM Student s").getResultList();
        // em.getTransaction().commit();
        em.close();
        emf.close();
        return listaStudenata;
    }

    public List<Ispit> vratiIspite() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        List<Ispit> listaIspita = em.createQuery("SELECT i FROM Ispit i").getResultList();
        //em.getTransaction().commit();
        em.close();
        emf.close();
        return listaIspita;
    }

    public List<Polaganje> vratiPolaganja() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        List<Polaganje> listaPolaganja = em.createQuery("SELECT p FROM Polaganje p").getResultList();
        //em.getTransaction().commit();
        em.close();
        emf.close();
        return listaPolaganja;
    }

    public List<Polaganje> vratiNeuspesnaPolaganja() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
//        //em.getTransaction().begin();
//        List<Polaganje> listaPolaganja = em.createQuery("SELECT p FROM Polaganje p WHERE ocena = 5").getResultList();
//        //em.getTransaction().commit();
//        em.close();
//        emf.close();
//        return listaPolaganja;

        Query query = em.createQuery("Select p from Polaganje p where p.ocena=:arg1");
        query.setParameter("arg1", 5);
        List<Polaganje> listaPolaganja = query.getResultList();
        return listaPolaganja;
    }

    public List<Mesto> vratiMesta() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        List<Mesto> listaMesta = em.createQuery("SELECT m FROM Mesto m").getResultList();
        //em.getTransaction().commit();
        em.close();
        emf.close();
        return listaMesta;
    }

    public List<Ispitnirok> vratiRokove() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        List<Ispitnirok> listaRokova = em.createQuery("SELECT r FROM Ispitnirok r").getResultList();
        //em.getTransaction().commit();
        em.close();
        emf.close();
        return listaRokova;
    }

    public Mesto vratiMesto(int ptt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();

        Mesto m = em.find(Mesto.class, (int) ptt);

        em.close();
        emf.close();

        return m;
    }

    public Student vratiStudenta(String brojIndeksa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        Student s = em.find(Student.class, (String) brojIndeksa);
        em.close();
        emf.close();
        return s;

    }

    public Ispit vratiIspit(int sifraIspita) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        Ispit i = em.find(Ispit.class, (int) sifraIspita);
        em.close();
        emf.close();
        return i;
    }

    public Ispitnirok vratiIspitnirok(int sifraIspitnogRoka) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        Ispitnirok i = em.find(Ispitnirok.class, (int) sifraIspitnogRoka);
        em.close();
        emf.close();
        return i;
    }

    public void dodajStudenta(Student s) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void dodajPolaganje(Polaganje p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        Polaganje p1 = new Polaganje(new PolaganjePK(p.getStudent().getBrInd(), p.getIspit().getSifraIspita(), p.getIspitnirok().getSifraIspitnogRoka()));
        p1.setDatum(p.getDatum());
        p1.setOcena(p.getOcena());
        p1.setIspit(p.getIspit());
        p1.setIspitnirok(p.getIspitnirok());
        p1.setStudent(p.getStudent());
        em.persist(p1);
        em.flush();
        System.out.println(p.getIspit() + " " + p.getDatum() + " " + p.getIspitnirok() + " " + p.getOcena() + " " + p.getStudent());
        //em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void dodajPolaganja(List<Polaganje> lista) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            for (Polaganje p : lista) {
//            Polaganje p1 = new Polaganje(new PolaganjePK(p.getStudent().getBrInd(), p.getIspit().getSifraIspita(), p.getIspitnirok().getSifraIspitnogRoka()));
//            p1.setDatum(p.getDatum());
//            p1.setOcena(p.getOcena());
//            p1.setIspit(p.getIspit());
//            p1.setIspitnirok(p.getIspitnirok());
//            p1.setStudent(p.getStudent());
//            em.persist(p1);

                em.persist(p);
                System.out.println(p.getIspit() + " " + p.getDatum() + " " + p.getIspitnirok() + " " + p.getOcena() + " " + p.getStudent());
            }
            tx.commit();
            //em.getTransaction().commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
//        em.flush();
    }

//    public void commit(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        EntityTransaction tx = em.getTransaction();
//        tx.commit();
//    }
//    public void rollback(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        EntityTransaction tx = em.getTransaction();
//        tx.rollback();
//    }
    public void obrisi(Polaganje polaganje) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FakultetAppPU");
        EntityManager em = emf.createEntityManager();
        //System.out.println("asdsaddsa " + polaganje.getPolaganjePK());
        Polaganje p = em.find(Polaganje.class, polaganje.getPolaganjePK());
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
//        em.flush();
        em.close();
        emf.close();
    }
}
