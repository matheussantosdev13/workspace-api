package dao;

import java.util.List;
import java.util.Scanner;

import model.Tarefa;
import service.TarefaService;

public class TesteBanco {

    public static void main(String[] args) {
        TarefaService service = new TarefaService();
        
        List<Tarefa> lista = service.listar();
        
        System.out.println("Lista de tarefas:");
        for (Tarefa t : lista) {
            System.out.println(t);
        }
        
        System.out.println("--------------------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual tarefa você quer consultar? (ID)");
        int criterio = scanner.nextInt();
        
        Tarefa t = service.buscarPorId(criterio);
        if (t != null) {
            System.out.println("Tarefa encontrada: " + t.getDescricao());
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }
        
        System.out.println("--------------------------------------");
        
        scanner.nextLine(); 
        System.out.println("Qual tarefa você quer consultar (descrição)?");
        String criterio2 = scanner.nextLine();
        
        List<Tarefa> lista2 = service.buscarPorDescricao(criterio2);
        
        if (!lista2.isEmpty()) {
            System.out.println("Tarefas encontradas por descrição:");
            for (Tarefa t2 : lista2) {
                System.out.println(t2);
            }
        } else {
            System.out.println("Nenhuma tarefa encontrada com essa descrição.");
        }

        System.out.println("--------------------------------------");
        
        System.out.println("Você quer atualizar uma tarefa? (Digite o ID da tarefa)");
        int idTarefa = scanner.nextInt();
        
        Tarefa tarefaParaAtualizar = service.buscarPorId(idTarefa);
        if (tarefaParaAtualizar != null) {
            System.out.println("Tarefa encontrada: " + tarefaParaAtualizar.getDescricao());
            
            scanner.nextLine(); 
            System.out.println("Digite a nova descrição:");
            String novaDescricao = scanner.nextLine();
            tarefaParaAtualizar.setDescricao(novaDescricao);
            
            System.out.println("Digite o novo prazo:");
            int novoPrazo = scanner.nextInt();
            tarefaParaAtualizar.setPrazo(novoPrazo);
            
            System.out.println("A tarefa foi finalizada? (true/false):");
            boolean novaFinalizacao = scanner.nextBoolean();
            tarefaParaAtualizar.setFinalizada(novaFinalizacao);

            boolean sucesso = service.atualizarTarefa(tarefaParaAtualizar);
            
            if (sucesso) {
                System.out.println("Tarefa atualizada com sucesso!");
            } else {
                System.out.println("Falha ao atualizar a tarefa.");
            }
        } else {
            System.out.println("Tarefa não encontrada com o ID fornecido.");
        }

        System.out.println("--------------------------------------");

        System.out.println("Você quer excluir uma tarefa? (Digite o ID da tarefa)");
        int idExcluir = scanner.nextInt();
        
        boolean sucessoExcluir = service.excluirTarefa(idExcluir);
        if (sucessoExcluir) {
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Falha ao excluir a tarefa ou tarefa não encontrada.");
        }

        scanner.close();
    }
}
