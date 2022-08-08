package controller;

public interface OperacoesDoController<E, ID> {

    E incluir(E entidade);

    E consultar(ID id);

    E atualizar(ID id);

    boolean remover(ID id);

}
