package jkdsource.clone;

/**
 * Created by yanghongwu on 2017/2/21.
 */
public class Student implements Cloneable {
    private String name;

    private int age;

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

    @Override
    protected Student clone() {
        try {
            return (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
