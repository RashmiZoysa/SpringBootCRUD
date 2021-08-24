package wixis360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wixis360.dao.EmployeeDAO;
import wixis360.model.Employee;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @PostMapping("/save")
    public int saveEmployee(@RequestBody Employee employee) {

        return employeeDAO.saveEmployee(employee);

    }

}
