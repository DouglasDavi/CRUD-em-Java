/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.entregar;

import br.ces.academia.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.ConnectionFactory;

/**
 *
 * @author Lucas Gomes
 */
public class CrudEntregar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Exibir todos
        System.out.println("Exibindo: \n");
        List<Aluno> alunos = listar();
        System.out.println(alunos + "\n");

        //Inserir
        System.out.println("Iserindo: \n");
        inserir(new Aluno(6, "Lucas G", new Date(), "Rua A", "999999999", new Date(), 1.72f, 65.9f));
        alunos = listar();
        System.out.println(alunos + "\n");
        
        //Atualizar
        System.out.println("Atualizando: \n");
        atualizar(new Aluno(18, "Alfredo Pinto", new Date(), "Rua Z", "111111111", new Date(), 1.6f, 80.8f));
        alunos = listar();
        System.out.println(alunos+"\n");
        
        //Remoção
        System.out.println("Removendo: \n");
        Aluno a = new Aluno();
        a.setId(11);
        remover(a);
        alunos = listar();
        System.out.println(alunos + "\n");

    }

    public static List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        Connection conn = new ConnectionFactory().conecta();
        String sql = "SELECT * FROM aluno";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataMatricula(rs.getDate("dataMatricula"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setDataNascimento(rs.getDate("dataNascimento"));
                aluno.setAltura(rs.getFloat("altura"));
                aluno.setPeso(rs.getFloat("peso"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar alunos!");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return alunos;
    }

    public static void inserir(Aluno aluno) {

        Connection conn = new ConnectionFactory().conecta();
        String sql = "INSERT INTO aluno (nome, dataMatricula, endereco, telefone, dataNascimento, altura, peso) values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setDate(2, new java.sql.Date(aluno.getDataMatricula().getTime()));
            statement.setString(3, aluno.getEndereco());
            statement.setString(4, aluno.getTelefone());
            statement.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
            statement.setFloat(6, aluno.getAltura());
            statement.setFloat(7, aluno.getPeso());

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Aluno inserido com sucesso");
            } else {
                throw new RuntimeException("Erro ao inserir aluno!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir aluno!");
        }
    }

    public static void atualizar(Aluno aluno) {

        Connection conn = new ConnectionFactory().conecta();

        String sql = "UPDATE aluno SET nome=?, dataMatricula=?, endereco=?, telefone=?, dataNascimento=?, altura=?, peso=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setDate(2, new java.sql.Date(aluno.getDataMatricula().getTime()));
            statement.setString(3, aluno.getEndereco());
            statement.setString(4, aluno.getTelefone());
            statement.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTime()));
            statement.setFloat(6, aluno.getAltura());
            statement.setFloat(7, aluno.getPeso());
            statement.setLong(8, aluno.getId());
            
            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas>0){
                System.out.println("Atualização bem sucedida!");
            }else{
                throw new RuntimeException("Erro ao atualizar aluno");
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar aluno");
        }
    }
    
    public static void remover(Aluno aluno){
        
        Connection conn = new ConnectionFactory().conecta();
        String sql = "DELETE FROM aluno WHERE id = ?";
        
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, aluno.getId());
            
            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas>0){
                System.out.println("Removido");
            }else{
                throw new RuntimeException("Erro ao remover");
            }                 
        }catch (SQLException ex){
            throw new RuntimeException("Erro ao remover");
        }        
    }

}
