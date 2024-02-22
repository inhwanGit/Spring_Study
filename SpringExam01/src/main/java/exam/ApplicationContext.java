package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    Properties properties;
    Map objectMap;
    public ApplicationContext() throws IOException {
        properties = new Properties();
        objectMap = new HashMap<String, Object>();
        properties.load(new FileInputStream("src/main/resources/Beans.properties"));
    }
    public Object getBean(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Object o1 = objectMap.get(id);
        if(o1 == null) {
            String className = properties.getProperty(id);
            // class name에 해당하는 문자열을 가지고 인스턴스를 생성한다.
            // Class.forName(className)은 CLASSPATH부터 className에 해당하는 클래스를 찾은 후
            // 그 클래스 정보를 반환한다.
            Class clazz = Class.forName(className);
//        Method[] methods = clazz.getMethods();
//        for(Method m : methods){
//            System.out.println(m.getName());
//        }
            Object o = clazz.newInstance(); // clazz정보를 이용해 인스턴스를 생성한다.
            objectMap.put(id, o);
            o1 = objectMap.get(id);
        }
        return o1;
    }
}
