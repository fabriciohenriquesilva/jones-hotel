package dao;

import java.util.ArrayList;
import java.util.List;
import model.Municipio;

public class MunicipioDao extends GenericDao<Municipio, Integer> {

    private static final List<Municipio> municipios = new ArrayList<>();

    public MunicipioDao() {
        super(Municipio.class, municipios);
    }
}
