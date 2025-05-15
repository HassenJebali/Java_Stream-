package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();
        System.out.println("-------TO--DO-1-------LV2-----");

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().
                filter(teacher -> teacher.getName().startsWith("s")).
                count();/*TO DO 1 */
        System.out.println("-------TO--DO-1-------LV2-----" + nbr);
        System.out.println("---------------------------------");

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().
                filter(teacher -> teacher.getSubject() == Subject.FLUTTER).
                mapToInt(Teacher::getSalary).
                sum();
        System.out.println("-------TO--DO-2-------LV2-----"+ sum);
        System.out.println("---------------------------------------------");
        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().
                filter(teacher -> teacher.getName().startsWith("a")).
                mapToInt(Teacher ::getSalary).
                average().orElse(0);
        System.out.println("-------TO--DO-3-------LV2-----"+ average);
        System.out.println("----------------------------------------");
                /* TO DO 3 */;


        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().
                filter(teacher -> teacher.getName().startsWith("f")).
                collect(Collectors.toList());/* TO DO 4 */
        System.out.println("-------------TO--DO--4--- LV2--"+ teachers1);
        System.out.println("--------------------------------------");
        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().
                filter(teacher -> teacher.getName().startsWith("s")).
                toList();/* TO DO 5 */
        System.out.println("-------TO--DO-5-------LV2-----"+ teachers2);
        System.out.println("-----------------------------------");


        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().
                anyMatch(teacher -> teacher.getSalary()>100000);/* TO DO 6 */
        System.out.println("-----------------TO--DO-----5.1-----LV2-------" + test);
        System.out.println("--------------------------------");

        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/

        teachers.stream().filter(teacher -> teacher.getName().startsWith("g")).
        filter(teacher -> teacher.getSubject() == Subject.UNITY).
                findFirst().
                ifPresent(System.out::println);/* TO DO 7 */;
        System.out.println("-----TO--DO--6---LV2---");
        System.out.println("----------------------");

        /*Second way*/
        Teacher G_Unity = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.UNITY).
                filter(teacher -> teacher.getName().startsWith("g")).
                findFirst().
                orElse(null);/* TO DO 7 */;
        System.out.println("----------TO----DO---6.1--------LV2------- "+G_Unity);
        System.out.println("----------------------------------------------");
        System.out.println("---TO--DO--7----LV2-----");
        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream().filter(teacher -> teacher.getName().startsWith("s")).
                skip(1).
                findFirst().
                ifPresent(System.out::println);/* TO DO 8 */;

    }
}
