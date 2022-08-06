package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public abstract class GenericDao<E, ID> implements Persistencia<E, ID> {

    private List<E> entidades;
    private Class<E> classeDaEntidade;

    public GenericDao(Class<E> classe, List<E> entidades){
        this.entidades = entidades;
        this.classeDaEntidade = classe;
    }

    @Override
    public E incluir(E entidade) {
        entidades.add(entidade);
        return entidade;
    }

    @Override
    public Optional<E> consultar(ID id) {
        String nome = classeDaEntidade.getName();

        try {
            Class<?> clazz = Class.forName(nome);
            Method getIdMethod = clazz.getMethod("getId");

            for (E e : entidades) {
                if(getIdMethod.invoke(e).equals(id)){
                    return Optional.ofNullable(e);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean remover(E entidade) {
        return entidades.remove(entidade);
    }

    @Override
    public List<E> listar() {
        return entidades;
    }
}
