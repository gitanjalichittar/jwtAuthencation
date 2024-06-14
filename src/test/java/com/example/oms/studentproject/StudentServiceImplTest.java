package com.example.oms.studentproject;

import com.example.oms.studentproject.Model.Student;
import com.example.oms.studentproject.Repository.StudentRepository;
import com.example.oms.studentproject.Service.StudentService;
import com.example.oms.studentproject.Serviceimpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

     @Mock
     private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;



    private Student student;

     @BeforeEach
     void setUp()
     {

        student = new Student();
       student.setStudentId((long) 17);
       student.setName("rishikesh");
       student.setUserName("user_rishikesh");
       student.setLastName("patil");
       student.setEmail("patil@example.com");
       student.setPassword("patil#pwd");
       student.setLocation("tambave");
       student.setContact(8033725465.0);
       student.setIsActive(true);
       student.setIsDeleted(false);



     }



     @Test
     public void testFindById() throws Exception {


         when(studentRepository.existsById((long) 17)).thenReturn(true);

          when(studentRepository.findById((long)17)).thenReturn(Optional.of(student));



          Object result =  studentService.findById((long)17);

          assertNotNull(result);

          assertEquals(student, result);


     }

}
