
public class GreetingMsg {
	private String greeting;
	
	GreetingMsg(String greet)
	{
		this.greeting=greet;
	}
    public String getGreeting()
    {
    	System.out.println("Greeting : "+greeting);
    	return greeting;
    }
}
