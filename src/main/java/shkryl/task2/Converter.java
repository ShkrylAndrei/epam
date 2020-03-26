package shkryl.task2;

/**
 * Содержит методы конвертации между сущностью и DTO
 *
 * @param <E> - entity тип
 * @param <D> - dto тип
 */
public interface Converter<E, D> {
    /**
     * Конвертирует entity в DTO
     *
     * @param entity сущность, которая будет сконвертирована в DTO
     * @return возвращает DTO сущности entity
     */
    D convertToDTO(E entity);

    /**
     * Конвертируем DTO в entity
     *
     * @param dto объект, который будет сконвертирован в сущность
     * @return возвращает сущнсоть
     */
    E convertToEntity(D dto);
}
