import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class JunitTest {
    @Test
    public void testWelcome1() {
        String welcomeMessage ="Welcome to Junit";
        assertEquals("Welcome to Junit",welcomeMessage);
    }
    @Test
    public void testWelcome2() {
        String welcomeMessage ="Welcome to Junit";
        assertEquals("Welcome to junit",welcomeMessage);
    }
    @Test
    public void testWelcome3() {
        GreetingMsg g = new GreetingMsg("Welcome to Junit");
        assertEquals("Welcome to Junit",g.getGreeting());
    }
    @Test
    public void testSomeAssertions()
    {
    	int empno=7839;
    	String empname="KING";
    	String empjob="PRESIDENT";
    	
    	assertEquals("PRESIDENT",empjob);
    	System.out.println("empjob passed..");
    	
    	assertTrue(empno > 1000);
    	System.out.println("empno passed..");
    	
    	assertNotNull(empname);
    	System.out.println("empname passed..");
    	
    	System.out.println("testSomeAssertions is over..");
    }
   	 @Test
   	    public void balance() {
   	        SavingsAcc s = new SavingsAcc(85000);
   	        assertNotNull(s);
   	        s.withdraw(15000);
   	        assertEquals(70000,s.getBalance(),"Balance is not Matching");
   	        
   	    }
   }