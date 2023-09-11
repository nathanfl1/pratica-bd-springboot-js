package com.pacientes.app.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.pacientes.app.model.Paciente;

@RestController
@RequestMapping("/api")
public class PacienteController {

  private JdbcTemplate template;

  public PacienteController(JdbcTemplate template) {
    this.template = template;
  }

  @PostMapping("/lista")
  public List<Paciente> listaPacientes(@RequestBody String jsonStr) {
    try {
      System.out.println();
      JSONParser parser = new JSONParser(jsonStr);
      LinkedHashMap<String, Object> json = parser.object();
      return template.query("SELECT * FROM paciente p ORDER BY p." + json.get("arg"), new RowMapper<Paciente>() {
        @Override
        public Paciente mapRow(ResultSet rs, int rownumber) throws SQLException {
          Paciente e = new Paciente();
          e.setNome(rs.getString(1));
          e.setGenero(rs.getString(2));
          e.setIdade(rs.getInt(3));
          e.setCodigo(rs.getInt(4));
          e.setPeso(rs.getDouble(5));
          e.setAltura(rs.getDouble(6));
          return e;
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<String> cadastrar(@RequestBody String jsonStr) {
    try {
      // manipulação de json. monke
      JSONParser parser = new JSONParser(jsonStr);
      LinkedHashMap<String, Object> json = parser.object();

      // associando os dados às variáveis
      String nome = (String) json.get("nome");
      Double altura = Double.valueOf((String) json.get("altura"));
      Double peso = Double.valueOf((String) json.get("peso"));
      String genero = (String) json.get("genero");
      Integer idade = Integer.valueOf((String) json.get("idade"));

      // verifica se há um paciente com nome igual
      for (Paciente pac : listaPacientes())
        if (pac.getNome().equals(nome))
          return new ResponseEntity<String>("Usuário já existe!", HttpStatus.BAD_REQUEST);

      // query
      String query = "INSERT INTO paciente(nome, idade, genero, altura, peso) VALUES(?, ?, ?, ?, ?)";
      template.update(query, nome, idade, genero, altura, peso);
      return new ResponseEntity<String>("Paciente criado!", HttpStatus.CREATED);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("Erro no servidor!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @PostMapping("/pacientes")
  public Paciente paciente(@RequestBody String jsonStr) {

    JSONParser parser = new JSONParser(jsonStr);
    try {
      // É AQUI
      LinkedHashMap<String, Object> json = parser.object();
      return template.query("SELECT * FROM paciente p WHERE p.codigo = " + json.get("codigo"),
          new ResultSetExtractor<Paciente>() {
            @Override
            public Paciente extractData(ResultSet rs) throws SQLException {
              Paciente e = new Paciente();
              while (rs.next()) {
                e.setNome(rs.getString(1));
                e.setGenero(rs.getString(2));
                e.setIdade(rs.getInt(3));
                e.setCodigo(rs.getInt(4));
                e.setPeso(rs.getDouble(5));
                e.setAltura(rs.getDouble(6));
                return e;
              }
              return e;
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Paciente> listaPacientes() {
    return template.query("SELECT * FROM paciente p ORDER BY p.idade", new RowMapper<Paciente>() {
      @Override
      public Paciente mapRow(ResultSet rs, int rownumber) throws SQLException {
        Paciente e = new Paciente();
        e.setNome(rs.getString(1));
        e.setGenero(rs.getString(2));
        e.setIdade(rs.getInt(3));
        e.setCodigo(rs.getInt(4));
        e.setPeso(rs.getDouble(5));
        e.setAltura(rs.getDouble(6));
        return e;
      }
    });
  }
  @PostMapping("/excluir")
  public ResponseEntity<String> excluir(@RequestBody String jsonStr){
    try {
      // manipulação de json. monke
      JSONParser parser = new JSONParser(jsonStr);
      LinkedHashMap<String, Object> json = parser.object();
      template.execute("DELETE FROM paciente p WHERE p.codigo = " + json.get("codigo"));
      return new ResponseEntity<String>("Paciente excluído!", HttpStatus.OK);
    }catch(Exception e)
    {
      e.printStackTrace();
      return new ResponseEntity<String>("Erro no servidor!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
