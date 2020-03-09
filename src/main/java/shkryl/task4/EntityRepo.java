package shkryl.task4;

import java.util.List;

public interface EntityRepo<T> {

        T getOneEntity() throws EntityNotFound ;
        List<T> getAllEntity();
        void saveOneEntity(T entity);
        void saveAllEntity(List<T> listEntity);
}
