package dao;

import model.Municipio;

import java.util.ArrayList;
import java.util.List;

public class TesteDao extends GenericDao<Municipio, Integer> {

    private static final List<Municipio> municipios = new ArrayList<>();

    public TesteDao(){
        super(Municipio.class, municipios);
    }
}
