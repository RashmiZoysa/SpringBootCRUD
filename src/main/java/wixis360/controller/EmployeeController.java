package wixis360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wixis360.dto.EmployeeDTO;
import wixis360.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

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

    @GetMapping("/employee/{id}")
    public EmployeeDTO searchEmployee(@PathVariable("id") String id) throws SQLException {

        return employeeService.searchEmployee(id);
    }

    @PutMapping("/employee")
    public int updateEmployee(@RequestBody EmployeeDTO employee){

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public int deleteEmployee(@PathVariable ("id")String id){

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> get(){
        return employeeService.getAllEmployees();
    }


}
