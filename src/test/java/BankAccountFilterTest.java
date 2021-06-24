import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountFilterTest {
    @Test
    void filterAccounts() {

        BankAccount acct1 = new BankAccount(1234,50,-100);
        BankAccount acct2 = new BankAccount(4356,150,100);

        //BankAccountDao dao = new BankAccountDao();
        BankAccountDao dao = Mockito.mock(BankAccountDao.class);

        List<BankAccount> results = Arrays.asList(acct1, acct2);
        Mockito.when(dao.all()).thenReturn(results);

        BankAccountFilter filter = new BankAccountFilter(dao);
        List<BankAccount> result = filter.filter();

        Assertions.assertEquals(acct1, result.get(0));
        Assertions.assertEquals(1, result.size());
    }

}
