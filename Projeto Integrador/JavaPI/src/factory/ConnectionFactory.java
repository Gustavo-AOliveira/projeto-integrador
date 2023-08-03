package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root"; //Nome do usuário MySQL
    private static final String PASSWORD = "56624560v"; //Senha do banco
    private static final String DATABASE_URL =  "jdbc:mysql://localhost:3306/projeto";

    //Conexão com banco de dados
    public static Connection createConnectionToMySQL() throws Exception{

        //Faz com que a classe seja carregada pela JMV
        Class.forName("com.mysql.jdbc.Driver");

        //Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {

        //Recuperar conexão com o banco de dados
        Connection con = createConnectionToMySQL();

        //Testar se a conexão é nula
        if(con!=null){
            System.out.println("Conexão obtida com sucesso");
            con.close();
        }
    }
}
