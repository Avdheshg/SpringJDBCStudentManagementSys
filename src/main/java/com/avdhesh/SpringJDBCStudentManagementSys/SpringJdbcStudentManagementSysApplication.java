package com.avdhesh.SpringJDBCStudentManagementSys;

import com.avdhesh.SpringJDBCStudentManagementSys.model.Student;
import com.avdhesh.SpringJDBCStudentManagementSys.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcStudentManagementSysApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcStudentManagementSysApplication.class, args);

        Student avdhesh = context.getBean(Student.class);
        avdhesh.setName("Avdhesh");
        avdhesh.setRollNo(1);
        avdhesh.setMarks(40);

        Student ram = context.getBean(Student.class);
        ram.setName("Ram");
        ram.setRollNo(12);
        ram.setMarks(70);

        Student dell = context.getBean(Student.class);
        dell.setName("Dell");
        dell.setRollNo(10);
        dell.setMarks(80);

        StudentService studentService = context.getBean(StudentService.class);
//        studentService.save(avdhesh);
//        studentService.save(ram);
        studentService.save(dell);

        System.out.println("** All Students **\n" + studentService.findAllStudents());
	}

}
