import com.laozhou.pojo.Answer;
import com.laozhou.pojo.User;
import com.laozhou.service.AnswerService;
import com.laozhou.service.AnswerServiceImpl;
import com.laozhou.service.ProblemService;
import com.laozhou.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MyJunitTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() {
        AnswerService answerServiceImpl = context.getBean("answerServiceImpl", AnswerService.class);
        List<Answer> allAnswerByProblemId = answerServiceImpl.getAllAnswerByProblemId(1);
        for (Answer answer : allAnswerByProblemId) {
            System.out.println(answer);
        }
    }

    @Test
    public void test02() {
        ProblemService problemServiceImpl = context.getBean("problemServiceImpl", ProblemService.class);
        int nums = problemServiceImpl.getProblemNums();
        System.out.println(nums);
    }

    @Test
    public void test03() {
        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
        User laozhou = userServiceImpl.getUserByName("laozhou");
        System.out.println(laozhou);
    }
    @Test
    public void test04(){
        AnswerService answerServiceImpl = context.getBean("answerServiceImpl", AnswerService.class);
        List<Answer> allAnswerByProblemId = answerServiceImpl.getAllAnswerByProblemId(1);
        System.out.println(allAnswerByProblemId);

    }


}
