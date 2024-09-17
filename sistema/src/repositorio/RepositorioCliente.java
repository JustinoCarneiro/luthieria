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
    String sql;

    public void inserir(Cliente cliente) {

        Cliente clientePorId = buscaPorId(cliente.getId());

        if (clientePorId != null) {
            throw new IllegalArgumentException("Cliente com o mesmo ID já existe.");
        }

        if (cliente instanceof PessoaFisica) {

            PessoaFisica pessoaFisica = (PessoaFisica) cliente;
            String cpf = pessoaFisica.getCpf();
            Cliente clientePorCpf = buscaPorCpfouCNPJ(cpf);

            if (clientePorCpf != null) {
                throw new IllegalArgumentException("Cliente com o mesmo CPF já existe.");
            }

            inserirPessoaFisica(pessoaFisica);

        } else if (cliente instanceof PessoaJuridica) {

            PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
            String cnpj = pessoaJuridica.getCnpj();
            Cliente clientePorCnpj = buscaPorCpfouCNPJ(cnpj);

            if (clientePorCnpj != null) {
                throw new IllegalArgumentException("Cliente com o mesmo CNPJ já existe.");
            }

            inserirPessoaJuridica(pessoaJuridica);

        } else {
            System.err.println("Tipo de cliente não reconhecido.");
        }
    }

    public void alterar(Cliente clienteAlterado) {

        if (clienteAlterado instanceof PessoaFisica) {
            alterarPessoaFisica((PessoaFisica) clienteAlterado);
        } else if (clienteAlterado instanceof PessoaJuridica) {
            alterarPessoaJuridica((PessoaJuridica) clienteAlterado);
        } else {
            System.err.println("Tipo de cliente não reconhecido.");
        }

    }

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
    
    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();
    
        String sqlPessoaFisica = "SELECT * FROM cliente_pessoa_fisica";
        String sqlPessoaJuridica = "SELECT * FROM cliente_pessoa_juridica";

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
    
    public Cliente buscaPorId(UUID id){
        String sqlPf = "SELECT * FROM cliente_pessoa_fisica WHERE id = ?";
        String sqlPj = "SELECT * FROM cliente_pessoa_juridica WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement psPf = connection.prepareStatement(sqlPf);
            PreparedStatement psPj = connection.prepareStatement(sqlPj)) {

            psPf.setObject(1, id);
            ResultSet resultSetPf = psPf.executeQuery();
            
            if (resultSetPf.next()) {
                return new PessoaFisica(
                    (UUID) resultSetPf.getObject("id"),
                    resultSetPf.getString("nome_completo"),
                    resultSetPf.getDate("data_nascimento").toLocalDate(),
                    resultSetPf.getString("telefone_celular"),
                    resultSetPf.getString("email"),
                    resultSetPf.getString("endereco"),
                    resultSetPf.getString("numero_local"),
                    resultSetPf.getString("complemento"),
                    resultSetPf.getString("bairro"),
                    resultSetPf.getString("cidade"),
                    resultSetPf.getString("estado"),
                    resultSetPf.getString("cpf")
                );
            }

            psPj.setObject(1, id);
            ResultSet resultSetPj = psPj.executeQuery();
            
            if (resultSetPj.next()) {
                return new PessoaJuridica(
                    (UUID) resultSetPj.getObject("id"),
                    resultSetPj.getString("nome_completo"),
                    resultSetPj.getDate("data_nascimento").toLocalDate(),
                    resultSetPj.getString("telefone_celular"),
                    resultSetPj.getString("email"),
                    resultSetPj.getString("endereco"),
                    resultSetPj.getString("numero_local"),
                    resultSetPj.getString("complemento"),
                    resultSetPj.getString("bairro"),
                    resultSetPj.getString("cidade"),
                    resultSetPj.getString("estado"),
                    resultSetPj.getString("razao_social"),
                    resultSetPj.getString("inscricao_estadual"),
                    resultSetPj.getString("cnpj")
                );
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }

        return null;
    }

    public Cliente buscaPorCpfouCNPJ(String identificador) {
        String sqlPf = "SELECT * FROM cliente_pessoa_fisica WHERE cpf = ?";
        String sqlPj = "SELECT * FROM cliente_pessoa_juridica WHERE cnpj = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psPf = connection.prepareStatement(sqlPf);
             PreparedStatement psPj = connection.prepareStatement(sqlPj)) {
    
            psPf.setString(1, identificador);
            ResultSet resultSetPf = psPf.executeQuery();
            
            if (resultSetPf.next()) {
                return new PessoaFisica(
                    (UUID) resultSetPf.getObject("id"),
                    resultSetPf.getString("nome_completo"),
                    resultSetPf.getDate("data_nascimento").toLocalDate(),
                    resultSetPf.getString("telefone_celular"),
                    resultSetPf.getString("email"),
                    resultSetPf.getString("endereco"),
                    resultSetPf.getString("numero_local"),
                    resultSetPf.getString("complemento"),
                    resultSetPf.getString("bairro"),
                    resultSetPf.getString("cidade"),
                    resultSetPf.getString("estado"),
                    resultSetPf.getString("cpf")
                );
            }
    
            psPj.setObject(1, identificador);
            ResultSet resultSetPj = psPj.executeQuery();
            
            if (resultSetPj.next()) {
                return new PessoaJuridica(
                    (UUID) resultSetPj.getObject("id"),
                    resultSetPj.getString("nome_completo"),
                    resultSetPj.getDate("data_nascimento").toLocalDate(),
                    resultSetPj.getString("telefone_celular"),
                    resultSetPj.getString("email"),
                    resultSetPj.getString("endereco"),
                    resultSetPj.getString("numero_local"),
                    resultSetPj.getString("complemento"),
                    resultSetPj.getString("bairro"),
                    resultSetPj.getString("cidade"),
                    resultSetPj.getString("estado"),
                    resultSetPj.getString("razao_social"),
                    resultSetPj.getString("inscricao_estadual"),
                    resultSetPj.getString("cnpj")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente por CPF/CNPJ: " + e.getMessage());
        }
    
        return null;
    }

    private void inserirPessoaFisica(PessoaFisica pessoaFisica) {
        
        UUID id = UUID.randomUUID();
        String sql = "INSERT INTO cliente_pessoa_fisica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, id);
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
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente (pessoa física): " + e.getMessage());
        }
    }

    private void inserirPessoaJuridica(PessoaJuridica pessoaJuridica) {

        UUID id = UUID.randomUUID();
        String sql = "INSERT INTO cliente_pessoa_juridica (id, nome_completo, data_nascimento, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, razao_social, inscricao_estadual, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, id);
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

        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente (pessoa jurídica): " + e.getMessage());
        }
    }

    private void alterarPessoaFisica(PessoaFisica pessoaFisicaAlterada) {

        String sqlUpdate = "UPDATE cliente_pessoa_fisica SET nome_completo = ?, data_nascimento = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cpf = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

                psUpdate.setString(1, pessoaFisicaAlterada.getNomeCompleto());
                psUpdate.setDate(2, java.sql.Date.valueOf(pessoaFisicaAlterada.getDataNascimento()));
                psUpdate.setString(3, pessoaFisicaAlterada.getTelefoneCelular());
                psUpdate.setString(3, pessoaFisicaAlterada.getTelefoneCelular());
                psUpdate.setString(4, pessoaFisicaAlterada.getEmail());
                psUpdate.setString(5, pessoaFisicaAlterada.getEndereco());
                psUpdate.setString(6, pessoaFisicaAlterada.getNumeroLocal());
                psUpdate.setString(7, pessoaFisicaAlterada.getComplemento());
                psUpdate.setString(8, pessoaFisicaAlterada.getBairro());
                psUpdate.setString(9, pessoaFisicaAlterada.getCidade());
                psUpdate.setString(10, pessoaFisicaAlterada.getEstado());
                psUpdate.setString(11, pessoaFisicaAlterada.getCpf());
                psUpdate.setObject(12, pessoaFisicaAlterada.getId());

                psUpdate.executeUpdate();

                System.out.println("Cliente (Pessoa Física) atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente (pessoa física): " + e.getMessage());
        }
    }
    
    private void alterarPessoaJuridica(PessoaJuridica pessoaJuridicaAlterada) {

        String sqlUpdate = "UPDATE cliente_pessoa_juridica SET nome_completo = ?, data_nascimento = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, razao_social = ?, inscricao_estadual = ?, cnpj = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

            psUpdate.setString(1, pessoaJuridicaAlterada.getNomeCompleto());
            psUpdate.setDate(2, java.sql.Date.valueOf(pessoaJuridicaAlterada.getDataNascimento()));
            psUpdate.setString(3, pessoaJuridicaAlterada.getTelefoneCelular());
            psUpdate.setString(4, pessoaJuridicaAlterada.getEmail());
            psUpdate.setString(5, pessoaJuridicaAlterada.getEndereco());
            psUpdate.setString(6, pessoaJuridicaAlterada.getNumeroLocal());
            psUpdate.setString(7, pessoaJuridicaAlterada.getComplemento());
            psUpdate.setString(8, pessoaJuridicaAlterada.getBairro());
            psUpdate.setString(9, pessoaJuridicaAlterada.getCidade());
            psUpdate.setString(10, pessoaJuridicaAlterada.getEstado());
            psUpdate.setString(11, pessoaJuridicaAlterada.getRazaoSocial());
            psUpdate.setString(12, pessoaJuridicaAlterada.getInscricaoEstadual());
            psUpdate.setString(13, pessoaJuridicaAlterada.getCnpj());
            psUpdate.setObject(14, pessoaJuridicaAlterada.getId());

            psUpdate.executeUpdate();

            System.out.println("Cliente (Pessoa Jurídica) atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente (pessoa jurídica): " + e.getMessage());
        }
    }
}
