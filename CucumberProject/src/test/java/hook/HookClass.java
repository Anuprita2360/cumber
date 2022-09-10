package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;

public class HookClass 
{
	@Before//acts as beforeMethod
	public void before()
	{
		System.out.println("before");
	}
	
	@BeforeAll  //acts as beforeSuite
	public static void beforeAll()
	{
		System.out.println("beforeAll");
	}
	
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("beforeStep");
	}
	
	@After
	public void after()
	{
		System.out.println("after");
	}
	
	@AfterAll
	public static void afterAll()
	{
		System.out.println("afterAll");
	}
	
	@AfterStep
	public void afterStep()
	{
		System.out.println("afterStep");
	}

}
