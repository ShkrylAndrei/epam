package shkryl.task10.util;

/**
 * Обертка для параметров из файла
 */
public class AnnotationWrapper {
    private String parameterName;
    private Object parameterValue;

    public AnnotationWrapper(String parameterName, Object parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Object getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Object parameterValue) {
        this.parameterValue = parameterValue;
    }
}
