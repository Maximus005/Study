package Spring.Core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "spring-config.xml",
                        "spring-config-2.xml",
                        "alias.xml"
                        );

        Person p = (Person) context.getBean("person");
        Person p2 = context.getBean("person", Person.class);
        Person p3 = (Person) context.getBean("fuck");

        Employee employee = (Employee) context.getBean("opana");

        System.out.println(p.i);

        SetterInjection setterInjection = new SetterInjection();
        System.out.println(setterInjection.person);

    }
}
