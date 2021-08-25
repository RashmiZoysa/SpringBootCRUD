package wixis360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wixis360.dao.EmployeeDAO;
import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;
import wixis360.service.EmployeeService;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    EmployeeDAO employeeDAO;

    @PostMapping("/employee")
    public int saveEmployee(@RequestBody EmployeeDTO employee) {

        return employeeService.saveEmployee(employee);

    }


    @PutMapping("/employee")
    public int updateEmployee(@RequestBody EmployeeDTO employee){

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public int deleteEmployee(@PathVariable ("id")String id){

        return employeeService.deleteEmployee(id);
    }


}
