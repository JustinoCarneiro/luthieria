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

//Classe responsável pelo CRUD da entidade cliente, tanto pessoa física, quanto pessoa jurídica
public class RepositorioCliente implements IRepositorio<Cliente>{
    String sql;

    //Esse método verifica se o cliente já existe e em caso negativo o insere no banco de dados, caso pessoa jurídica ou pessoa física, no seu banco apropriado
    public void inserir(Cliente cliente) {

        Cliente clientePorId = buscaPorId(cliente.getId());

        if (clientePorId != null) {
            System.out.println("O cliente já existe no banco de dados.");
            return;
        }

        if (cliente instanceof PessoaFisica) {

            PessoaFisica pessoaFisica = (PessoaFisica) cliente;
            String cpf = pessoaFisica.getCpf();
            Cliente clientePorCpf = buscaPorCpfouCNPJ(cpf);

            if (clientePorCpf != null) {
                System.out.println("O cliente já existe no banco de dados.");
                return;
            }

            inserirPessoaFisica(pessoaFisica);

        } else if (cliente instanceof PessoaJuridica) {

            PessoaJuridica pessoaJuridica = (PessoaJuridica) cliente;
            String cnpj = pessoaJuridica.getCnpj();
            Cliente clientePorCnpj = buscaPorCpfouCNPJ(cnpj);

            if (clientePorCnpj != null) {
                System.out.println("O cliente já existe no banco de dados.");
                return;
            }

            inserirPessoaJuridica(pessoaJuridica);

        } else {
            System.err.println("Tipo de cliente não reconhecido.");
        }
    }

    //Método responsável por alterar os dados de um cliente, verificando se o mesmo é pessoa física ou jurídica
    public void alterar(Cliente clienteAlterado) {

        if (clienteAlterado instanceof PessoaFisica) {
            alterarPessoaFisica((PessoaFisica) clienteAlterado);
        } else if (clienteAlterado instanceof PessoaJuridica) {
            alterarPessoaJuridica((PessoaJuridica) clienteAlterado);
        } else {
            System.err.println("Tipo de cliente não reconhecido.");
        }

    }

    //Método responsável por remover um cliente do banco de dados
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
    
    //Método responsável por listar todos os clientes
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
                    id, nomeCompleto, telefoneCelular, email, endereco,
                    numeroLocal, complemento, bairro, cidade, estado, razaoSocial, inscricaoEstadual, cnpj
                );
    
                clientes.add(pessoaJuridica);
            }
    
        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes (Pessoa Jurídica): " + e.getMessage());
        }
    
        return clientes;
    }
    
    //Método responsável por recuperar o cliente pelo seu id
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

    //Método responsável por recuperar o cliente pelo seu cpf ou cnpj, caso pessoa física ou jurídica, respectivamente
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

    //Método auxiliar para inserir especificamente pessoa física
    private void inserirPessoaFisica(PessoaFisica pessoaFisica) {
        
        //Gera o id automaticamente
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

    //Método auxiliar para inserir especificamente pessoa juridica
    private void inserirPessoaJuridica(PessoaJuridica pessoaJuridica) {

        //Gera o id automaticamente
        UUID id = UUID.randomUUID();
        String sql = "INSERT INTO cliente_pessoa_juridica (id, nome_completo, telefone_celular, email, endereco, numero_local, complemento, bairro, cidade, estado, razao_social, inscricao_estadual, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, id);
            ps.setString(2, pessoaJuridica.getNomeCompleto());
            ps.setString(3, pessoaJuridica.getTelefoneCelular());
            ps.setString(4, pessoaJuridica.getEmail());
            ps.setString(5, pessoaJuridica.getEndereco());
            ps.setString(6, pessoaJuridica.getNumeroLocal());
            ps.setString(7, pessoaJuridica.getComplemento());
            ps.setString(8, pessoaJuridica.getBairro());
            ps.setString(9, pessoaJuridica.getCidade());
            ps.setString(10, pessoaJuridica.getEstado());
            ps.setString(11, pessoaJuridica.getRazaoSocial());
            ps.setString(12, pessoaJuridica.getInscricaoEstadual());
            ps.setString(13, pessoaJuridica.getCnpj());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente (pessoa jurídica): " + e.getMessage());
        }
    }

    //Método auxiliar para alterar especificamente pessoa física
    private void alterarPessoaFisica(PessoaFisica pessoaFisicaAlterada) {

        String sqlUpdate = "UPDATE cliente_pessoa_fisica SET nome_completo = ?, data_nascimento = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cpf = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

                psUpdate.setString(1, pessoaFisicaAlterada.getNomeCompleto());
                psUpdate.setDate(2, java.sql.Date.valueOf(pessoaFisicaAlterada.getDataNascimento()));
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
    
    //Método auxiliar para alterar especificamente pessoa jurídica
    private void alterarPessoaJuridica(PessoaJuridica pessoaJuridicaAlterada) {

        String sqlUpdate = "UPDATE cliente_pessoa_juridica SET nome_completo = ?, telefone_celular = ?, email = ?, endereco = ?, numero_local = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, razao_social = ?, inscricao_estadual = ?, cnpj = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

            psUpdate.setString(1, pessoaJuridicaAlterada.getNomeCompleto());
            psUpdate.setString(2, pessoaJuridicaAlterada.getTelefoneCelular());
            psUpdate.setString(3, pessoaJuridicaAlterada.getEmail());
            psUpdate.setString(4, pessoaJuridicaAlterada.getEndereco());
            psUpdate.setString(5, pessoaJuridicaAlterada.getNumeroLocal());
            psUpdate.setString(6, pessoaJuridicaAlterada.getComplemento());
            psUpdate.setString(7, pessoaJuridicaAlterada.getBairro());
            psUpdate.setString(8, pessoaJuridicaAlterada.getCidade());
            psUpdate.setString(9, pessoaJuridicaAlterada.getEstado());
            psUpdate.setString(10, pessoaJuridicaAlterada.getRazaoSocial());
            psUpdate.setString(11, pessoaJuridicaAlterada.getInscricaoEstadual());
            psUpdate.setString(12, pessoaJuridicaAlterada.getCnpj());
            psUpdate.setObject(13, pessoaJuridicaAlterada.getId());

            psUpdate.executeUpdate();

            System.out.println("Cliente (Pessoa Jurídica) atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente (pessoa jurídica): " + e.getMessage());
        }
    }
}
