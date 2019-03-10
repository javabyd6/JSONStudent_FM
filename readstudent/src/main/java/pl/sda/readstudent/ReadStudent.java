package pl.sda.readstudent;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.studentmodel.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author fmucko
 */
public class ReadStudent {

    public static List<Student> readStudents(String pathName){
        File studentFile = new File("student.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Student> studentList = new ArrayList<>();
        try {
            Student[] studentArr = mapper.readValue(studentFile, Student[].class);
            studentList = Arrays.asList(studentArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
     List<Student> students = new ArrayList<>();
     students = readStudents("student.json");
        System.out.println(students.toString());

     List<Student> filteredList;
     filteredList = students.stream().filter(student -> student.getName().charAt(0)=='A').collect(Collectors.toList());
        System.out.println(filteredList.toString());
    }

}
