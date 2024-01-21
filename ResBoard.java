package BTreeSetAndMap;

import java.util.*;

public class ResBoard {
    StudentComaparator sorting = new StudentComaparator();
    TreeMap<String, Float> nameAndScore = new TreeMap<>();
    TreeSet<Stud> allStudents = new TreeSet<>(sorting);

    public void addStudent(String name, Float grade){
        Stud student = new Stud();
        student.name = name;
        student.grade = grade;
        nameAndScore.put(student.name, student.grade);
        allStudents.add(student);

    }
    List<String> top3Stud(int n) throws NullPointerException{
        if (n < 0){
            throw new NegativeArraySizeException();
        }
        if(n > allStudents.size()){
            n = allStudents.size();
        }
        List<Stud> sort = new ArrayList<>(allStudents);
        Collections.sort(sort, new StudentComaparator());

        List<String> topNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            topNames.add(sort.get(i).name);
        }

        return topNames;
    }

    public static void main(String[] args) {
        ResBoard resBoard = new ResBoard();

        resBoard.addStudent("Mila", 9.1f);
        resBoard.addStudent("Jon", 4.3f);
        resBoard.addStudent("Pit", 6.7f);
        resBoard.addStudent("Sam", 7.2f);
        resBoard.addStudent("Don", 5.0f);
        resBoard.addStudent("Yen", 7.2f);
        resBoard.addStudent("Li", 9.1f);
        resBoard.addStudent("Elen", 8.8f);
        resBoard.addStudent("Kate", 8.8f);



        System.out.println("Имeна и оценки \n" + resBoard.nameAndScore);
        System.out.println("Оценки по возрастанию \n" + resBoard.allStudents);
        System.out.println("Лучшие студенты \n" + resBoard.top3Stud(5));
    }
}
class Stud {
    String name;
    Float grade;

    public Stud(String name, Float grade) {
        this.name = name;
        this.grade = grade;
    }


    public Stud() {

    }

    @Override
    public String toString() {
        return "Student -" +
                "name -" + name +
                "- grade = " + grade ;
    }


}
class StudentComaparator implements Comparator<Stud>{

    @Override
    public int compare(Stud st1, Stud st2) {
        int res = st1.grade.compareTo(st2.grade);

        if (res > 0) {
            return -1;
            }
        else if (st1.name.compareTo(st2.name) == 0){
            return 0;
        }
        else {
            return 1;
        }
    }
}
