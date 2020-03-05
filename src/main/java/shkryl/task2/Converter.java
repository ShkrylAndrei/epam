package shkryl.task2;

//E - entity
//D - dto
public interface Converter<E, D> {
    D convetToDTO(E entity);
    E convertToEntity(D dto);
}
