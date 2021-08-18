import CreateObject.ServiceCreateObjects;
import DAO.GetObjects;
import DBO.Students;
import DBO.Tasks;
import DBO.Teachers;
import org.antlr.v4.runtime.misc.Array2DHashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        GetObjects.saveStudents(ServiceCreateObjects.getStudents());
        GetObjects.saveTasks(ServiceCreateObjects.getTasks());
        GetObjects.saveTeachers(ServiceCreateObjects.getTeachers());

    }
}