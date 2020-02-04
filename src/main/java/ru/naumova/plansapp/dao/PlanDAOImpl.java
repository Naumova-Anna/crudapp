package ru.naumova.plansapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.naumova.plansapp.model.Plan;
import java.util.List;

@Repository
public class PlanDAOImpl implements PlanDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Plan> allPlans() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Plan").list();
    }

    @Override
    public void editPlan(Plan plan) {
        Session session = sessionFactory.getCurrentSession();
        session.update(plan);
    }

    @Override
    public void deletePlan(Plan plan) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(plan);
    }

    @Override
    public void addPlan(Plan plan) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(plan);
    }

    @Override
    public Plan getPlanById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Plan.class, id);
    }
}
