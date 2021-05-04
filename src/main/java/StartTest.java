import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StartTest {
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getDeclaredMethods();
        Method beforeMethod = null;
        Method afterMethod = null;
        int beforeCount = 0;
        int afterCount = 0;

        for (Method m : methods) {
            if(m.isAnnotationPresent(BeforeSuite.class)){
                beforeCount++;
                if(beforeCount > 1) throw new RuntimeException("There should be only one BeforeSuite method");
                beforeMethod = m;
            } else if (m.isAnnotationPresent(AfterSuite.class)){
                afterCount++;
                if(afterCount > 1) throw new RuntimeException("There should be only one AfterSuite method");
                afterMethod = m;
            }
        }

        if(beforeCount == 1) beforeMethod.invoke(null);

        for (int i = 10; i > 0; i--) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    if(m.getAnnotation(Test.class).priority() == i){
                        m.invoke(null);
                    }
                }
            }
        }
        if(afterCount == 1) afterMethod.invoke(null);
    }

    public static void main(String[] args)  {
        Class tc = TestClass.class;
        try {
            start(tc);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
