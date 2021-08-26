package wixis360.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wixis360.dao.impl.EmployeeDaoImpl;
import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;
import wixis360.service.EmployeeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDaoImpl dao;

    @Override
    public int saveEmployee(EmployeeDTO dto) {
        dao.saveEmployee(new Employee(dto.getId(),dto.getName(),dto.getContact(),dto.getAddress()));

        return 1;
    }


    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException {

            Employee employee = dao.searchEmployee(id);
            return new EmployeeDTO(employee.getId(),employee.getName(),employee.getContact(),employee.getAddress());

        }


    @Override
    public int updateEmployee(EmployeeDTO dto) {
        dao.updateEmployee(new Employee(dto.getId(),dto.getName(),dto.getContact(),dto.getAddress()));

        return 1;
    }

    @Override
    public int deleteEmployee(String id) {
        return dao.deleteEmployee(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> cList =dao.getAllEmployees();
        List<EmployeeDTO>List =new ArrayList();
        for (Employee employee: cList){
            List.add(new EmployeeDTO(employee.getId(),employee.getName(),employee.getContact(),employee.getAddress()));
        }
        return List;
    }
    }

