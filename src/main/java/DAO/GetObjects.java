package DAO;

import DBO.Students;
import DBO.Tasks;
import DBO.Teachers;
import HibernateUtil.HibernateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetObjects {

    private static EntityManager entityManager = HibernateEntityManager.getEntityManager();

    public static Set<Teachers> getTeachers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teachers> personCriteria = cb.createQuery(Teachers.class);
        Root<Teachers> personRoot = personCriteria.from(Teachers.class);
        personCriteria.select(personRoot);
        return new HashSet<>(entityManager.createQuery(personCriteria).getResultList());
    }


    public static Set<Tasks> getTasks() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tasks> personCriteria = cb.createQuery(Tasks.class);
        Root<Tasks> personRoot = personCriteria.from(Tasks.class);
        personCriteria.select(personRoot);
        return new HashSet<>(entityManager.createQuery(personCriteria).getResultList());
    }

    public static Set<Students> getStudents() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Students> personCriteria = cb.createQuery(Students.class);
        Root<Students> personRoot = personCriteria.from(Students.class);
        personCriteria.select(personRoot);
        return new HashSet<>(entityManager.createQuery(personCriteria).getResultList());
    }

    public static void saveTeachers(Set<Teachers> teachers) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Teachers teacher : teachers) {
            manager.getTransaction().begin();
            manager.persist(teacher);
            manager.getTransaction().commit();
        }
    }

    public static void saveTasks(Set<Tasks> tasks) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Tasks task : tasks) {
            manager.getTransaction().begin();
            manager.persist(task);
            manager.getTransaction().commit();
        }
    }

    public static void saveStudents(Set<Students> students) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Students student : students) {
            manager.getTransaction().begin();
            manager.persist(student);
            manager.getTransaction().commit();
        }
    }

    public static void updateTasks(Set<Tasks> tasks)  {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Tasks task : tasks) {
            manager.merge(task);
        }
    }

    public static void updateTeachers(Set<Teachers> teachers) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Teachers teacher : teachers) {
            System.out.println(teacher);
            manager.merge(teacher);
        }
    }

    public static void updateStudents(Set<Students> students) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        for (Students student : students) {
            manager.merge(student);
        }
    }
}