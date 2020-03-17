package com.wh.thread.juc.viii;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

/**
 * eg list有3个User
 * 找出age大于10的,
 * 并将他们的名字改成大写，
 * 最后先输出大的
 * 一个
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("a",9));
        list.add(new User("b",12));
        list.add(new User("c",13));
        list.stream().filter((u1)->{return u1.getAge()>10;})
                .map((u2)->{ return u2.getName().toUpperCase();})
                .sorted((u3,u4)->{
                return u4.compareTo(u3);})
                .limit(1).forEach(System.out::println);
    }

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{

    private String name;
    private int age;
}
