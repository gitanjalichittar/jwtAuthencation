package com.example.oms.studentproject;


import com.example.oms.studentproject.Model.Student;
import com.example.oms.studentproject.Model.request.StudentRequest;
import com.example.oms.studentproject.Repository.StudentRepository;
import com.example.oms.studentproject.Serviceimpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class saveOrUpdateTest {

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
    public void testSaveOrUpdate() throws Exception {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setStudentId((long) 34);
        studentRequest.setName("vishwajeet");
        studentRequest.setLastName("kadam");
        studentRequest.setLocation("kadegaon");
        studentRequest.setContact(7865748586.0);
        studentRequest.setEmail("kadam@gmail.com");
        studentRequest.setPassword("kadam#3344");
        studentRequest.setUserName("user_vishwajeet");

        //Mockito.when(studentRepository.existsById((long) 34)).thenReturn(false);
        Mockito.when(studentRepository.existsById((long) 34)).thenReturn(true);
        Mockito.when(studentRepository.findById((long) 34)).thenReturn(Optional.of(student));


     //   Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenAnswer(invocation -> {

       //    return invocation.getArgument(0);
       // });

        // Mock studentRepository.save() behavior
      //     Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenAnswer(new Answer<Student>() {
       //     @Override
         //   public Student answer(InvocationOnMock invocation) throws Throwable {
                // Return the saved student
           //     return invocation.getArgument(0);
            //}
        //});

      //  Object result = studentService.SaveOrUpdate(studentRequest);
        Object result1 = studentService.SaveOrUpdate(studentRequest);

        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any(Student.class));

     //   assertEquals("student saved", result);
        assertEquals("student updated", result1);



    }

}
