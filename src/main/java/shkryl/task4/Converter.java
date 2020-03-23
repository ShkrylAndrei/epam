package shkryl.task4;

/**
 * Интерфейс содержащий методы конвертации
 * из сущности в DTO
 * и из DTO в сущность
 * @param <E> - entity тип
 * @param <D> - dto тип
 */
public interface Converter<E, D> {
    /**
     * Конвертирует entity в DTO
     * @param entity сущность, которая будет сконвертирована в DTO
     * @return возвращает DTO сущности entity
     */
    D convetToDTO(E entity);
    /**
     * Конвертируем DTO в entity
     * @param dto объект, который будет сконвертирован в сущность
     * @return возвращает сущнсоть
     */
    E convertToEntity(D dto);
}
