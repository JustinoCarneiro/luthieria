package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bd.DatabaseConnection;
import model.OrdemServico;

public class RepositorioOrdemServico {
    String sql;

    public void inserir(OrdemServico ordemServico) {

        OrdemServico ordemExistente = buscarPorId(ordemServico.getId());

        if (ordemExistente != null) {
            System.out.println("A ordem de serviço já existe no banco de dados.");
            return;
        }

        UUID id = UUID.randomUUID();

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        String anoMes = formatter.format(agora);

        String ultimoCodigo = obterUltimoCodigo();

        String novoCodigo = gerarCodigo(anoMes, ultimoCodigo);

        sql = "INSERT INTO ordens_servicos (id, codigo, tipo_servico, id_instrumento, id_cliente, valor_servico, pecas, status_instrumento, observacao_status, previsao_entrega) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setObject(1, id);
            ps.setString(2, novoCodigo);
            ps.setString(3, ordemServico.getTipoServico());
            ps.setObject(4, ordemServico.getIdInstrumento());
            ps.setObject(5, ordemServico.getIdCliente());
            ps.setDouble(6, ordemServico.getValorServico());
            ps.setString(7, ordemServico.getPecas());
            ps.setString(8, ordemServico.getStatusInstrumento());
            ps.setString(9, ordemServico.getObservacaoStatus());
            ps.setDate(10, java.sql.Date.valueOf(ordemServico.getPrevisaoEntrega()));

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public List<OrdemServico> listar() {
        List<OrdemServico> ordensServicos = new ArrayList<>();
        sql = "SELECT * FROM ordens_servicos";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");
                String codigo = rs.getString("codigo");
                String tipoServico = rs.getString("tipo_servico");
                UUID idInstrumento = (UUID) rs.getObject("id_instrumento");
                UUID idCliente = (UUID) rs.getObject("id_cliente");
                double valorServico = rs.getDouble("valor_servico");
                String pecas = rs.getString("pecas");
                String statusInstrumento = rs.getString("status_instrumento");
                String observacaoStatus = rs.getString("observacao_status");
                LocalDate previsaoEntrega = rs.getDate("previsao_entrega").toLocalDate();

                OrdemServico ordemServico = new OrdemServico(id, codigo, tipoServico, idInstrumento, idCliente,
                    valorServico, pecas, statusInstrumento, observacaoStatus, previsaoEntrega);
                ordensServicos.add(ordemServico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordensServicos;
    }

    public void remover(OrdemServico ordemServico) {
        String sql = "DELETE FROM ordens_servicos WHERE id = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
    
            ps.setObject(1, ordemServico.getId());
    
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace(); // ou algum outro tratamento de exceção adequado
        }
    }
    
    public void alterar(OrdemServico ordemServico) {
        String sql = "UPDATE ordens_servicos SET codigo = ?, tipo_servico = ?, id_instrumento = ?, id_cliente = ?, valor_servico = ?, pecas = ?, status_instrumento = ?, observacao_status = ?, previsao_entrega = ? WHERE id = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
    
            ps.setString(1, ordemServico.getCodigo());
            ps.setString(2, ordemServico.getTipoServico());
            ps.setObject(3, ordemServico.getIdInstrumento());
            ps.setObject(4, ordemServico.getIdCliente());
            ps.setDouble(5, ordemServico.getValorServico());
            ps.setString(6, ordemServico.getPecas());
            ps.setString(7, ordemServico.getStatusInstrumento());
            ps.setString(8, ordemServico.getObservacaoStatus());
            ps.setDate(9, java.sql.Date.valueOf(ordemServico.getPrevisaoEntrega()));
            ps.setObject(10, ordemServico.getId());
    
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String obterUltimoCodigo() {

        sql = "SELECT MAX(codigo) AS ultimo_codigo FROM ordens_servicos";

        String ultimoCodigo = null;
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            if (rs.next()) {
                ultimoCodigo = rs.getString("ultimo_codigo");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return ultimoCodigo;
    }

    private String gerarCodigo(String anoMes, String ultimoCodigo) {
        int incremento = 1; 
    
        if (ultimoCodigo != null && ultimoCodigo.startsWith(anoMes)) {
            String parteNumerica = ultimoCodigo.substring(anoMes.length());
            incremento = Integer.parseInt(parteNumerica) + 1;
        }
    
        String incrementoFormatado = String.format("%05d", incremento);
    
        return anoMes + incrementoFormatado;
    }

    public OrdemServico buscarPorId(UUID id) {
        String sql = "SELECT * FROM ordens_servicos WHERE id = ?";
        OrdemServico ordemServico = null;
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
    
            ps.setObject(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ordemServico = new OrdemServico(
                        (UUID) rs.getObject("id"),
                        rs.getString("codigo"),
                        rs.getString("tipo_servico"),
                        (UUID) rs.getObject("id_instrumento"),
                        (UUID) rs.getObject("id_cliente"),
                        rs.getDouble("valor_servico"),
                        rs.getString("pecas"),
                        rs.getString("status_instrumento"),
                        rs.getString("observacao_status"),
                        rs.getDate("previsao_entrega").toLocalDate()
                    );
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return ordemServico;
    }
}
