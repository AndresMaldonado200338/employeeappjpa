package edu.uptc.swii.employeeappjpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import edu.uptc.swii.employeeappjpa.domain.Employee;
import edu.uptc.swii.employeeappjpa.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String listarEmpleados(Model model) {
        List<Employee> empleados = employeeService.buscarEmpleados();
        model.addAttribute("empleados", empleados);
        return "listado";
    }

    @RequestMapping("/add")
    public String agregarEmpleado(Model model) {
        model.addAttribute("empleado", new Employee());
        return "formulario";
    }

    @RequestMapping("/save")
    public String guardarEmpleado(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.guardarEmpleado(employee);
        redirectAttributes.addFlashAttribute("mensaje", "Empleado creado exitosamente.");
        return "redirect:/";
    }

    @RequestMapping("/search")
    public String formularioBuscarEmpleado(Model model) {
        model.addAttribute("consultaRealizada", false);
        return "buscar";
    }

    @RequestMapping(value = "/search", params = "id")
    public String buscarEmpleadoPorId(@RequestParam("id") Integer id, Model model) {
        Employee empleado = employeeService.buscarEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        model.addAttribute("consultaRealizada", true);
        return "buscar";
    }

    @RequestMapping("/delete")
    public String formularioEliminarEmpleado() {
        return "eliminar";
    }

    @RequestMapping(value = "/delete", params = "id")
    public String eliminarEmpleado(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes, Model model) {
        boolean eliminado = employeeService.eliminarEmpleado(id);
        if (eliminado) {
            redirectAttributes.addFlashAttribute("mensaje", "Empleado eliminado exitosamente.");
            return "redirect:/";
        } else {
            model.addAttribute("mensajeError", "Empleado no encontrado.");
            return "eliminar";
        }
    }
}
