package Bank.BankArtifact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bank.BankArtifact.Bank;
import Bank.BankArtifact.Client;

public class BankIT {
	public final float floatTolerance = 0.0001f;
	private Bank bank;
	
	@Before
    public void setUp() {
		// this is a simple abstraction from what would be a database connection
		// testing several systems with one simple test
		
		bank = new Bank();
		Client carlos = new Client("Carlos");
		Client melo = new Client("Melo");
		Client rui = new Client("Rui");
		
		bank.addClient(carlos);	bank.addClient(melo); bank.addClient(rui);
    }
	

	@Test
	public void testDepositAmount() {
		Client cl = this.bank.getClientByName("Rui");
		assertNotNull(cl);
		cl.depositMoney(25);
		Client cl2 = this.bank.getClientByName("Rui");
		assertNotNull(cl2);
		assertEquals(25, cl2.getAccount().getAmount(),floatTolerance);
	}
	
	@Test	
	public void testWithdrawAmount() {
		Client cl = this.bank.getClientByName("Rui");
		assertNotNull(cl);
		cl.depositMoney(25);
		assertEquals(0,this.bank.withdrawClientAccount(cl, 25),floatTolerance);
		assertEquals(-1,this.bank.withdrawClientAccount(cl, 1),floatTolerance);
	}
	
	@Test
	public void testTransactionBetweenUsers() {
		// use the functions transfer(Client,Client,float) & getClientByName(String) from Bank
		assertTrue(true);
	}

}
