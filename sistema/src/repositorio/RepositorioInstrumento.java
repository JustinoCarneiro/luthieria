package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void inserir(Instrumento instrumento){

    }

    public void alterar(Instrumento instrumento){
        
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
                    String dataFabricacao = rs.getString("data_fabricacao");
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
                String dataFabricacao = rs.getString("data_fabricacao");
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
                String ajusteDeTensao = rs.getString("ajuste_de_tensao");

                Membranofone instrumento = new Membranofone(
                    id, nome, nomesAdicionais, categoria, procedencia, descricao, dataFabricacao,
                    fabricante, fabricacaoPais, fabricacaoCidade, fabricacaoEstado, fabricacaoLocalidade,
                    material, peso, altura, estadoConservacao, marcasInscricoes, status,
                    tipoMembrana, metodoTocarMembrana, ajusteDeTensao
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
                String dataFabricacao = rs.getString("data_fabricacao");
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
                String dataFabricacao = rs.getString("data_fabricacao");
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
}
