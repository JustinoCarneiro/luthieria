package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bd.DatabaseConnection;
import model.instrumento.Aerofone;
import model.instrumento.Cordofone;
import model.instrumento.Idiofone;
import model.instrumento.Instrumento;
import model.instrumento.Membranofone;

public class RepositorioInstrumento implements IRepositorio<Instrumento>{
    String sql;

    public void inserir(Instrumento instrumento) {
        Instrumento instrumentoPorId = buscarPorId(instrumento.getId());

        if(instrumentoPorId != null){
            throw new IllegalArgumentException("Instrumento com o mesmo ID já existe.");
        }

        if (instrumento instanceof Idiofone) {
            inserirIdiofone((Idiofone) instrumento);
        } else if (instrumento instanceof Membranofone) {
            inserirMembranofone((Membranofone) instrumento);
        } else if (instrumento instanceof Cordofone) {
            inserirCordofone((Cordofone) instrumento);
        } else if (instrumento instanceof Aerofone) {
            inserirAerofone((Aerofone) instrumento);
        } else {
            System.err.println("Tipo de instrumento não reconhecido.");
        }
    }
    
    public void alterar(Instrumento instrumento) {
        if (instrumento instanceof Idiofone) {
            alterarIdiofone((Idiofone) instrumento);
        } else if (instrumento instanceof Membranofone) {
            alterarMembranofone((Membranofone) instrumento);
        } else if (instrumento instanceof Cordofone) {
            alterarCordofone((Cordofone) instrumento);
        } else if (instrumento instanceof Aerofone) {
            alterarAerofone((Aerofone) instrumento);
        } else {
            System.err.println("Tipo de instrumento não reconhecido.");
        }
    }
    
    public List<Instrumento> listar(){
        List<Instrumento> instrumentos = new ArrayList<>();

        String sqlIdiofone = "SELECT * FROM instrumentos_idiofones";
        String sqlMembranofone = "SELECT * FROM instrumentos_membranofones";
        String sqlCordofone = "SELECT * FROM instrumentos_cordofones";
        String sqlAerofone = "SELECT * FROM instrumentos_aerofones";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlIdiofone);
            ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UUID id = (UUID) rs.getObject("id");
                    String nome = rs.getString("nome");
                    String nomesAdicionais = rs.getString("nomes_adicionais");
                    String categoria = rs.getString("categoria");
                    String procedencia = rs.getString("procedencia");
                    String descricao = rs.getString("descricao");
                    LocalDate dataFabricacao = rs.getDate("data_fabricacao").toLocalDate();
                    String fabricante = rs.getString("fabricante");
                    String fabricacaoPais = rs.getString("fabricacao_pais");
                    String fabricacaoCidade = rs.getString("fabricacao_cidade");
                    String fabricacaoEstado = rs.getString("fabricacao_estado");
                    String fabricacaoLocalidade = rs.getString("fabricacao_localidade");
                    String material = rs.getString("material");
                    double peso = rs.getDouble("peso");
                    double altura = rs.getDouble("altura");
                    String estadoConservacao = rs.getString("estado_conservacao");
                    String marcasInscricoes = rs.getString("marcas_inscricoes");
                    String status = rs.getString("status");
                    String metodoExecucao = rs.getString("metodo_execucao");
                    String tipoIdiofone = rs.getString("tipo_idiofone");
            
                    Idiofone instrumento = new Idiofone(
                        id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao,
                        fabricante, fabricacaoPais, fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade,
                        material, peso, altura, estadoConservacao, marcasInscricoes, status,
                        metodoExecucao, tipoIdiofone
                    );

