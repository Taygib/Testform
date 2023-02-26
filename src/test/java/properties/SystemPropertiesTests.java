package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty1Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty2Test() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    void simpleProperty3Test() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("Property4")
    void simpleProperty4Test() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("Property5_Test")
    void simpleProperty5Test() {
        System.out.println("Hello, " + System.getProperty("user_Name", "unknown student"));
    }
            /*
        gradle clean Property5Test
            Hello, unknown student
        gradle clean Property5Test -Duser_Name=Alex
            Hello, Alex
        gradle clean Property5Test -Duser_Name=Alex Egorov
            FAILURE: Build failed with an exception.
            Task 'Egorov' not found in root project 'qa-guru-jenkins-16'.
        gradle clean Property5Test "-Duser_Name=Alex Egorov"
        gradle clean Property5Test -Duser_Name="Alex Egorov"
            Hello, Alex Egorov
         */
}
