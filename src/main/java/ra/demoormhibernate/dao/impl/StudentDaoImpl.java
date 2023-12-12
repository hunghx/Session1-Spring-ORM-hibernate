package ra.demoormhibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.demoormhibernate.dao.IStudentDao;
import ra.demoormhibernate.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class StudentDaoImpl implements IStudentDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select S from Student S",Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = entityManager.createQuery("select S from Student S where S.id = :id",Student.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Student student) {
        // session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(student);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        // session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(findById(id));
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
