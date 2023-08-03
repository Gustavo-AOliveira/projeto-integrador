package DAO;

import com.mysql.jdbc.PreparedStatement;
import factory.ConnectionFactory;
import model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // SALVAR
    public void save(Funcionario funcionario){

        String sql = "INSERT INTO funcionarios(nome, CPF, rg, rgf) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar conexão com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //PreparedStatement criada para executar uma query
            pstm =(PreparedStatement) conn.prepareStatement(sql);

            //Adicionando valores esperados pela query
            pstm.setString(1,funcionario.getNome());
            pstm.setString(2,funcionario.getCpf());
            pstm.setString(3, funcionario.getRg());
            pstm.setString(4, funcionario.getRgf());

            //Executar a query
            pstm.execute();

            System.out.println("Salvo com sucesso");

        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            //fechar conexões
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
    //ATUALIZAR
    public void upadate(Funcionario funcionario){

        String sql = "UPDATE funcionarios SET nome = ?, cpf = ?,  rg = ?,  rgf = ?" + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Criar conexão com banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar valores
            pstm.setString(1,funcionario.getNome());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getRg());
            pstm.setString(4,funcionario.getRgf());

            //Id que deseja atualizar os dados
            pstm.setInt(5,funcionario.getId());

            //Executar uma query
            pstm.execute();

        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
    //LISTAR TODOS
    public List<Funcionario> getFuncionarios(){

        String sql = "SELECT * FROM funcionarios";

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rset.getInt("id"));
                funcionario.setNome(rset.getString("nome"));
                funcionario.setCpf(rset.getString("cpf"));
                funcionario.setRg(rset.getString("rg"));
                funcionario.setRgf(rset.getString("rgf"));

                funcionarios.add(funcionario);

            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return funcionarios;
    }

    public void deleteById(int id){

        String sql = "DELETE FROM funcionarios WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1,id);

            pstm.execute();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try {
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
