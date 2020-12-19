import java.util.List;

public class Student {
    //属性：学生身高、体重、姓名、年龄、专业、电话、住址
    //行为：学生的动作
    float height;//体重、身高：可以有小数点，故用浮点型float
    float weight;
    String name;
    byte age;//年龄：整型
    String major;
    String phone;//电话
    String username;//用户名
    String password;//登录密码

    /*
    在学生类中有多个课程
     */
    List<Course> selectedCourses;
}
