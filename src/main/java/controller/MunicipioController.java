package controller;

import dao.MunicipioDao;
import model.Municipio;

import java.util.NoSuchElementException;
import java.util.Optional;

public class MunicipioController implements OperacoesDoController<Municipio, Integer> {

    private final MunicipioDao municipioDao;

    public MunicipioController() {
        this.municipioDao = new MunicipioDao();
    }

    @Override
    public Municipio incluir(Municipio municipio) {
        municipioDao.incluir(municipio);
        return municipio;
    }

    @Override
    public Municipio consultar(Integer id) {
        Optional<Municipio> municipio = municipioDao.consultar(id);
        if(municipio.isEmpty()){

            throw new NoSuchElementException("Não foi possível encontrar o elemento solicitado");
        }
        return municipio.get();
    }

    @Override
    public Municipio atualizar(Integer id) {
        Municipio municipio = consultar(id);
        return municipio;
    }

    @Override
    public boolean remover(Integer id) {
        Optional<Municipio> municipio = municipioDao.consultar(id);
        if(municipio.isEmpty()){
            throw new NoSuchElementException("Não foi possível encontrar o elemento solicitado");
        }
        return municipioDao.remover(municipio.get());
    }
}
