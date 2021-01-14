import domain.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AccountTest {

    @Test
    void depositingNegativeNumberShouldReturnFalse() {

        //Arrange
        Account account = new Account("Nick", 12, 400);

        //Act
        boolean isDeposited = account.deposit(-12);

        //Assert
        assertFalse(isDeposited);
    }

    @Test
    void testConstructorAccount() {
        Account account = new Account("Nick", 12, 400);
        String ownerName = account.name;
        long accountNumber = account.getAccountNumber();
        float accountBalance = account.getBalance();
        assertEquals("Nick", ownerName);
        assertEquals(12, accountNumber);
        assertEquals(400, accountBalance);
    }

    @Test
    void withdrawingMoreThanAccountBalanceShouldReturnFalse() {
        Account account = new Account("Nick", 12, 400);
        boolean isWithdrawn = account.withdraw(499, 6);
        assertFalse(isWithdrawn);
    }

    @Test
    void shouldEqualsWhenInterestRateIsCorrect() {
        Account account = new Account("Nick", 12, 400);
        account.addInterest();
        assertEquals(418.000000000f, account.getBalance());
    }
    
    @Test
    void testGetBalance () {
        Account account = new Account("Nick", 12, 400);
        float balance = account.getBalance();
        assertEquals(400, balance);
    }

    @Test
    void testGetAccountNumber() {
        Account account = new Account("Nick", 12, 400);
        long accountNumber = account.getAccountNumber();
        assertEquals(12, accountNumber);
    }

    @Test
    void testToString() {
        Account account = new Account("Nick", 12, 400);
        String accountInfo = account.toString();
        assertEquals("12\tNick\t400,00 ¤", accountInfo );
    }
}

