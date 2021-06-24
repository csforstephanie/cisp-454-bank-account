public class BankAccount {

    private int acctNum;
    private int balance;
    private int lastTransaction;

    public BankAccount(int acctNum)
    {
        this.acctNum = acctNum;
    }

    public BankAccount(int acctNum, int balance, int lastTransaction)
    {
        this.acctNum = acctNum;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }

    public int getAccountNum()
    {
        return acctNum;
    }

    public boolean deposit(int amount)
    {
        if (amount <= 0)
            return false;

        balance += amount;
        lastTransaction = amount;
        return true;
    }

    public boolean withdraw(int amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
            lastTransaction = -amount;
            return true;
        }
        else
            return false;
    }

    public int getBalance()
    {
        return balance;
    }

    public int getLastTransactAmount()
    {
        return lastTransaction;
    }

    @Override
    public String toString()
    {
        return String.format("Account %d (balance $%d)",
                acctNum, balance);
    }

}