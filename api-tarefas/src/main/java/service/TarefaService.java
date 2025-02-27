package service;

import java.util.List;

import dao.TarefaDAO;
import model.Tarefa;

public class TarefaService {
    public boolean IncluirTarefa(Tarefa tarefa) {
        TarefaDAO dao = new TarefaDAO();
        return dao.incluir(tarefa); 
    }

    public List<Tarefa> buscarPorDescricao(String valor){
        TarefaDAO dao = new TarefaDAO();
        return dao.buscarPorDescricao(valor);
    }    

    public Tarefa buscarPorId(Integer id) {
        TarefaDAO dao = new TarefaDAO();
        return dao.buscarPorId(id);
    }

    public List<Tarefa> listar(){
        TarefaDAO dao = new TarefaDAO();
        return dao.listar();
    }

    public boolean atualizarTarefa(Tarefa tarefa) {
        TarefaDAO dao = new TarefaDAO();
        return dao.atualizar(tarefa);
    }

    public boolean excluirTarefa(Integer id) {
        TarefaDAO dao = new TarefaDAO();
        return dao.excluir(id); 
    }
}
