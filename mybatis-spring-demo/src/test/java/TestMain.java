import com.example.config.SpringConifg;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConifg.class);
        UserService userServiceImpl = (UserService) ac.getBean("userServiceImpl");
        User user = userServiceImpl.selectUser(2);
        System.out.println(user);
        User u=new User();
        u.setId(10);
        u.setAge(18);
        u.setName("wxx");
        userServiceImpl.insertUser(u);

    }



}