                    instrumentos.add(instrumento);
                }
        } catch (SQLException e) {
            System.err.println("Erro ao listar instrumentos idiofones: " + e.getMessage());
        }

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlMembranofone);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");
                String nome = rs.getString("nome");
                String nomesAdicionais = rs.getString("nomes_adicionais");
                String categoria = rs.getString("categoria");
                String procedencia = rs.getString("procedencia");
                String descricao = rs.getString("descricao");
                LocalDate dataFabricacao = rs.getDate("data_fabricacao").toLocalDate();
                String fabricante = rs.getString("fabricante");
                String fabricacaoPais = rs.getString("fabricacao_pais");
                String fabricacaoCidade = rs.getString("fabricacao_cidade");
                String fabricacaoEstado = rs.getString("fabricacao_estado");
                String fabricacaoLocalidade = rs.getString("fabricacao_localidade");
                String material = rs.getString("material");
                double peso = rs.getDouble("peso");
                double altura = rs.getDouble("altura");
                String estadoConservacao = rs.getString("estado_conservacao");
                String marcasInscricoes = rs.getString("marcas_inscricoes");
                String status = rs.getString("status");
                String tipoMembrana = rs.getString("tipo_membrana");
                String metodoTocarMembrana = rs.getString("metodo_tocar_membrana");
                String ajusteTensao = rs.getString("ajuste_de_tensao");

                Membranofone instrumento = new Membranofone(
                    id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao,
                    fabricante, fabricacaoPais, fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade,
                    material, peso, altura, estadoConservacao, marcasInscricoes, status,
                    tipoMembrana, metodoTocarMembrana, ajusteTensao
                );

                instrumentos.add(instrumento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar instrumentos membranofones: " + e.getMessage());
        }

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlCordofone);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");
                String nome = rs.getString("nome");
                String nomesAdicionais = rs.getString("nomes_adicionais");
                String categoria = rs.getString("categoria");
                String procedencia = rs.getString("procedencia");
                String descricao = rs.getString("descricao");
                LocalDate dataFabricacao = rs.getDate("data_fabricacao").toLocalDate();
                String fabricante = rs.getString("fabricante");
                String fabricacaoPais = rs.getString("fabricacao_pais");
                String fabricacaoCidade = rs.getString("fabricacao_cidade");
                String fabricacaoEstado = rs.getString("fabricacao_estado");
                String fabricacaoLocalidade = rs.getString("fabricacao_localidade");
                String material = rs.getString("material");
                double peso = rs.getDouble("peso");
                double altura = rs.getDouble("altura");
                String estadoConservacao = rs.getString("estado_conservacao");
                String marcasInscricoes = rs.getString("marcas_inscricoes");
                String status = rs.getString("status");
                Integer numeroCordas = rs.getInt("numero_de_cordas");
                String tipoCordas = rs.getString("tipo_de_cordas");
                String metodoExecucaoCorda = rs.getString("metodo_execucao_corda");

                Cordofone instrumento = new Cordofone(
                    id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao,
                    fabricante, fabricacaoPais, fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade,
                    material, peso, altura, estadoConservacao, marcasInscricoes, status,
                    numeroCordas, tipoCordas, metodoExecucaoCorda
                );

                instrumentos.add(instrumento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar instrumentos cordofones: " + e.getMessage());
        }

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sqlAerofone);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");
                String nome = rs.getString("nome");
                String nomesAdicionais = rs.getString("nomes_adicionais");
                String categoria = rs.getString("categoria");
                String procedencia = rs.getString("procedencia");
                String descricao = rs.getString("descricao");
                LocalDate dataFabricacao = rs.getDate("data_fabricacao").toLocalDate();
                String fabricante = rs.getString("fabricante");
                String fabricacaoPais = rs.getString("fabricacao_pais");
                String fabricacaoCidade = rs.getString("fabricacao_cidade");
                String fabricacaoEstado = rs.getString("fabricacao_estado");
                String fabricacaoLocalidade = rs.getString("fabricacao_localidade");
                String material = rs.getString("material");
                double peso = rs.getDouble("peso");
                double altura = rs.getDouble("altura");
                String estadoConservacao = rs.getString("estado_conservacao");
                String marcasInscricoes = rs.getString("marcas_inscricoes");
                String status = rs.getString("status");
                String tipoBocal = rs.getString("tipo_de_bocal");
                String metodoProducaoSom = rs.getString("metodo_de_producao_de_som");
                String ajusteAfinacao = rs.getString("ajuste_de_afinacao");

                Aerofone instrumento = new Aerofone(
                    id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao,
                    fabricante, fabricacaoPais, fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade,
                    material, peso, altura, estadoConservacao, marcasInscricoes, status,
                    tipoBocal, metodoProducaoSom, ajusteAfinacao
                );

                instrumentos.add(instrumento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar instrumentos aerofones: " + e.getMessage());
        }


        return instrumentos;
    }

    public void remover(Instrumento instrumento){

    }

    public Instrumento buscarPorId(UUID id) {
        Instrumento instrumento = null;

        instrumento = buscaIdiofonePorId(id);
        if (instrumento != null) {
            return instrumento; 
        }

        instrumento = buscaMembranofonePorId(id);
        if (instrumento != null) {
            return instrumento;
        }

        instrumento = buscaCordofonePorId(id);
        if (instrumento != null) {
            return instrumento; 
        }

        instrumento = buscaAerofonePorId(id);
        if (instrumento != null) {
            return instrumento; 
        }

        return instrumento;
    }

    private void inserirIdiofone(Idiofone idiofone) {
        UUID id = UUID.randomUUID();
        String sqlInsert = "INSERT INTO instrumentos_idiofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, metodo_execucao, tipo_idiofone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {
            
            psInsert.setObject(1, id);
            psInsert.setString(2, idiofone.getNome());
            psInsert.setString(3, idiofone.getNomesAdicionais());
            psInsert.setString(4, idiofone.getCategoria());
            psInsert.setString(5, idiofone.getProcedencia());
            psInsert.setString(6, idiofone.getDescricao());
            psInsert.setDate(7, java.sql.Date.valueOf(idiofone.getDataFabricacao()));
            psInsert.setString(8, idiofone.getFabricante());
            psInsert.setString(9, idiofone.getFabricacaoPais());
            psInsert.setString(10, idiofone.getFabricacaoCidade());
            psInsert.setString(11, idiofone.getFabricacaoEstado());
            psInsert.setString(12, idiofone.getFabricacaoLocalidade());
            psInsert.setString(13, idiofone.getMaterial());
            psInsert.setDouble(14, idiofone.getPeso());
            psInsert.setDouble(15, idiofone.getAltura());
            psInsert.setString(16, idiofone.getEstadoConservacao());
            psInsert.setString(17, idiofone.getMarcasInscricoes());
            psInsert.setString(18, idiofone.getStatus());
            psInsert.setString(19, idiofone.getMetodoExecucao());
            psInsert.setString(20, idiofone.getTipoIdiofone());
            
            psInsert.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir instrumento idiofone: " + e.getMessage());
        }
    }
    
    private void inserirMembranofone(Membranofone membranofone) {
        UUID id = UUID.randomUUID();
        String sqlInsert = "INSERT INTO instrumentos_membranofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_membrana, metodo_tocar_membrana, ajuste_de_tensao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {
            
            psInsert.setObject(1, id);
            psInsert.setString(2, membranofone.getNome());
            psInsert.setString(3, membranofone.getNomesAdicionais());
            psInsert.setString(4, membranofone.getCategoria());
            psInsert.setString(5, membranofone.getProcedencia());
            psInsert.setString(6, membranofone.getDescricao());
            psInsert.setDate(7, java.sql.Date.valueOf(membranofone.getDataFabricacao()));
            psInsert.setString(8, membranofone.getFabricante());
            psInsert.setString(9, membranofone.getFabricacaoPais());
            psInsert.setString(10, membranofone.getFabricacaoCidade());
            psInsert.setString(11, membranofone.getFabricacaoEstado());
            psInsert.setString(12, membranofone.getFabricacaoLocalidade());
            psInsert.setString(13, membranofone.getMaterial());
            psInsert.setDouble(14, membranofone.getPeso());
            psInsert.setDouble(15, membranofone.getAltura());
            psInsert.setString(16, membranofone.getEstadoConservacao());
            psInsert.setString(17, membranofone.getMarcasInscricoes());
            psInsert.setString(18, membranofone.getStatus());
            psInsert.setString(19, membranofone.getTipoMembrana());
            psInsert.setString(20, membranofone.getMetodoTocarMembrana());
            psInsert.setString(21, membranofone.getAjusteTensao());
            
            psInsert.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir instrumento membranofone: " + e.getMessage());
        }
    }

    private void inserirCordofone(Cordofone cordofone) {
        UUID id = UUID.randomUUID();
        String sqlInsert = "INSERT INTO instrumentos_cordofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, numero_de_cordas, tipo_de_cordas, metodo_execucao_corda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {
            
            psInsert.setObject(1, id);
            psInsert.setString(2, cordofone.getNome());
            psInsert.setString(3, cordofone.getNomesAdicionais());
            psInsert.setString(4, cordofone.getCategoria());
            psInsert.setString(5, cordofone.getProcedencia());
            psInsert.setString(6, cordofone.getDescricao());
            psInsert.setDate(7, java.sql.Date.valueOf(cordofone.getDataFabricacao()));
            psInsert.setString(8, cordofone.getFabricante());
            psInsert.setString(9, cordofone.getFabricacaoPais());
            psInsert.setString(10, cordofone.getFabricacaoCidade());
            psInsert.setString(11, cordofone.getFabricacaoEstado());
            psInsert.setString(12, cordofone.getFabricacaoLocalidade());
            psInsert.setString(13, cordofone.getMaterial());
            psInsert.setDouble(14, cordofone.getPeso());
            psInsert.setDouble(15, cordofone.getAltura());
            psInsert.setString(16, cordofone.getEstadoConservacao());
            psInsert.setString(17, cordofone.getMarcasInscricoes());
            psInsert.setString(18, cordofone.getStatus());
            psInsert.setInt(19, cordofone.getNumeroCordas());
            psInsert.setString(20, cordofone.getTipoCordas());
            psInsert.setString(21, cordofone.getMetodoExecucaoCorda());
            
            psInsert.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir instrumento cordofone: " + e.getMessage());
        }
    }

    private void inserirAerofone(Aerofone aerofone) {
        UUID id = UUID.randomUUID();
        String sqlInsert = "INSERT INTO instrumentos_aerofones (id, nome, nomes_adicionais, categoria, procedencia, descricao, data_fabricacao, fabricante, fabricacao_pais, fabricacao_cidade, fabricacao_estado, fabricacao_localidade, material, peso, altura, estado_conservacao, marcas_inscricoes, status, tipo_de_bocal, metodo_de_producao_de_som, ajuste_de_afinacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(sqlInsert)) {
            
            psInsert.setObject(1, id);
            psInsert.setString(2, aerofone.getNome());
            psInsert.setString(3, aerofone.getNomesAdicionais());
            psInsert.setString(4, aerofone.getCategoria());
            psInsert.setString(5, aerofone.getProcedencia());
            psInsert.setString(6, aerofone.getDescricao());
            psInsert.setDate(7, java.sql.Date.valueOf(aerofone.getDataFabricacao()));
            psInsert.setString(8, aerofone.getFabricante());
            psInsert.setString(9, aerofone.getFabricacaoPais());
            psInsert.setString(10, aerofone.getFabricacaoCidade());
            psInsert.setString(11, aerofone.getFabricacaoEstado());
            psInsert.setString(12, aerofone.getFabricacaoLocalidade());
            psInsert.setString(13, aerofone.getMaterial());
            psInsert.setDouble(14, aerofone.getPeso());
            psInsert.setDouble(15, aerofone.getAltura());
            psInsert.setString(16, aerofone.getEstadoConservacao());
            psInsert.setString(17, aerofone.getMarcasInscricoes());
            psInsert.setString(18, aerofone.getStatus());
            psInsert.setString(19, aerofone.getTipoBocal());
            psInsert.setString(20, aerofone.getMetodoProducaoSom());
            psInsert.setString(21, aerofone.getAjusteAfinacao());
            
            psInsert.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir instrumento aerofone: " + e.getMessage());
        }
    }

    private void alterarIdiofone(Idiofone idiofone) {
        String sqlUpdate = "UPDATE instrumentos_idiofones SET nome = ?, nomes_adicionais = ?, categoria = ?, procedencia = ?, descricao = ?, data_fabricacao = ?, fabricante = ?, fabricacao_pais = ?, fabricacao_cidade = ?, fabricacao_estado = ?, fabricacao_localidade = ?, material = ?, peso = ?, altura = ?, estado_conservacao = ?, marcas_inscricoes = ?, status = ?, metodo_execucao = ?, tipo_idiofone = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
            
            psUpdate.setString(1, idiofone.getNome());
            psUpdate.setString(2, idiofone.getNomesAdicionais());
            psUpdate.setString(3, idiofone.getCategoria());
            psUpdate.setString(4, idiofone.getProcedencia());
            psUpdate.setString(5, idiofone.getDescricao());
            psUpdate.setDate(6, java.sql.Date.valueOf(idiofone.getDataFabricacao()));
            psUpdate.setString(7, idiofone.getFabricante());
            psUpdate.setString(8, idiofone.getFabricacaoPais());
            psUpdate.setString(9, idiofone.getFabricacaoCidade());
            psUpdate.setString(10, idiofone.getFabricacaoEstado());
            psUpdate.setString(11, idiofone.getFabricacaoLocalidade());
            psUpdate.setString(12, idiofone.getMaterial());
            psUpdate.setDouble(13, idiofone.getPeso());
            psUpdate.setDouble(14, idiofone.getAltura());
            psUpdate.setString(15, idiofone.getEstadoConservacao());
            psUpdate.setString(16, idiofone.getMarcasInscricoes());
            psUpdate.setString(17, idiofone.getStatus());
            psUpdate.setString(18, idiofone.getMetodoExecucao());
            psUpdate.setString(19, idiofone.getTipoIdiofone());
            psUpdate.setObject(20, idiofone.getId());
            
            psUpdate.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar instrumento idiofone: " + e.getMessage());
        }
    }
    
    private void alterarMembranofone(Membranofone membranofone) {
        String sqlUpdate = "UPDATE instrumentos_membranofones SET nome = ?, nomes_adicionais = ?, categoria = ?, procedencia = ?, descricao = ?, data_fabricacao = ?, fabricante = ?, fabricacao_pais = ?, fabricacao_cidade = ?, fabricacao_estado = ?, fabricacao_localidade = ?, material = ?, peso = ?, altura = ?, estado_conservacao = ?, marcas_inscricoes = ?, status = ?, tipo_membrana = ?, metodo_tocar_membrana = ?, ajuste_de_tensao = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
            
            psUpdate.setString(1, membranofone.getNome());
            psUpdate.setString(2, membranofone.getNomesAdicionais());
            psUpdate.setString(3, membranofone.getCategoria());
            psUpdate.setString(4, membranofone.getProcedencia());
            psUpdate.setString(5, membranofone.getDescricao());
            psUpdate.setDate(6, java.sql.Date.valueOf(membranofone.getDataFabricacao()));
            psUpdate.setString(7, membranofone.getFabricante());
            psUpdate.setString(8, membranofone.getFabricacaoPais());
            psUpdate.setString(9, membranofone.getFabricacaoCidade());
            psUpdate.setString(10, membranofone.getFabricacaoEstado());
            psUpdate.setString(11, membranofone.getFabricacaoLocalidade());
            psUpdate.setString(12, membranofone.getMaterial());
            psUpdate.setDouble(13, membranofone.getPeso());
            psUpdate.setDouble(14, membranofone.getAltura());
            psUpdate.setString(15, membranofone.getEstadoConservacao());
            psUpdate.setString(16, membranofone.getMarcasInscricoes());
            psUpdate.setString(17, membranofone.getStatus());
            psUpdate.setString(18, membranofone.getTipoMembrana());
            psUpdate.setString(19, membranofone.getMetodoTocarMembrana());
            psUpdate.setString(20, membranofone.getAjusteTensao());
            psUpdate.setObject(21, membranofone.getId());
            
            psUpdate.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar instrumento membranofone: " + e.getMessage());
        }
    }
    
    private void alterarCordofone(Cordofone cordofone) {
        String sqlUpdate = "UPDATE instrumentos_cordofones SET nome = ?, nomes_adicionais = ?, categoria = ?, procedencia = ?, descricao = ?, data_fabricacao = ?, fabricante = ?, fabricacao_pais = ?, fabricacao_cidade = ?, fabricacao_estado = ?, fabricacao_localidade = ?, material = ?, peso = ?, altura = ?, estado_conservacao = ?, marcas_inscricoes = ?, status = ?, numero_de_cordas = ?, tipo_de_cordas = ?, metodo_execucao_corda = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
            
            psUpdate.setString(1, cordofone.getNome());
            psUpdate.setString(2, cordofone.getNomesAdicionais());
            psUpdate.setString(3, cordofone.getCategoria());
            psUpdate.setString(4, cordofone.getProcedencia());
            psUpdate.setString(5, cordofone.getDescricao());
            psUpdate.setDate(6, java.sql.Date.valueOf(cordofone.getDataFabricacao()));
            psUpdate.setString(7, cordofone.getFabricante());
            psUpdate.setString(8, cordofone.getFabricacaoPais());
            psUpdate.setString(9, cordofone.getFabricacaoCidade());
            psUpdate.setString(10, cordofone.getFabricacaoEstado());
            psUpdate.setString(11, cordofone.getFabricacaoLocalidade());
            psUpdate.setString(12, cordofone.getMaterial());
            psUpdate.setDouble(13, cordofone.getPeso());
            psUpdate.setDouble(14, cordofone.getAltura());
            psUpdate.setString(15, cordofone.getEstadoConservacao());
            psUpdate.setString(16, cordofone.getMarcasInscricoes());
            psUpdate.setString(17, cordofone.getStatus());
            psUpdate.setInt(18, cordofone.getNumeroCordas());
            psUpdate.setString(19, cordofone.getTipoCordas());
            psUpdate.setString(20, cordofone.getMetodoExecucaoCorda());
            psUpdate.setObject(21, cordofone.getId());
            
            psUpdate.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar instrumento cordofone: " + e.getMessage());
        }
    }
    
    private void alterarAerofone(Aerofone aerofone) {
        String sqlUpdate = "UPDATE instrumentos_aerofones SET nome = ?, nomes_adicionais = ?, categoria = ?, procedencia = ?, descricao = ?, data_fabricacao = ?, fabricante = ?, fabricacao_pais = ?, fabricacao_cidade = ?, fabricacao_estado = ?, fabricacao_localidade = ?, material = ?, peso = ?, altura = ?, estado_conservacao = ?, marcas_inscricoes = ?, status = ?, tipo_de_bocal = ?, metodo_de_producao_de_som = ?, ajuste_de_afinacao = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {
            
            psUpdate.setString(1, aerofone.getNome());
            psUpdate.setString(2, aerofone.getNomesAdicionais());
            psUpdate.setString(3, aerofone.getCategoria());
            psUpdate.setString(4, aerofone.getProcedencia());
            psUpdate.setString(5, aerofone.getDescricao());
            psUpdate.setDate(6, java.sql.Date.valueOf(aerofone.getDataFabricacao()));
            psUpdate.setString(7, aerofone.getFabricante());
            psUpdate.setString(8, aerofone.getFabricacaoPais());
            psUpdate.setString(9, aerofone.getFabricacaoCidade());
            psUpdate.setString(10, aerofone.getFabricacaoEstado());
            psUpdate.setString(11, aerofone.getFabricacaoLocalidade());
            psUpdate.setString(12, aerofone.getMaterial());
            psUpdate.setDouble(13, aerofone.getPeso());
            psUpdate.setDouble(14, aerofone.getAltura());
            psUpdate.setString(15, aerofone.getEstadoConservacao());
            psUpdate.setString(16, aerofone.getMarcasInscricoes());
            psUpdate.setString(17, aerofone.getStatus());
            psUpdate.setString(18, aerofone.getTipoBocal());
            psUpdate.setString(19, aerofone.getMetodoProducaoSom());
            psUpdate.setString(20, aerofone.getAjusteAfinacao());
            psUpdate.setObject(21, aerofone.getId());
            
            psUpdate.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar instrumento aerofone: " + e.getMessage());
        }
    }

    public Idiofone buscaIdiofonePorId(UUID id) {
        String sqlSelect = "SELECT * FROM instrumentos_idiofones WHERE id = ?";
        Idiofone idiofone = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
            
            ps.setObject(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idiofone = new Idiofone(
                        (UUID) rs.getObject("id"),
                        rs.getString("nome"),
                        rs.getString("nomes_adicionais"),
                        rs.getString("categoria"),
                        rs.getString("procedencia"),
                        rs.getString("descricao"),
                        rs.getDate("data_fabricacao").toLocalDate(),
                        rs.getString("fabricante"),
                        rs.getString("fabricacao_pais"),
                        rs.getString("fabricacao_cidade"),
                        rs.getString("fabricacao_estado"),
                        rs.getString("fabricacao_localidade"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("estado_conservacao"),
                        rs.getString("marcas_inscricoes"),
                        rs.getString("status"),
                        rs.getString("metodo_execucao"),
                        rs.getString("tipo_idiofone")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar idiofone por ID: " + e.getMessage());
        }

        return idiofone;
    }

    public Membranofone buscaMembranofonePorId(UUID id) {
        String sqlSelect = "SELECT * FROM instrumentos_membranofones WHERE id = ?";
        Membranofone membranofone = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
            
            ps.setObject(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    membranofone = new Membranofone(
                        (UUID) rs.getObject("id"),
                        rs.getString("nome"),
                        rs.getString("nomes_adicionais"),
                        rs.getString("categoria"),
                        rs.getString("procedencia"),
                        rs.getString("descricao"),
                        rs.getDate("data_fabricacao").toLocalDate(),
                        rs.getString("fabricante"),
                        rs.getString("fabricacao_pais"),
                        rs.getString("fabricacao_cidade"),
                        rs.getString("fabricacao_estado"),
                        rs.getString("fabricacao_localidade"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("estado_conservacao"),
                        rs.getString("marcas_inscricoes"),
                        rs.getString("status"),
                        rs.getString("tipo_membrana"),
                        rs.getString("metodo_tocar_membrana"),
                        rs.getString("ajuste_de_tensao")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar membranofone por ID: " + e.getMessage());
        }

        return membranofone;
    }

    public Cordofone buscaCordofonePorId(UUID id) {
        String sqlSelect = "SELECT * FROM instrumentos_cordofones WHERE id = ?";
        Cordofone cordofone = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
            
            ps.setObject(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cordofone = new Cordofone(
                        (UUID) rs.getObject("id"),
                        rs.getString("nome"),
                        rs.getString("nomes_adicionais"),
                        rs.getString("categoria"),
                        rs.getString("procedencia"),
                        rs.getString("descricao"),
                        rs.getDate("data_fabricacao").toLocalDate(),
                        rs.getString("fabricante"),
                        rs.getString("fabricacao_pais"),
                        rs.getString("fabricacao_cidade"),
                        rs.getString("fabricacao_estado"),
                        rs.getString("fabricacao_localidade"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("estado_conservacao"),
                        rs.getString("marcas_inscricoes"),
                        rs.getString("status"),
                        rs.getInt("numero_de_cordas"),
                        rs.getString("tipo_de_cordas"),
                        rs.getString("metodo_execucao_corda")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cordofone por ID: " + e.getMessage());
        }

        return cordofone;
    }

    public Aerofone buscaAerofonePorId(UUID id) {
        String sqlSelect = "SELECT * FROM instrumentos_aerofones WHERE id = ?";
        Aerofone aerofone = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
            
            ps.setObject(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aerofone = new Aerofone(
                        (UUID) rs.getObject("id"),
                        rs.getString("nome"),
                        rs.getString("nomes_adicionais"),
                        rs.getString("categoria"),
                        rs.getString("procedencia"),
                        rs.getString("descricao"),
                        rs.getDate("data_fabricacao").toLocalDate(),
                        rs.getString("fabricante"),
                        rs.getString("fabricacao_pais"),
                        rs.getString("fabricacao_cidade"),
                        rs.getString("fabricacao_estado"),
                        rs.getString("fabricacao_localidade"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("altura"),
                        rs.getString("estado_conservacao"),
                        rs.getString("marcas_inscricoes"),
                        rs.getString("status"),
                        rs.getString("tipo_de_bocal"),
                        rs.getString("metodo_de_producao_de_som"),
                        rs.getString("ajuste_de afinacao")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aerofone por ID: " + e.getMessage());
        }

        return aerofone;
    }
}