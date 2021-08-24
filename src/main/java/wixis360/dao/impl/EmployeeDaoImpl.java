package wixis360.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wixis360.dao.EmployeeDAO;
import wixis360.dto.EmployeeDTO;
import wixis360.model.Employee;

import java.util.ArrayList;

/**
 * @author : Rashmi De Zoysa
 * @Date :23-Aug-21
 **/

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveEmployee(Employee employee) {
        String save = "INSERT INTO employee(id,name,contact,address) VALUES (:id,:name,:contact,:address)";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",employee.getId());
        mapSqlParameterSource.addValue("name",employee.getName());
        mapSqlParameterSource.addValue("contact",employee.getContact());
        mapSqlParameterSource.addValue("address",employee.getAddress());

        return namedParameterJdbcTemplate.update(save,mapSqlParameterSource);

    }

    @Override
    public EmployeeDTO searchEmployee(String id) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() {
        return null;
    }


}
