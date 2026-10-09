package com.factorymanager;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFabrica {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Fabrica> cadastroFabricas = new ArrayList<>();

    public void iniciarMenu(){
    int opcao = -1;
    Util validar = new Util();
    System.out.println("Bem-vindo a tele de controle de fabricas:");

    while (opcao !=0){
        System.out.println("Escolha a opção que deseja acessar:");
        System.out.println("1- Cadastrar nova Fabrica:");
        System.out.println("2- Consultar fabricas cadastrados:");
        System.out.println("3- Alterar cadastrdo da fabrica: ");
        System.out.println("4- Remover cadastrdo da fabrica: ");
        System.out.println("0- Sair");
        opcao = validar.validador(scanner);

        switch (opcao){
            case 1:
                this.cadastrar();
                break;
            case 2:
               this.listar();
                break;
            case 3:
                this.alterar();
                break;
            case 4:
                excluirFabrica();
                break;
            case 0:
                return;

        }
    }

    }


    public void cadastrar(){

        System.out.println("Digite o id da nova fabrica: ");

        Util validador = new Util();
        int id = validador.validador(this.scanner);

        while (id<= 0){
            System.out.println("id tem que ser um numero maior que zero, digite novamente");
            id = validador.validador(scanner);

        }
        for (Fabrica f : this.cadastroFabricas){
            if (f.getIdFabrica() == id){
                System.out.println("id já cadastrado");
                return;
            }

        }
        System.out.println("Digite o tipo de fabrica a ser cadastrada: ");
        String tipoFabrica = scanner.nextLine();
        while (tipoFabrica.trim().isEmpty()){
            System.out.println("Tipo da fabrica não pode ficar em branco, digite novamente por favor:");
            tipoFabrica = scanner.nextLine();
        }
         System.out.println("Digite o nome da fabrica");
        String nomeFabrica = scanner.nextLine();
        while (nomeFabrica.trim().isEmpty()){
            System.out.println("Nome da fabrica é obrigatorio, gentileza digitar novamente:");
            nomeFabrica =   scanner.nextLine();
        }
        System.out.println("Deseja confirmar o cadastro da fabrica atual?");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("Sim")){
            Fabrica novaFabrica = new Fabrica(id,tipoFabrica,nomeFabrica);
            this.cadastroFabricas.add(novaFabrica);
            System.out.println("Cadastro efetuado com sucesso: ");

        }else {
            System.out.println("Cadastro cancelado:");
        }
    }

    public void listar(){
    if (this.cadastroFabricas.isEmpty()){
        System.out.println("Nenhuma fabrica cadastrada:");
        return;
    }else {
        System.out.println("Segue lista de fabricas cadastradas:");
    for (Fabrica f : cadastroFabricas){
        System.out.println("id fabrica: " + f.getIdFabrica() + " Tipo de fabrica: " + f.getTipoFabrica() + " Nome da fabrica: " + f.getNomeFabrica());
    }

    }
    }

    public void alterar(){
        Util validador = new Util();
        Fabrica fabricaAlterar = null;
        if (this.cadastroFabricas.isEmpty()){
            System.out.println("Não existem fabricas cadastradas no momento:");
            return;
        }else {
            System.out.println("Segue lista de fabricas cadastras no sistema");
            for (Fabrica f : cadastroFabricas){
                System.out.println("id: " + f.getIdFabrica() + "| Tipo: " + f.getTipoFabrica() + " | Nome: " + f.getNomeFabrica());

            }
        }
        System.out.println("Escolha o id da fabrica que você deseja alterar: ");
        int id = validador.validador(this.scanner);
        for (Fabrica f: this.cadastroFabricas){
            if (id == f.getIdFabrica()){
            fabricaAlterar = f;
            break;
            }
        }
        if (fabricaAlterar == null){
            System.out.println("Id da fabrica não existe");
        }else {
            int opcao = -1;
            System.out.println("Escolha a opção que deseja alterar");
            System.out.println("1-Tipo de fabrica:");
            System.out.println("2-Nome da fabrica");
            System.out.println("0- Voltar");
            opcao = validador.validador(scanner);
            switch (opcao){
                case 1:
                    System.out.println("Digite o novo tipo de fabrica:");
                    String novoTipo = scanner.nextLine();
                    while (novoTipo.trim().isEmpty()){
                        System.out.println("Campo obrigatorio, digite novamente: ");
                        novoTipo = scanner.nextLine();
                    }
                  fabricaAlterar.setTipoFabrica(novoTipo);
                    System.out.println("Dado alterado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o novo nome da fabrica:");
                    String novoNome = scanner.nextLine();
                    while (novoNome.trim().isEmpty()){
                        System.out.println("Novo nome obrigatorio, digite novamente:");
                        novoNome =  scanner.nextLine();
                    }
                    fabricaAlterar.setNomeFabrica(novoNome);
                    System.out.println("Dado alterado com sucesso!");
                    break;
                case 0:
                    return;
            }
        }
    }
    public void excluirFabrica() {
        Util validador = new Util();
        Fabrica fabricaExcluir = null;
        if (cadastroFabricas.isEmpty()) {
            System.out.println("Não existem fabricas cadastradas no sistema no momento");
            return;
        } else {
            System.out.println("Veja a lista de fabricas cadastradas até o momento:");
            for (Fabrica f : cadastroFabricas) {
                System.out.println("id: | " + f.getIdFabrica() + " | tipo de fabrica: | " + f.getTipoFabrica() + " |Nome da fabrica: " + f.getNomeFabrica());

            }
        }
        System.out.println(" Digite o id da fabrica que você deseja excluir: ");
        int idExcluir = validador.validador(scanner);
        for (Fabrica f : cadastroFabricas) {
            if (idExcluir == f.getIdFabrica()) {
                fabricaExcluir = f;
                break;

            }
        }
        if (fabricaExcluir == null) {
            System.out.println("id não existente no sistema");
            return;
        }else {
            System.out.println("Tem certeza que deseja excluir a fabrica?");
            String confirmar = scanner.nextLine();
            if (confirmar.equalsIgnoreCase("Sim")) {
                cadastroFabricas.remove(fabricaExcluir);
                System.out.println("Fabrica exluida do sistema!");
            } else {
                System.out.println("Operação cancelada.");
                return;
            }
        }

    }
}
