package shkryl.task2;

import java.util.List;

/**
 * Содержит методы получения и сохранения одной или нескольких сущностей
 * @param <T> тип сущности
 */
public interface EntityRepo<T> {

        /**
         * Генерирует одну сущность
         * @return возвращает сгенерированную сущность
         */
        T getOneEntity();

        /**
         * Генерирует несколько сущностей
         * @return возвращает список сгенерированных сущнсстей
         */
        List<T> getAllEntity();

        /**
         * Сохраняет одну сущность
         * @param entity сущность, которая будет сохранена
         */
        void saveOneEntity(T entity);

        /**
         * Сохраняет список сущостей
         * @param listEntity список сущностей, которые будут сохранены
         */
        void saveAllEntity(List<T> listEntity);
}
