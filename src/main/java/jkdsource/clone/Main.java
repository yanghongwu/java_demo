package jkdsource.clone;

/**
 * Created by yanghongwu on 2017/2/21.
 */
public class Main {

    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        Student s1 = new Student();
        s1.setAge(12);
        s1.setName("小明");



        t1.setAge(25);
        t1.setName("杨老师");
        t1.setStudent(s1);


        Teacher t2 = t1.clone();

        System.out.println(t1 == t2);
        System.out.println(s1 == t2.getStudent());

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
