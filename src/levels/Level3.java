package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        String names = teachers.stream().
                map(teacher -> teacher.getName().toUpperCase()).
                reduce((name1,name2)-> name1 +" # "+name2).
                orElse("");/* TO DO 1  hint(reduce)*/
        System.out.println(" --TO--DO--1--LV3-- "+names);
        System.out.println("--------");
        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().
                filter(teacher -> teacher.getSubject() == Subject.JAVA).
                filter(teacher -> teacher.getSalary()>8000).
                collect(Collectors.toSet());/* TO DO 3 */
        System.out.println(" --TO--DO--2--LV3-- "+teachers1);
        System.out.println("--------");

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream().
                collect(Collectors.
                        toCollection(() -> new TreeSet<>(Comparator.comparing(Teacher :: getName).
                thenComparing(Teacher::getSalary))));/* TO DO 4 */
        System.out.println(" --TO--DO--3--LV3-- "+teachers2);
        System.out.println("--------");


        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject/*Integer*/, List<Teacher>> map = teachers.stream().
                collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println(" --TO--DO--4--LV3-- "+map);
        System.out.println("-----------------------");

        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */

        Map<Integer, String> map1 = teachers.stream().
                collect(Collectors.toMap(
                        Teacher::getSalary, // key
                        Teacher::getName, // value
        (name1,name2) -> name1 +" - "+name2));/*TO DO 6*/
        System.out.println(" --TO--DO--5--LV3-- "+map1);
        System.out.println("-----------------------------");
        /* TO DO 6: Afficher les nom des enseignants de chaque module */
        map.forEach((Subject,teachers0) -> {
            System.out.println("Module" + Subject);
            teachers0.forEach(teacher -> System.out.println(" , " + teacher.getName()));});
        System.out.println("--------------------------");
    }
}