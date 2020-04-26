package example;

import java.io.IOException;

import org.testng.annotations.Test;

public class Main {
  @Test
  public static void main(String[] args) throws InterruptedException, IOException {
		Scenario1 s1=new Scenario1();
		s1.Scenario1();
		Scenario2 s2=new Scenario2();
		s2.Scenario2();
		Scenario3 s3=new Scenario3();
		s3.Scenario3();


		
		}
}
