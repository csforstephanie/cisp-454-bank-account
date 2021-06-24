import java.util.ArrayList;
import java.util.List;

public class BankAccountFilter {

    private BankAccountDao dao;

    public BankAccountFilter(BankAccountDao dao) {
        this.dao = dao;
    }

//    public BankAccountFilter() {
//        this.dao = new BankAccountDao();
//    }

    public List<BankAccount> filter() {

        List<BankAccount> allAccounts = dao.all();

        List<BankAccount> filtered = new ArrayList<>();

        for(BankAccount acct : allAccounts) {
            if(acct.getBalance() < 100)
                filtered.add(acct);
        }

        return filtered;

    }
}