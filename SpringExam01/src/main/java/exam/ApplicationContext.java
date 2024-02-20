package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationContext {
    Properties properties;
    public ApplicationContext() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/Beans.properties"));
    }
    public Object getBean(String id) throws ClassNotFoundException {
        // class name에 해당하는 문자열을 가지고 인스턴스를 생성한다.
        String className = properties.getProperty(id);

        Class clazz = Class.forName(className);
        System.out.println(clazz.getMethods());
        return null;
    }
}
