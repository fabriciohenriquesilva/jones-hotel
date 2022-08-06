import model.Cliente;
import model.Municipio;
import model.PessoaFisica;

public class LoadData {

    public void init(){

        Cliente fabricio = new PessoaFisica("123456789", "Fabricio");
        Municipio unai = new Municipio("Unaí", "MG", "Brasil");

//        TesteDao dao = new TesteDao();
//        dao.incluir(unai);
//        Optional<Municipio> consultar = dao.consultar(1);
//
//        System.out.println("-----------------");
//        System.out.println(consultar.get());
//
//        consultar.get().setPais("BR");
////        dao.atualizar(unai);
//        System.out.println("-----------------");
//        Optional<Municipio> consultarAposAlteracao = dao.consultar(1);
//        System.out.println(consultarAposAlteracao.get());

    }
}
