package shkryl.task2;

import java.util.List;

public interface WorkWithDB<T> {

        T getOneEntity();
        List<T> getAllEntity();
        void saveOneEntity(T entity);
        void saveAllEntity(List<T> entity);
}
