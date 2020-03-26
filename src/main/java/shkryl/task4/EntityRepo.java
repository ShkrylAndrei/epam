package shkryl.task4;

import java.util.List;

/**
 * Интерфейс репозитория, содержит методы получения и сохранения одной или нескольких сущностей
 * @param <T> тип сущности
 */
public interface EntityRepo<T> {
        /**
         * Генерирует одну сущнсоть
         * @return возвращает сгенерированную сущность
         */
        T getOneEntity() throws EntityNotFound ;
        /**
         * Генерирует несколько сущнсотей
         * @return возвращает список сгенерированных сущнсстей
         */
        List<T> getAllEntity();
        /**
         * Сохраняет одну сущность
         * @param entity сущность, которая будет сохранена
         */
        void saveOneEntity(T entity);
        /**
         * Сохраняет список сущнсотей
         * @param listEntity список сущностей, которые будут сохранены
         */
        void saveAllEntity(List<T> listEntity);
}
