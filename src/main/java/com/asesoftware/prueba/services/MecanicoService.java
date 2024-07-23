package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.Mecanico;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class MecanicoService {

    private final JdbcTemplate jdbcTemplate;

    public MecanicoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void insertarMecanico(String primerNombre, String segundoNombre, String primerApellido,
                                 String segundoApellido, String tipoDocumento, Integer documento,
                                 String celular, String direccion, String email, String estado) {

        String sql = "{call insertarMecanico(?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";

        jdbcTemplate.update(sql, primerNombre, segundoNombre, primerApellido, segundoApellido,
                tipoDocumento, documento, celular, direccion, email, estado);
    }

    public List<Mecanico> listarMecanicosDisponibles() {
        String sql = "SELECT * " +
                "FROM (" +
                "    SELECT m.* " +
                "    FROM MECANICOS m " +
                "    WHERE m.estado = 'L' " +
                "    ORDER BY m.documento " +
                ") " +
                "WHERE ROWNUM <= 10";

        return jdbcTemplate.query(sql, new MecanicoRowMapper());
    }

    private static class MecanicoRowMapper implements RowMapper<Mecanico> {
        @Override
        public Mecanico mapRow(ResultSet rs, int rowNum) throws SQLException {
            Mecanico mecanico = new Mecanico();

            mecanico.setTipoDocumento(rs.getString("tipo_documento"));
            mecanico.setDocumento(rs.getInt("documento"));
            mecanico.setPrimerNombre(rs.getString("primer_nombre"));
            mecanico.setSegundoNombre(rs.getString("segundo_nombre"));
            mecanico.setPrimerApellido(rs.getString("primer_apellido"));
            mecanico.setSegundoApellido(rs.getString("segundo_apellido"));
            mecanico.setCelular(rs.getString("celular"));
            mecanico.setDireccion(rs.getString("direccion"));
            mecanico.setEmail(rs.getString("email"));
            mecanico.setEstado(rs.getString("estado"));

            return mecanico;
        }
    }

}
