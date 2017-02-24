package jkdsource.clone;

/**
 * Created by yanghongwu on 2017/2/21.
 */
public class Teacher implements Cloneable{
    private Student student;

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected Teacher clone() {
        try {
            Teacher t3 = (Teacher)super.clone();
            t3.setStudent(t3.getStudent().clone());
            return t3;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}
