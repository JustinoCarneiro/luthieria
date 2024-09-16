package repositorio;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import bd.DatabaseConnection;
import model.cliente.Cliente;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;

public class RepositorioCliente implements IRepositorio<Cliente>{
    List<Cliente> clientes = new ArrayList<>();
    String sql;

    public void inserir(Cliente cliente){
        if(cliente instanceof PessoaFisica){
            PessoaFisica pessoaFisica = (PessoaFisica) cliente;

            sql = "INSERT INTO cliente_pessoa_fisica ("+
                                        "id"+
                                        "nome_completo,"+
                                        "data_nascimento,"+
                                        "telefone_celular,"+
                                        "email,"+
                                        "endereco,"+
                                        "numero_local,"+
                                        "complemento,"+
                                        "bairro,"+
                                        "cidade,"+
                                        "estado,"+
                                        "cpf"+
                                        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setObject(1, pessoaFisica.getId());
                ps.setString(2, pessoaFisica.getNomeCompleto());
                ps.setDate(3, java.sql.Date.valueOf(pessoaFisica.getDataNascimento()));
                ps.setString(4, pessoaFisica.getTelefoneCelular());
                ps.setString(5, pessoaFisica.getEmail());
                ps.setString(6, pessoaFisica.getEndereco());
                ps.setString(7, pessoaFisica.getNumeroLocal());
                ps.setString(8, pessoaFisica.getComplemento());
                ps.setString(9, pessoaFisica.getBairro());
                ps.setString(10, pessoaFisica.getCidade());
                ps.setString(11, pessoaFisica.getEstado());
                ps.setString(12, pessoaFisica.getCpf());

                ps.executeUpdate();
            } catch(SQLException e) {
                System.err.println("Erro ao inserir cliente (pessoa física): " + e.getMessage());
            }
        } else if(cliente instanceof PessoaJuridica){
            PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;

            sql = "INSERT INTO cliente_pessoa_juridica ("+
                                        "id"+
                                        "nome_completo,"+
                                        "data_nascimento,"+
                                        "telefone_celular,"+
                                        "email,"+
                                        "endereco,"+
                                        "numero_local,"+
                                        "complemento,"+
                                        "bairro,"+
                                        "cidade,"+
                                        "estado,"+
                                        "razao_social,"+
                                        "inscricao_estadual,"+
                                        "cnpj,"+
                                        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                                        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setObject(1, pessoaJuridica.getId());
                ps.setString(2, pessoaJuridica.getNomeCompleto());
                ps.setDate(3, java.sql.Date.valueOf(pessoaJuridica.getDataNascimento()));
                ps.setString(4, pessoaJuridica.getTelefoneCelular());
                ps.setString(5, pessoaJuridica.getEmail());
                ps.setString(6, pessoaJuridica.getEndereco());
                ps.setString(7, pessoaJuridica.getNumeroLocal());
                ps.setString(8, pessoaJuridica.getComplemento());
                ps.setString(9, pessoaJuridica.getBairro());
                ps.setString(10, pessoaJuridica.getCidade());
                ps.setString(11, pessoaJuridica.getEstado());
                ps.setString(12, pessoaJuridica.getRazaoSocial());
                ps.setString(13, pessoaJuridica.getInscricaoEstadual());
                ps.setString(14, pessoaJuridica.getCnpj());

                ps.executeUpdate();
            } catch(SQLException e) {
                System.err.println("Erro ao inserir cliente (pessoa jurídica): " + e.getMessage());
            }
        }
    };

    public void remover(Cliente cliente){
        clientes.remove(cliente);
    };

    public void alterar(UUID id, Cliente clienteAlterado){
        for(int i = 0; i < clientes.size(); i++){
            Cliente clienteExistente = clientes.get(i);

            if(clienteExistente.getId().equals(id)){
                clientes.set(i, clienteAlterado);
            }
        }
    };

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
    
        String sqlPessoaFisica = "SELECT * FROM cliente_pessoa_fisica";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmtFisica = connection.prepareStatement(sqlPessoaFisica);
            ResultSet resultSetFisica = pstmtFisica.executeQuery()) {
    
            while (resultSetFisica.next()) {
                UUID id = (UUID) resultSetFisica.getObject("id");
                String nomeCompleto = resultSetFisica.getString("nome_completo");
                LocalDate dataNascimento = resultSetFisica.getDate("data_nascimento").toLocalDate();
                String telefoneCelular = resultSetFisica.getString("telefone_celular");
                String email = resultSetFisica.getString("email");
                String endereco = resultSetFisica.getString("endereco");
                String numeroLocal = resultSetFisica.getString("numero_local");
                String complemento = resultSetFisica.getString("complemento");
                String bairro = resultSetFisica.getString("bairro");
                String cidade = resultSetFisica.getString("cidade");
                String estado = resultSetFisica.getString("estado");
                String cpf = resultSetFisica.getString("cpf");
    
                PessoaFisica pessoaFisica = new PessoaFisica(
                    id, nomeCompleto, dataNascimento, telefoneCelular, email,
                    endereco, numeroLocal, complemento, bairro, cidade, estado, cpf
                );
    
                clientes.add(pessoaFisica);
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes (Pessoa Física): " + e.getMessage());
        }
    
        String sqlPessoaJuridica = "SELECT * FROM cliente_pessoa_juridica";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmtJuridica = connection.prepareStatement(sqlPessoaJuridica);
            ResultSet resultSetJuridica = pstmtJuridica.executeQuery()) {
    
            while (resultSetJuridica.next()) {
                UUID id = (UUID) resultSetJuridica.getObject("id");
                String nomeCompleto = resultSetJuridica.getString("nome_completo");
                LocalDate dataNascimento = resultSetJuridica.getDate("data_nascimento").toLocalDate();
                String telefoneCelular = resultSetJuridica.getString("telefone_celular");
                String email = resultSetJuridica.getString("email");
                String endereco = resultSetJuridica.getString("endereco");
                String numeroLocal = resultSetJuridica.getString("numero_local");
                String complemento = resultSetJuridica.getString("complemento");
                String bairro = resultSetJuridica.getString("bairro");
                String cidade = resultSetJuridica.getString("cidade");
                String estado = resultSetJuridica.getString("estado");
                String razaoSocial = resultSetJuridica.getString("razao_social");
                String inscricaoEstadual = resultSetJuridica.getString("inscricao_estadual");
                String cnpj = resultSetJuridica.getString("cnpj");
    
                PessoaJuridica pessoaJuridica = new PessoaJuridica(
                    id, nomeCompleto, dataNascimento, telefoneCelular, email, endereco,
                    numeroLocal, complemento, bairro, cidade, estado, razaoSocial,
                    inscricaoEstadual, cnpj
                );
    
                clientes.add(pessoaJuridica);
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes (Pessoa Jurídica): " + e.getMessage());
        }
    
        return clientes;
    }
    
}
