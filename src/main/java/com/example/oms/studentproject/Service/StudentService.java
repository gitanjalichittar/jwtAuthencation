package com.example.oms.studentproject.Service;


import com.example.oms.studentproject.Model.request.StudentRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {


    Object SaveOrUpdate(StudentRequest studentRequest) throws Exception;

    Object getAllRecords();


    Object findById(Long studentId) throws Exception;

    Object deleteById(Long studentId)throws Exception;


    Object statusChange(Long studentId) throws Exception;

    Object searchByName(String name, Pageable pageable);

    Object searchByLocation(Pageable pageable, String location);

    Object searchByFirstNameAndLastName(Pageable pageable, String userName);

    Object getByProjection(Pageable pageable);

    Object sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body) throws Exception;


    Object changePassword(Long studentId, String oldPassword, String newPassword);

    Object fileUpload(MultipartFile userFile) throws IOException;
}
