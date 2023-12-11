package levels;

import models.Teacher;
import utils.Data;
import models.Subject;
import java.util.Optional;



import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec 's' */
        long countS = teachers.stream().filter(t -> t.getName().startsWith("s")).count();
        System.out.println("Nombre d'enseignants dont le nom commence par 's' : " + countS);

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter */
        long sumFlutterSalaries = teachers.stream()
                .filter(t -> t.getSubject() == Subject.FLUTTER)
                .mapToLong(Teacher::getSalary)
                .sum();
        System.out.println("Somme des salaires des enseignants Flutter : " + sumFlutterSalaries);

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec 'a' */
        OptionalDouble averageASalaries = teachers.stream()
                .filter(t -> t.getName().startsWith("a"))
                .mapToDouble(Teacher::getSalary)
                .average();
        System.out.println("Moyenne des salaires des enseignants dont le nom commence par 'a' : " +
                (averageASalaries.isPresent() ? averageASalaries.getAsDouble() : "N/A"));

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par 'f' */
        List<Teacher> teachersStartingWithF = teachers.stream()
                .filter(t -> t.getName().startsWith("f"))
                .collect(Collectors.toList());
        System.out.println("Enseignants dont le nom commence par 'f' : " + teachersStartingWithF);

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par 's' */
        List<Teacher> teachersStartingWithS = teachers.stream()
                .filter(t -> t.getName().startsWith("s"))
                .collect(Collectors.toList());
        System.out.println("Enseignants dont le nom commence par 's' : " + teachersStartingWithS);

        /* TO DO 6: Retourner true si il y a au moins un enseignant dont le salaire > 100000, false sinon */
        boolean test = teachers.stream().anyMatch(t -> t.getSalary() > 100000);
        System.out.println("Au moins un enseignant a un salaire > 100000 : " + test);

        /* TO DO 7: Afficher le premier enseignant Unity dont le nom commence avec 'g' avec 2 manières différentes */
        Optional<Teacher> firstTeacherG = teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .findFirst();

        System.out.println("Premier enseignant Unity dont le nom commence par 'g' (Méthode 1) : " +
                (firstTeacherG.isPresent() ? firstTeacherG.get() : "Non trouvé"));

        Optional<Teacher> firstTeacherGAlt = teachers.stream()
                .filter(t -> t.getSubject() == Subject.UNITY && t.getName().startsWith("g"))
                .limit(1)
                .findFirst();

        System.out.println("Premier enseignant Unity dont le nom commence par 'g' (Méthode 2) : " +
                (firstTeacherGAlt.isPresent() ? firstTeacherGAlt.get() : "Non trouvé"));
    }
}
