package cn.oushubo.pojo;

public class User {
    private String num;
    private String name;
    private String teacherClass;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    @Override
    public String toString() {
        return "User{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", teacherClass='" + teacherClass + '\'' +
                '}';
    }
}
