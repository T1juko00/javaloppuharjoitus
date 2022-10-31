package com.konsta.student.data;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private String teacher;
    public List<Student> students = new ArrayList<>();//lista tänne, jotta voit käyttää c1 oliolla listan "<Student> students" oliota service puolella.

    public Course (){
        this(" ", " ");
    }

    public Course(String courseName, String teacher) {
        this.courseName = courseName;
        this.teacher=teacher;
    }


    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
