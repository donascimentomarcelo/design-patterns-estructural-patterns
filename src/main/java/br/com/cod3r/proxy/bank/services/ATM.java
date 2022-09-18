package br.com.cod3r.proxy.bank.services;

public class ATM implements BankOperations {

    private BankOperations bank;

    public ATM(final BankOperations bank) {
        this.bank = bank;
    }

    @Override
    public void deposit(final Long account, final Long amount) {
        System.out.println("ATM proxy deposit");
        bank.deposit(account, amount);
    }

    @Override
    public void withdraw(final Long account, final String passwd, final Long amount) {
        if (amount > 300) {
            System.out.println("...");
            return;
        }

        System.out.println("ATM proxy withdraw");
        bank.withdraw(account, passwd, amount);
    }

    @Override
    public void changePassword(final Long account, final String oldPassword, final String newPassword) {
        System.out.println("change password");
        return;
    }
}
