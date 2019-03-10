package pl.sda.readstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fmucko
 */
public class SaveStudent {
   static List<Student> studentList = new ArrayList<>();

    public static void saveStudentsToJson(String pathName){
        studentList.add(new Student("Marek","Marecki",1));
        studentList.add(new Student("Adam","Adamski",2));
        studentList.add(new Student("Antoni","Antonowicz",3));
        studentList.add(new Student("Stefan","Bigos",4));
        studentList.add(new Student("Marek","Kowalski",5));
        ObjectMapper mapper = new ObjectMapper();
        try {
            File studentFile = new File(pathName);
            mapper.writeValue(studentFile, studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        saveStudentsToJson("student.json");
    }


}
