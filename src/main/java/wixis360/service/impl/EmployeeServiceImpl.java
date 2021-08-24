package wixis360.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wixis360.dao.EmployeeDAO;
import wixis360.dao.impl.EmployeeDaoImpl;
import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;
import wixis360.service.EmployeeService;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDaoImpl dao;

    @Override
    public void saveEmployee(EmployeeDTO dto) {
        dao.saveEmployee(new Employee(dto.getId(),dto.getName(),dto.getContact(),dto.getAddress()));

    }


    @Override
    public EmployeeDTO searchEmployee(String id) {
        return null;
    }

    @Override
    public void updateEmployee(EmployeeDTO dto) {

    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() {
        return null;
    }
}
