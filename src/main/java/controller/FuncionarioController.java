//package controller;
//
//import java.awt.Component;
//import java.util.NoSuchElementException;
//import javax.swing.JTextField;
//import model.Funcionario;
//import util.MensagemUtil;
//
//
//public class FuncionarioController {
//    
//    private Funcionario funcionario;
//    private final TelaFuncionario telaFuncionario;
//    private final FuncionarioDAO repository;
//
//    public FuncionarioController(TelaFuncionario telaFuncionario) {
//        this.telaFuncionario = telaFuncionario;
//        repository = new FuncionarioDAO();
//    }
//
//    public boolean incluir() {
//        
//        if(camposEmBranco()){
//            MensagemUtil.addAviso(telaFuncionario, "Preencha todos os campos para cadastrar um funcionario!");
//            return false;
//        }
//        
//        String cpf = telaFuncionario.getTfdCpf();
//        String nome = telaFuncionario.getTfdNome();
//        String identidade = telaFuncionario.getTfdIdentidade();
//        String salario = telaFuncionario.getTfdSalario();
//
//        try {
//            float salarioFloat = Float.parseFloat(salario);
//
//            funcionario = new Funcionario(cpf, nome, salarioFloat, identidade);
//            System.out.println("Incluir - Controller: " + funcionario);
//
//            if (repository.incluir(funcionario)) {
//                MensagemUtil.addInfo(telaFuncionario, "Funcionário cadastrado com sucesso!");
//                return true;
//            } else {
//                MensagemUtil.addAviso(telaFuncionario, "Já existe um funcionário com o CPF informado!");
//            }
//            
//        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//            MensagemUtil.addErro(telaFuncionario, "O campo de salário deve conter apenas números");
//        }
//        return false;
//    }
//
//    public boolean consultar(String cpfBuscado) {
//
//        if("".equals(cpfBuscado) || cpfBuscado == null){
//            MensagemUtil.addAviso(telaFuncionario, "Por favor, informe um CPF para realizar a busca!");
//            return false;
//        }
//
//        try {
//            funcionario = repository.consultar(cpfBuscado);
//
//            telaFuncionario.setTfdCpf(funcionario.getCpf());
//            telaFuncionario.setTfdNome(funcionario.getNome());
//            telaFuncionario.setTfdIdentidade(funcionario.getIdentidade());
//            float salario = funcionario.getSalario();
//            telaFuncionario.setTfdSalario(String.valueOf(salario));
//            
//            System.out.println(funcionario);
//        } catch (NoSuchElementException e) {
//            MensagemUtil.addAviso(telaFuncionario, "Não foi encontrado funcionário com o CPF informado!");
//            return false;
//        }
//        return true;
//    }
//    
//    public boolean alterar(){
//        
//        if(camposEmBranco()){
//            MensagemUtil.addAviso(telaFuncionario, "Preencha todos os campos para alterar um funcionario!");
//            return false;
//        }
//        
//        try {
//            String cpf = telaFuncionario.getTfdCpf();
//            String nome = telaFuncionario.getTfdNome();
//            String identidade = telaFuncionario.getTfdIdentidade();
//            String salario = telaFuncionario.getTfdSalario();
//            
//            try {
//                float salarioFloat = Float.parseFloat(salario);
//                
//                funcionario = new Funcionario(cpf, nome, salarioFloat, identidade);
//                
//                funcionario.setNome(nome);
//                funcionario.setIdentidade(identidade);
//                funcionario.setSalario(salarioFloat);
//                
//                repository.alterar(funcionario);
//                
//                return true;
//                
//            } catch (NumberFormatException e) {
//                System.out.println(e.getMessage());
//                MensagemUtil.addErro(telaFuncionario, "O campo de salário deve conter apenas números");
//            }
//            
//        } catch (NoSuchElementException e){
//            MensagemUtil.addAviso(telaFuncionario, "Não foi encontrado funcionário com o CPF informado!");
//        }
//        return false;
//    }
//    
//    private boolean camposEmBranco(){
//        for (Component c : telaFuncionario.getPanel().getComponents()) {
//            if (c instanceof JTextField) {
//                if (((JTextField) c).getText().isBlank()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}
