package exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext{
    // 1. 싱글턴 패턴 적용 -> 자기 자신을 참조하는 static 필드를 선언한다. 바로 초기화
    private static ApplicationContext instance;

    static {
        try {
            instance = new ApplicationContext();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 3. 1.에서 만든 인스턴스를 반환하는 static메소드를 만든다.
    public static ApplicationContext getInstance(){
        return instance;
    }
    Properties properties;
    Map objectMap;

    // 2. 싱글턴 패턴 적용 -> 생성자를 private으로 바꾼다.
    private ApplicationContext() throws IOException {
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
