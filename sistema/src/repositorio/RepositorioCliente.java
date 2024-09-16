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
                                        "id,"+
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
                                        "id,"+
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
        } else {
            System.err.println("Tipo de cliente não reconhecido.");
            return;
        }
    };

    public void remover(Cliente cliente){

        if(cliente instanceof PessoaFisica){
            sql = "DELETE FROM cliente_pessoa_fisica WHERE id = ?";
        } else if(cliente instanceof PessoaJuridica){
            sql = "DELETE FROM cliente_pessoa_juridica WHERE id = ?";
        } else {
            System.err.println("Tipo de cliente não reconhecido.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, cliente.getId());
            ps.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar cliente: " + e.getMessage());
        }
    };

    public void alterar(Cliente clienteAlterado) {
        String sqlUpdate;
    
        if (clienteAlterado instanceof PessoaFisica) {
            sql = "SELECT * FROM cliente_pessoa_fisica WHERE id = ?";
            sqlUpdate = "UPDATE cliente_pessoa_fisica SET nome_completo = ?, data_nascimento = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cpf = ? WHERE id = ?";
        } else if (clienteAlterado instanceof PessoaJuridica) {
            sql = "SELECT * FROM cliente_pessoa_juridica WHERE id = ?";
            sqlUpdate = "UPDATE cliente_pessoa_juridica SET nome_completo = ?, data_nascimento = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, razao_social = ?, inscricao_estadual = ?, cnpj = ? WHERE id = ?";
        } else {
            System.err.println("Tipo de cliente não reconhecido.");
            return;
        }
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psSelect = connection.prepareStatement(sql)) {
    
            psSelect.setObject(1, clienteAlterado.getId());
            ResultSet resultSet = psSelect.executeQuery();
    
            if (resultSet.next()) {
                if (clienteAlterado instanceof PessoaFisica) {
                    PessoaFisica pessoaFisicaAlterada = (PessoaFisica) clienteAlterado;
    
                    String nomeAtual = resultSet.getString("nome_completo");
                    LocalDate dataNascimentoAtual = resultSet.getDate("data_nascimento").toLocalDate();
                    String telefoneAtual = resultSet.getString("telefone_celular");
                    String emailAtual = resultSet.getString("email");
                    String enderecoAtual = resultSet.getString("endereco");
                    String numeroLocalAtual = resultSet.getString("numero_local");
                    String complementoAtual = resultSet.getString("complemento");
                    String bairroAtual = resultSet.getString("bairro");
                    String cidadeAtual = resultSet.getString("cidade");
                    String estadoAtual = resultSet.getString("estado");
                    String cpfAtual = resultSet.getString("cpf");
    
                    String nomeAlterado = pessoaFisicaAlterada.getNomeCompleto() != null && !pessoaFisicaAlterada.getNomeCompleto().equals(nomeAtual) ? pessoaFisicaAlterada.getNomeCompleto() : nomeAtual;
                    LocalDate dataNascimentoAlterada = pessoaFisicaAlterada.getDataNascimento() != null && !pessoaFisicaAlterada.getDataNascimento().equals(dataNascimentoAtual) ? pessoaFisicaAlterada.getDataNascimento() : dataNascimentoAtual;
                    String telefoneAlterado = pessoaFisicaAlterada.getTelefoneCelular() != null && !pessoaFisicaAlterada.getTelefoneCelular().equals(telefoneAtual) ? pessoaFisicaAlterada.getTelefoneCelular() : telefoneAtual;
                    String emailAlterado = pessoaFisicaAlterada.getEmail() != null && !pessoaFisicaAlterada.getEmail().equals(emailAtual) ? pessoaFisicaAlterada.getEmail() : emailAtual;
                    String enderecoAlterado = pessoaFisicaAlterada.getEndereco() != null && !pessoaFisicaAlterada.getEndereco().equals(enderecoAtual) ? pessoaFisicaAlterada.getEndereco() : enderecoAtual;
                    String numeroLocalAlterado = pessoaFisicaAlterada.getNumeroLocal() != null && !pessoaFisicaAlterada.getNumeroLocal().equals(numeroLocalAtual) ? pessoaFisicaAlterada.getNumeroLocal() : numeroLocalAtual;
                    String complementoAlterado = pessoaFisicaAlterada.getComplemento() != null && !pessoaFisicaAlterada.getComplemento().equals(complementoAtual) ? pessoaFisicaAlterada.getComplemento() : complementoAtual;
                    String bairroAlterado = pessoaFisicaAlterada.getBairro() != null && !pessoaFisicaAlterada.getBairro().equals(bairroAtual) ? pessoaFisicaAlterada.getBairro() : bairroAtual;
                    String cidadeAlterada = pessoaFisicaAlterada.getCidade() != null && !pessoaFisicaAlterada.getCidade().equals(cidadeAtual) ? pessoaFisicaAlterada.getCidade() : cidadeAtual;
                    String estadoAlterado = pessoaFisicaAlterada.getEstado() != null && !pessoaFisicaAlterada.getEstado().equals(estadoAtual) ? pessoaFisicaAlterada.getEstado() : estadoAtual;
                    String cpfAlterado = pessoaFisicaAlterada.getCpf() != null && !pessoaFisicaAlterada.getCpf().equals(cpfAtual) ? pessoaFisicaAlterada.getCpf() : cpfAtual;
    
                    try (PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
                        psUpdate.setString(1, nomeAlterado);
                        psUpdate.setDate(2, java.sql.Date.valueOf(dataNascimentoAlterada));
                        psUpdate.setString(3, telefoneAlterado);
                        psUpdate.setString(4, emailAlterado);
                        psUpdate.setString(5, enderecoAlterado);
                        psUpdate.setString(6, numeroLocalAlterado);
                        psUpdate.setString(7, complementoAlterado);
                        psUpdate.setString(8, bairroAlterado);
                        psUpdate.setString(9, cidadeAlterada);
                        psUpdate.setString(10, estadoAlterado);
                        psUpdate.setString(11, cpfAlterado);
                        psUpdate.setObject(12, pessoaFisicaAlterada.getId());
    
                        psUpdate.executeUpdate();
                        System.out.println("Cliente (Pessoa Física) atualizado com sucesso!");
                    }
                } else if (clienteAlterado instanceof PessoaJuridica) {
                    PessoaJuridica pessoaJuridicaAlterada = (PessoaJuridica) clienteAlterado;
    
                    String nomeAtual = resultSet.getString("nome_completo");
                    LocalDate dataNascimentoAtual = resultSet.getDate("data_nascimento").toLocalDate();
                    String telefoneAtual = resultSet.getString("telefone_celular");
                    String emailAtual = resultSet.getString("email");
                    String enderecoAtual = resultSet.getString("endereco");
                    String numeroLocalAtual = resultSet.getString("numero_local");
                    String complementoAtual = resultSet.getString("complemento");
                    String bairroAtual = resultSet.getString("bairro");
                    String cidadeAtual = resultSet.getString("cidade");
                    String estadoAtual = resultSet.getString("estado");
                    String razaoSocialAtual = resultSet.getString("razao_social");
                    String inscricaoEstadualAtual = resultSet.getString("inscricao_estadual");
                    String cnpjAtual = resultSet.getString("cnpj");
    
                    String nomeAlterado = pessoaJuridicaAlterada.getNomeCompleto() != null && !pessoaJuridicaAlterada.getNomeCompleto().equals(nomeAtual) ? pessoaJuridicaAlterada.getNomeCompleto() : nomeAtual;
                    LocalDate dataNascimentoAlterada = pessoaJuridicaAlterada.getDataNascimento() != null && !pessoaJuridicaAlterada.getDataNascimento().equals(dataNascimentoAtual) ? pessoaJuridicaAlterada.getDataNascimento() : dataNascimentoAtual;
                    String telefoneAlterado = pessoaJuridicaAlterada.getTelefoneCelular() != null && !pessoaJuridicaAlterada.getTelefoneCelular().equals(telefoneAtual) ? pessoaJuridicaAlterada.getTelefoneCelular() : telefoneAtual;
                    String emailAlterado = pessoaJuridicaAlterada.getEmail() != null && !pessoaJuridicaAlterada.getEmail().equals(emailAtual) ? pessoaJuridicaAlterada.getEmail() : emailAtual;
                    String enderecoAlterado = pessoaJuridicaAlterada.getEndereco() != null && !pessoaJuridicaAlterada.getEndereco().equals(enderecoAtual) ? pessoaJuridicaAlterada.getEndereco() : enderecoAtual;
                    String numeroLocalAlterado = pessoaJuridicaAlterada.getNumeroLocal() != null && !pessoaJuridicaAlterada.getNumeroLocal().equals(numeroLocalAtual) ? pessoaJuridicaAlterada.getNumeroLocal() : numeroLocalAtual;
                    String complementoAlterado = pessoaJuridicaAlterada.getComplemento() != null && !pessoaJuridicaAlterada.getComplemento().equals(complementoAtual) ? pessoaJuridicaAlterada.getComplemento() : complementoAtual;
                    String bairroAlterado = pessoaJuridicaAlterada.getBairro() != null && !pessoaJuridicaAlterada.getBairro().equals(bairroAtual) ? pessoaJuridicaAlterada.getBairro() : bairroAtual;
                    String cidadeAlterada = pessoaJuridicaAlterada.getCidade() != null && !pessoaJuridicaAlterada.getCidade().equals(cidadeAtual) ? pessoaJuridicaAlterada.getCidade() : cidadeAtual;
                    String estadoAlterado = pessoaJuridicaAlterada.getEstado() != null && !pessoaJuridicaAlterada.getEstado().equals(estadoAtual) ? pessoaJuridicaAlterada.getEstado() : estadoAtual;
                    String razaoSocialAlterada = pessoaJuridicaAlterada.getRazaoSocial() != null && !pessoaJuridicaAlterada.getRazaoSocial().equals(razaoSocialAtual) ? pessoaJuridicaAlterada.getRazaoSocial() : razaoSocialAtual;
                    String inscricaoEstadualAlterada = pessoaJuridicaAlterada.getInscricaoEstadual() != null && !pessoaJuridicaAlterada.getInscricaoEstadual().equals(inscricaoEstadualAtual) ? pessoaJuridicaAlterada.getInscricaoEstadual() : inscricaoEstadualAtual;
                    String cnpjAlterado = pessoaJuridicaAlterada.getCnpj() != null && !pessoaJuridicaAlterada.getCnpj().equals(cnpjAtual) ? pessoaJuridicaAlterada.getCnpj() : cnpjAtual;
    
                    try (PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
                        psUpdate.setString(1, nomeAlterado);
                        psUpdate.setDate(2, java.sql.Date.valueOf(dataNascimentoAlterada));
                        psUpdate.setString(3, telefoneAlterado);
                        psUpdate.setString(4, emailAlterado);
                        psUpdate.setString(5, enderecoAlterado);
                        psUpdate.setString(6, numeroLocalAlterado);
                        psUpdate.setString(7, complementoAlterado);
                        psUpdate.setString(8, bairroAlterado);
                        psUpdate.setString(9, cidadeAlterada);
                        psUpdate.setString(10, estadoAlterado);
                        psUpdate.setString(11, razaoSocialAlterada);
                        psUpdate.setString(12, inscricaoEstadualAlterada);
                        psUpdate.setString(13, cnpjAlterado);
                        psUpdate.setObject(14, pessoaJuridicaAlterada.getId());
    
                        psUpdate.executeUpdate();
                        System.out.println("Cliente (Pessoa Jurídica) atualizado com sucesso!");
                    }
                }
            } else {
                System.err.println("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

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
                    numeroLocal, complemento, bairro, cidade, estado, razaoSocial, inscricaoEstadual, cnpj
                );
    
                clientes.add(pessoaJuridica);
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes (Pessoa Jurídica): " + e.getMessage());
        }
    
        return clientes;
    }
    
}
