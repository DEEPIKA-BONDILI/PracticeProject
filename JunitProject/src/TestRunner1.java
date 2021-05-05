import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
public class TestRunner1 {
    public static void main(String[] args) {
        System.out.println("Running Test classes....");
        Result result = JUnitCore.runClasses(TestMyJUnit.class);
    
        System.out.println("Getting failure if it has....");
        
            for(Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
                System.out.println("----------------------------");
            }
    
    
    System.out.println("Status : "+result.wasSuccessful());
    }
    
    /*
    @Test
    public void testCase1() { //insert data into table
        //String welcomeMessage = "Welcome to JUnit";
        GreetMessenger greetMsg = new GreetMessenger("Welcome to JUnit");
        assertEquals("Welcome to JUnit", greetMsg.getGreeting());
        //same like above line, SavingsAccount's withdraw() method
        System.out.println("testWelcome is over....");
    }
    @Test
    public void testCase2() { //now select can be possible if above test case is succeedded
        int empno = 7839;
        String empname= "KING";
        String empjob = "PRESIDENT"; // u know that this can come from jdbc
        
        assertEquals("PRESIDENT", empjob);
        System.out.println("empjob passed..");
        
        assertTrue(empno > 1000) ;
        System.out.println("empno passed..");
        
        assertNotNull(empname);
        System.out.println("empname passed..");
        
        System.out.println("testSomeAssertions is over....");
    }
    @SuppressWarnings("deprecation")
    @Test
    public void testCase3() {
        SavingsAccount savObj = new SavingsAccount(85000); // Bank.getAccount();
                                    //    like , Garden.getFlower("decoration");
        assertNotNull(savObj);        savObj.withdraw(15000);
        assertEquals("MSG",new Double(70000.0), new Double(savObj.getBankBalance())); 
        
        //assertEquals(70000.0, savObj.getBankBalance());//,"Balance is not matching");
    }
    */
}
