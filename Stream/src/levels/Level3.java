package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des enseignants en majuscule séparés par '#' */
        String names = teachers.stream()
                .map(Teacher::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining("#"));
        System.out.println("Noms des enseignants en majuscule séparés par '#': " + names);

        /* TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream()
                .filter(t -> t.getSubject() == Subject.JAVA && t.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Enseignants Java avec un salaire > 80000 : " + teachers1);

        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et, en cas d'égalité, tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>((t1, t2) -> {
                            if (t1.getName().equals(t2.getName())) {
                                return Integer.compare(t1.getSalary(), t2.getSalary());
                            }
                            return t1.getName().compareTo(t2.getName());
                        })
                ));
        System.out.println("Enseignants triés par nom et, en cas d'égalité, par salaire : " + teachers2);

        /* TO DO 4: Retourner une Map regroupant les enseignants par module */
        Map<Subject, List<Teacher>> map = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println("Enseignants regroupés par module : " + map);

        /* TO DO 5: Retourner une Map regroupant les noms des enseignants par salaire */
        Map<Integer, String> map1 = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
        System.out.println("Noms des enseignants regroupés par salaire : " + map1);
    }
}
