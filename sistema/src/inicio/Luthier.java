package inicio;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.OrdemServico;
import model.cliente.Cliente;
import model.instrumento.Instrumento;
import repositorio.RepositorioCliente;
import repositorio.RepositorioInstrumento;
import repositorio.RepositorioOrdemServico;

//Classe para controlar CRUD e gerar notificação
public class Luthier {
    
    RepositorioCliente repositorioCliente;
    RepositorioInstrumento repositorioInstrumento;
    RepositorioOrdemServico repositorioOrdemServico;

    public Luthier() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioInstrumento = new RepositorioInstrumento();
        this.repositorioOrdemServico = new RepositorioOrdemServico();
    }

    public void inserir(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.inserir((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.inserir((Instrumento) objeto);
        } else if(objeto instanceof OrdemServico){
            repositorioOrdemServico.inserir((OrdemServico) objeto);
        }
    }

    public void alterar(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.alterar((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.alterar((Instrumento) objeto);
        } else if(objeto instanceof OrdemServico){
            repositorioOrdemServico.alterar((OrdemServico) objeto);
        }
    }

    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();

        clientes = repositorioCliente.listar();

        for(int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i));
        }

        return clientes;
    }

    public List<Instrumento> listarInstrumentos(){
        List<Instrumento> instrumentos = new ArrayList<>();

        instrumentos = repositorioInstrumento.listar();
    
        for(int i=0; i<instrumentos.size(); i++){
            System.out.println(instrumentos.get(i));
        }

        return instrumentos;
    }

    public List<OrdemServico> listarOrdensServicos(){
        List<OrdemServico> ordensservicos = new ArrayList<>();

        ordensservicos = repositorioOrdemServico.listar();

        for(int i=0; i<ordensservicos.size(); i++){
            System.out.println(ordensservicos.get(i));
        }

        return ordensservicos;
    }

    public void remover(Object objeto){
        if(objeto instanceof Cliente){
            repositorioCliente.remover((Cliente) objeto);
        } else if(objeto instanceof Instrumento){
            repositorioInstrumento.remover((Instrumento) objeto);
        } else if(objeto instanceof OrdemServico){
            repositorioOrdemServico.remover((OrdemServico) objeto);
        }
    }

    public String gerarNotificacao(UUID idOrdemServico) {
        OrdemServico ordemServico = repositorioOrdemServico.buscarPorId(idOrdemServico);
        if (ordemServico == null) {
            return "Ordem de serviço não encontrada.";
        }

        Instrumento instrumento = repositorioInstrumento.buscarPorId(ordemServico.getIdInstrumento());
        if (instrumento == null) {
            return "Instrumento não encontrado para a ordem de serviço.";
        }

        Cliente cliente = repositorioCliente.buscaPorId(ordemServico.getIdCliente());
        if (cliente == null) {
            return "Cliente não encontrado para a ordem de serviço.";
        }

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("O Instrumento ")
                .append(instrumento.getNome()).append(" ")
                .append(instrumento.getModelo()).append(", em nome do cliente ")
                .append(cliente.getNomeCompleto()).append(", está em ")
                .append(ordemServico.getTipoServico())
                .append(ordemServico.getStatusInstrumento() != null ? " para " + ordemServico.getStatusInstrumento() : "")
                .append(ordemServico.getObservacaoStatus() != null ? ", " + ordemServico.getObservacaoStatus() : "").append(", e tem previsão de ser entregue dia ")
                .append(ordemServico.getPrevisaoEntrega() != null ? ordemServico.getPrevisaoEntrega().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() : "data não disponível").append(". Segundo a ordem de serviço número ")
                .append(ordemServico.getCodigo()).append(", ")
                .append(ordemServico.getPecas() != null && !ordemServico.getPecas().isEmpty() ? "está sendo utilizado novo conjunto de peças: " + ordemServico.getPecas() :
                "não necessitou de material/peças").append(".");

        return mensagem.toString();
    }
}
