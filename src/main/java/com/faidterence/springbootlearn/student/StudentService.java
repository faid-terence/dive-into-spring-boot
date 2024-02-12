package com.faidterence.springbootlearn.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents (){
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw  new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
//        System.out.println(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("student with id" + studentId+ "does not exits");
        }
        studentRepository.deleteById(studentId);

    }


    public void updateStudent(Integer studentId, Student newStudentData) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with ID " + studentId + " does not exist");
        }

        // Fetch the existing student record from the database
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with ID " + studentId + " not found"));

        // Update the existing student record with new data
        existingStudent.setName(newStudentData.getName());
        existingStudent.setEmail(newStudentData.getEmail());
        existingStudent.setDob(newStudentData.getDob());

        studentRepository.save(existingStudent);
    }

}
