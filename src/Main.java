import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        printMethodsInfo(Person.class);

        Map<String, String> personAttributes = new HashMap<>();
        personAttributes.put("name", "John");
        personAttributes.put("age", "30");
    }

    public static void printMethodsInfo(Class<?> clazz) {
        System.out.println("methods");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName() + " " + method.getReturnType().getSimpleName());
            System.out.println("params");
            for (Parameter parameter : method.getParameters()) {
                System.out.println("\n" + parameter.getName() + " " + parameter.getType().getSimpleName());
            }
        }

        System.out.println("\n getters and setters");
        for (Method method : methods) {
            if (isGetter(method) || isSetter(method)) {
                System.out.println(method.getName() + " " + method.getReturnType().getSimpleName());
            }
        }
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }
}


