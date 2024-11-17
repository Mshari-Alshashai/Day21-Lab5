package com.example.day21lab5.Controller;

import com.example.day21lab5.ApiResponse.ApiResponse;
import com.example.day21lab5.Module.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Student> firstHonors = new ArrayList<>();
    ArrayList<Student> secondHonors = new ArrayList<>();
    ArrayList<Student> thirdHonors = new ArrayList<>();


    @GetMapping("/display")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Successfully added student");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Successfully updated student");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Successfully deleted student");
    }

    @PostMapping("/honor")
    public ApiResponse honor(){
            for (Student student : students) {
                if (student.getGPA()>3.75)firstHonors.add(student);
                else if (student.getGPA()>3.5)secondHonors.add(student);
                else if (student.getGPA()>3)thirdHonors.add(student);
            }
            return new ApiResponse("Successfully categorized students");
    }

    @GetMapping("/good-students")
    public ArrayList<Student> goodStudents() {
        ArrayList<Student> goodStudents = new ArrayList<>();
        double sum = 0;
        for (Student student : students) {
            sum += student.getGPA();
        }
        sum = sum/students.size();
        for (Student student : students) {
            if (student.getGPA()>sum)goodStudents.add(student);
        }
        return goodStudents;
    }
}
