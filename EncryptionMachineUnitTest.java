package com.EncryptionMachine;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Test.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import java.text.MessageFormat;

class EncryptionMachineUnitTest extends EncryptionMachine {
	
	EncryptionMachine em = new EncryptionMachine();
	
	

	@Test
	void testPrintExitMessage() {
		String str="Message fully encrypted. Happy secret messaging!";
		assertEquals(str,em.printExitMessage());
	}

	@Test
	void testExchangeKey() {
		String str=em.exchangeKey(Test);
		assertEquals(str, em.exchangeKey());
	}

	@Test
	void testEncryptUserData() {
		String str=em.encryptUserData(Test);
		assertEquals(str, em.encryptUserData());
	}

}
