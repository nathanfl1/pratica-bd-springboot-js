package com.pacientes.app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacientes.app.model.InfoPaciente;

@RestController
public class RelatorioController {
    private JdbcTemplate template;

    public RelatorioController(JdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("/api/relatorio")
    public InfoPaciente relatorio() {
        InfoPaciente i = new InfoPaciente();
        i.setQuantidadePacientes(template.queryForObject("Select count(*) from paciente", Integer.class));
        i.setMaisVelhos(
                template.query("SELECT p.nome FROM paciente p WHERE p.idade = (SELECT MAX(p2.idade) FROM paciente p2)",
                        new RowMapper<String>() {
                            @Override
                            public String mapRow(ResultSet rs, int rownumber) throws SQLException {
                                String resultado = rs.getString(1);
                                return resultado;
                            }
                        }));
        i.setMulheresMaisBaixas(template.query(
                "SELECT p.nome FROM paciente p WHERE p.altura = (SELECT MIN(p2.altura) FROM paciente p2 WHERE p2.genero = 'Feminino')",
                new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet rs, int rownumber) throws SQLException {
                        String resultado = rs.getString(1);
                        return resultado;
                    }
                }));
        i.setMedia(template.queryForObject("SELECT AVG(p.idade) FROM paciente p WHERE p.genero = 'Masculino'", Double.class));
        i.setMulheres(template.queryForObject(
                "SELECT count(*) FROM paciente p WHERE p.altura <= 1.70 AND p.altura >= 1.60 AND p.peso > 70 AND p.genero = 'Feminino'",
                Integer.class));
        i.setPessoas(template.queryForObject("SELECT count(*) FROM paciente p WHERE p.idade >= 18 AND p.idade <= 25",
                Integer.class));

        return i;
    }
}
