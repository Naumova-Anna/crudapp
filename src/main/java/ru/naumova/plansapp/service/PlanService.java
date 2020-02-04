package ru.naumova.plansapp.service;

import ru.naumova.plansapp.model.Plan;
import java.util.List;

public interface PlanService {
    // Получение всех записей
    List<Plan> allPlans();

    // Редактирование выбранной записи
    void editPlan(Plan plan);

    // Удаление выбранной записи
    void deletePlan(Plan plan);

    // Добавление новой записи
    void addPlan(Plan plan);

    // Получение записи по ID
    Plan getPlanById (int id);
}
