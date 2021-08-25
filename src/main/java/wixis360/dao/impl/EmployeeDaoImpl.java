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

import java.sql.ResultSet;
import java.sql.SQLException;
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

        System.out.println("done");

        return namedParameterJdbcTemplate.update(save,mapSqlParameterSource);

    }

    @Override
    public void searchEmployee(String id) {


    }

    @Override
    public int updateEmployee(Employee employee) {
        String update = "UPDATE employee SET name = :name , contact = :contact , address =:address where id = :id";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",employee.getId());
        mapSqlParameterSource.addValue("name",employee.getName());
        mapSqlParameterSource.addValue("contact",employee.getContact());
        mapSqlParameterSource.addValue("address",employee.getAddress());

        return namedParameterJdbcTemplate.update(update,mapSqlParameterSource);
    }

    @Override
    public int deleteEmployee(String id) {
        String delete = "DELETE FROM employee WHERE id=:id ";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id",id);

        return namedParameterJdbcTemplate.update(delete,mapSqlParameterSource);

    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() {
        return null;
    }


}
