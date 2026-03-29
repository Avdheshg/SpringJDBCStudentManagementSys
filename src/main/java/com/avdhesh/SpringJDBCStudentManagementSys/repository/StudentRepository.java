package com.avdhesh.SpringJDBCStudentManagementSys.repository;

import com.avdhesh.SpringJDBCStudentManagementSys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

//    List<Student> students = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
//        students.add(student);

        String sql = "insert into student(rollno,name,marks) values(?,?,?)";

        int rows = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println("Rows updated: " + rows);

        System.out.println(student + " added successfully");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Student student = new Student(
                        resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("rollno")),
                        Integer.parseInt(resultSet.getString("marks"))
                );

                return student;
            }
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

}
