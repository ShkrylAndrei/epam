package shkryl.task10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
public @interface MyAnnotation {
    String name();
    String value();
}
