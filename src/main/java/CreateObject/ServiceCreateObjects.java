package CreateObject;

import DAO.GetObjects;
import DBO.Students;
import DBO.Tasks;
import DBO.Teachers;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class ServiceCreateObjects {

    static Set<String> namesStudents;
    static Set<String> nameTeachers;
    static Set<String> courses;
    static Set<String> reviews;
    static Set<Integer> marks;


    static {
        namesStudents = new HashSet<>(Arrays.asList("Илья", "Андрей", "Василий", "Евгений", "Геннадий", "Максим", "Матвей"));
        nameTeachers = new HashSet<>(Arrays.asList("Илья O.M.", "Андрей П.Н.", "Василий А.Т.", "Евгений И.И.", "Геннадий Г.П.", "Максим Ф.Т.", "Матвей А.К."));
        courses = new HashSet<>(Arrays.asList("Математика", "Программирование", "Физика", "География", "Бухгалтерия", "Биология", "Геометрия"));
        reviews = new HashSet<>(Arrays.asList("Отлично", "Хорошо", "Великолепно", "Не плохо", "Ужасно", "Плохо", "Так себе"));
        marks = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static Set<Students> getStudents() {
        Set<Students> students = new HashSet<>();
        int i = 1;
        for (String name : namesStudents) {
            students.add(Students.builder().id(i).name(name).build());
            i++;
        }
        return students;
    }

    public static Set<Teachers> getTeachers() {
        Set<Teachers> teachers = new HashSet<>();
        List<Tasks> tasks = new ArrayList<>(GetObjects.getTasks());
        int i = 0;
        for (String name : nameTeachers) {
            teachers.add(Teachers.builder().
                    tasks(tasks.get(i)).name(name).build());
            i++;
        }
        return teachers;
    }

    public static Set<Tasks> getTasks() {
        Set<Tasks> tasks = new HashSet<>();
        int i = 0;
        List<Students> students = new ArrayList<>(GetObjects.getStudents());
        for (String name : courses) {
            tasks.add(Tasks.builder().students(students.get(i)).
                    mark(marks.stream().skip((int) (marks.size() * Math.random())).findFirst().orElse(5)).
                    review(reviews.stream().skip((int) (reviews.size() * Math.random())).findFirst().orElse("Хорошо")).
                    cours(courses.stream().skip((int) (courses.size() * Math.random())).findFirst().orElse("Математика")).build());
            i++;
        }
        return tasks;
    }

    public static Set<Integer> getMarksNames() {
        return marks;
    }
}
