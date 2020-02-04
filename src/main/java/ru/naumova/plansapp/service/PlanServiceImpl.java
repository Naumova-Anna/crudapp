package ru.naumova.plansapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naumova.plansapp.dao.PlanDAO;
import ru.naumova.plansapp.model.Plan;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private PlanDAO planDAO;

    @Autowired
    public void setPlanDAO(PlanDAO planDAO) {
        this.planDAO = planDAO;
    }

    @Transactional
    @Override
    public List<Plan> allPlans() {
        return planDAO.allPlans();
    }

    @Transactional
    @Override
    public void addPlan(Plan plan) {
        planDAO.addPlan(plan);
    }

    @Transactional
    @Override
    public void editPlan(Plan plan) {
        planDAO.editPlan(plan);
    }

    @Transactional
    @Override
    public void deletePlan(Plan plan) {
        planDAO.deletePlan(plan);
    }

    @Transactional
    @Override
    public Plan getPlanById(int id) {
        return planDAO.getPlanById(id);
    }
}
