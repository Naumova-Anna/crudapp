package ru.naumova.plansapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.naumova.plansapp.model.Plan;
import ru.naumova.plansapp.service.PlanService;
import java.util.List;

@Controller
public class PlanController {

    private PlanService planService;

    @Autowired
    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    // Получение всех записей
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ModelAndView allPlans () {
        List<Plan> all = planService.allPlans();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plans");
        modelAndView.addObject("theWholeList", all);
        return modelAndView;
    }

    // Получение страницы редактирования выбранной записи
    @RequestMapping (value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit (@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Plan plan = planService.getPlanById(id);
        modelAndView.setViewName("edit");
        modelAndView.addObject("plan", plan);
        return modelAndView;
    }

    // Редактирование выбранной записи
    @RequestMapping (value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPlan(@ModelAttribute("plan") Plan plan) {
        ModelAndView modelAndView = new ModelAndView();
        planService.editPlan(plan);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    // Получение страницы добавления новой записи
    @RequestMapping (value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    // Добавление новой записи
    @RequestMapping (value = "/add", method = RequestMethod.POST)
    public ModelAndView addPlan(@ModelAttribute("plan") Plan plan) {
        ModelAndView modelAndView = new ModelAndView();
        planService.addPlan(plan);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    // Удаление выбранной записи
    @RequestMapping (value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Plan plan = planService.getPlanById(id);
        planService.deletePlan(plan);
        return modelAndView;
    }

    // Поиск записи по ID
    @RequestMapping (value = "/search", method = RequestMethod.GET)
    public ModelAndView searchId(@RequestParam(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Plan planResult = planService.getPlanById(id);
        modelAndView.setViewName("result");
        modelAndView.addObject("planResult", planResult);
        return modelAndView;
    }
}
