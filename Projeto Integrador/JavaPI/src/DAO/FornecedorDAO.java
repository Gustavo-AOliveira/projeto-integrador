package DAO;
import com.mysql.jdbc.PreparedStatement;
import factory.ConnectionFactory;
import model.Fornecedor;
import model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    //SALVAR
    public void save(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores(nome, ie, endereco, cep) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Criar conexão com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //PreparedStatement criada para executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionando valores pela query
            pstm.setString(1,fornecedor.getNome());
            pstm.setString(2,fornecedor.getIe());
            pstm.setString(3,fornecedor.getEndereco());
            pstm.setString(4,fornecedor.getcep());

            //Executa a query
            pstm.execute();

            //System.out.println("Fornecedor salvo com sucesso");

        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            //Fecha as conexões
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
    public void update(Fornecedor fornecedor){

        String sql = "UPDATE fornecedores SET nome = ?, ie = ?, endereco = ?, cep = ?" + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Criar conexão com banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Criar classe para executar a query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar valores
            pstm.setString(1,fornecedor.getNome());
            pstm.setString(2, fornecedor.getIe());
            pstm.setString(3, fornecedor.getEndereco());
            pstm.setString(4, fornecedor.getCnpj());
            pstm.setString(5,fornecedor.getcep());

            //Id que deseja atualizar os dados
            pstm.setInt(6,fornecedor.getId());

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
    public List<Fornecedor> getFornecedores(){

        String sql = "SELECT * FROM fornecedores";

        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rset.getInt("id"));
                fornecedor.setNome(rset.getString("nome"));
                fornecedor.setCnpj(rset.getString("cnpj"));
                fornecedor.setIe(rset.getString("ie"));
                fornecedor.setEndereco(rset.getString("endereco"));
                fornecedor.setcep(rset.getString("cep"));

                fornecedores.add(fornecedor);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(rset!=null){
                    rset.close();
                }
                if (pstm!=null){
                    rset.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return fornecedores;
    }
    public void deleteById(int id){

        String sql = "DELETE FROM fornecedores WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1,id);

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
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
}












