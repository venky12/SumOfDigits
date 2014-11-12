import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Unit tests for the SumOfDigits
 */
public class SumOfDigitsTest 
extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SumOfDigitsTest( String testName )
    {
        super( testName );
    }

    /** 
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SumOfDigitsTest.class );
    }

    /**
     * Simple Test
     */
    public void test_message() {
        try {
            String executable = System.getProperty("executableName");
            String args = "";
            
            String command = executable + " " + args;
            System.out.println(command);
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(command);
            p.waitFor();
            
            String line = null;
            String output, errors;
            output = errors = "";
            
            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = inputBuffer.readLine()) != null) {
                output += line + System.getProperty("line.separator");
            }
            
            inputBuffer = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = inputBuffer.readLine()) != null) {
                errors += line + System.getProperty("line.separator"); 
            }
            
            assertEquals(errors, "");

            String expectedResult = "Hello world" + "\n";
            assertEquals(output, expectedResult);
        } catch (Exception e) {
             System.out.println(e.getMessage());
             fail("Test failed : " + e.getMessage());
        } finally {
        }
    }
}
