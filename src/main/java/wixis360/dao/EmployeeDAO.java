package wixis360.dao;

import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/
public interface EmployeeDAO {
    int saveEmployee(Employee employee);

    EmployeeDTO searchEmployee(String id);

    void updateEmployee(Employee employee);

    void deleteEmployee(String id);

    ArrayList<EmployeeDTO> getAllEmployees();

}
