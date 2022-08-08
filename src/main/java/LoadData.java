import controller.MunicipioController;
import model.Cliente;
import model.Municipio;
import model.PessoaFisica;

public class LoadData {

    public void init(){

        Municipio unai = new Municipio("Unaí", "MG", "Brasil");

        MunicipioController controller = new MunicipioController();

        System.out.println("INCLUSÃO");
        controller.incluir(unai);
        Municipio consulta = controller.consultar(1);
        System.out.println(consulta);

        System.out.println("ALTERAÇÃO");
        Municipio altera = controller.atualizar(1);
        altera.setPais("BR");
        System.out.println(altera);

        System.out.println("NOVA CONSULTA");
        Municipio consultaAposEdicao = controller.consultar(1);
        System.out.println(consultaAposEdicao);

        System.out.println("REMOÇÃO");
        controller.remover(1);

        System.out.println("NOVA CONSULTA APÓS REMOÇÃO");
        Municipio consultaAposRemocao = controller.consultar(1);
        System.out.println(consultaAposRemocao);

        System.out.println("Execução normal");


    }
}
