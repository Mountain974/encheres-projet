package fr.eni.encheres2.mapping;

public interface Mapper<S, D> {
    S mapToEntity(D dto);

    D mapToDto(S entity);
}