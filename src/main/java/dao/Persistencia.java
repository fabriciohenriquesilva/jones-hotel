package dao;

import java.util.List;
import java.util.Optional;

public interface Persistencia<E, ID> {

    E incluir(E entidade);

    Optional<E> consultar(ID id);

    boolean remover(E entidade);

    List<E> listar();
}
