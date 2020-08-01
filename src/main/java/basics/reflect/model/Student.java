package basics.reflect.model;

import basics.reflect.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//需要父类有默认构造函数，会进行调用
@NoArgsConstructor
public class Student extends Person {
    private String grade;
    private String classes;
    private String email;
    private String address;
}
