package com.konsta.student.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.konsta.student.data.Course;
import com.konsta.student.data.Student;

@Service
public class StudentService {
    
    public List<Student> students = new ArrayList<>(); //lista opiskelijoista
    public List<Course> courses = new ArrayList<>();   //lista kursseista
    
    //lisätään opiskelijoita
    public StudentService(){
        students.add(new Student("Kalle Kippari", "tvt21spl"));
        students.add(new Student("Vili Vilkas", "tvt21spo"));
        students.add(new Student("Pena Penttilä", "tvt22spl"));
        students.add(new Student("Dille Penttilä", "tvt22spo"));
        
    //Tehdään kursseja joihin lisätään opiskelijat sitten indexien avulla
        Course c1 = new Course("Java-ohjelmointi","Pasi Penttilä");
        c1.students.add(students.get(0));
        c1.students.add(students.get(2));
        Course c2 = new Course("Liikunta","Jouni Leponen");
        c2.students.add(students.get(1));
        c2.students.add(students.get(3));
        Course c3 = new Course("Web-Ohjelmointi","Vesa Erkkilä");
        c3.students.add(students.get(2));
        c3.students.add(students.get(1));
        c3.students.add(students.get(0));
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        //students.remove(3); // voi poistaa opiskelijoita
    }

    public List<Student> getStudentById(long id){//rajapinta joka etsii opiskelijan tiedot sen id:llä.

        List<Student> search = new ArrayList<>();

        for (Student student : students) {
            if(student.getId() == (id)){
                search.add(student);
            }
        }
        return search;
        }

        public void deleteStudentById(long id){//Jos yrittää poistaa oletusalustimessa olevia opiskelijoita, antaa errorin mutta poistaa opiskelijan silti. Kun ajaa ohjelman uudelleen opiskelija tulee takaisin.
                                                //muuten toimii oikein jos thunderclientillä POST:lla lisää uuden opiskelijan ja sitten poistaa.
            for (Student student : students) {
                if(student.getId() == (id)){
                    students.remove(student);
                }
            }
            }

        public void SaveToFile() throws IOException { //Tämän olisi voinut tehdä fileservice luokkaan, mutta en jostain syystä saanut sieltä toimimaan niin laitoin sen tähän student serviceen.
        File f = new File("C:\\Java\\Loppuharjoitus\\StudentApp\\student\\src\\main\\java\\com\\konsta\\student\\service\\copystudents.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f,true);

        for (Student student : students) {
            fw.write(student.getName()+"--");
            fw.write(student.getLuokka()+ System.lineSeparator());
        }
        fw.close();
    }
}



        
    
    

