package wixis360.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import wixis360.dto.EmployeeDTO;


import wixis360.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@Controller
//@RestController
@RequestMapping("/api")
//@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employee")
    @ResponseBody
    public ModelAndView userView(){
        ModelAndView modelAndView=new ModelAndView("emp/employeeForm");
        return modelAndView;

    }


    @PostMapping("/save")
    @ResponseBody
    public int saveEmployee(@RequestBody EmployeeDTO employee) {

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/search/{id}")
    @ResponseBody
    public EmployeeDTO searchEmployee(@PathVariable("id") String id) throws SQLException {

        return employeeService.searchEmployee(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public int updateEmployee(@RequestBody EmployeeDTO employee){

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public int deleteEmployee(@PathVariable ("id")String id){

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<EmployeeDTO> get(){
        return employeeService.getAllEmployees();
    }


}
