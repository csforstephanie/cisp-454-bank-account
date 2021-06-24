import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao {

    private static Connection c;

    public BankAccountDao() {
        try {
            if(c!=null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:mymemdb.db", "SA", "");
            c.prepareStatement("create table bankaccount (acctNum int, balance int, lastTransaction int)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BankAccount> all() {

        List<BankAccount> allAccounts = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from bankaccount");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int acctNum = rs.getInt("acctNum");
                int balance = rs.getInt("balance");
                int lastTransaction = rs.getInt("lastTransaction");
                allAccounts.add(new BankAccount(acctNum, balance, lastTransaction));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allAccounts;
        }

    }

    public void save(BankAccount acct) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into invoice (acctNum, balance, lastTransaction) values (?,?, ?)");
            ps.setInt(1, acct.getAccountNum());
            ps.setInt(2, acct.getBalance());
            ps.setInt(3, acct.getLastTransactAmount());

            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

