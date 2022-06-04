import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.*;

public class MarkdownParseTest {

	@Test
	public void addition() {
		assertEquals(2, 1+1);
	}
	
	@Test
	public void testMarkdownFileOne() {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.add("some-thing.html");
		
		try {
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file.md"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMarkdownFileTwo() {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.add("test.html");
		
		try {
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file2.md"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMarkdownFileThree() {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.add("https://something.com");
		toReturn.add("some-thing.html");
		toReturn.add("testing.html");
		
		try {
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file3.md"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMarkdownFileFour(){
		ArrayList<String> toReturn = new ArrayList<>();
		try{
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file4.md"))));
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMarkdownFileFive() {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.add("test-website");
		toReturn.add("second-test-website");
		try {
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file5.md"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testMarkdownFileSix() {
		ArrayList<String> toReturn = new ArrayList<>();
		toReturn.add("www.twitter.com");
		toReturn.add("www.google.com");
		try {
			assertEquals(toReturn, MarkdownParse.getLinks(Files.readString(Path.of(System.getProperty("user.dir") + File.separator + "test-file6.md"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLab4Snippet1() throws IOException{
		Path pathOfSnip = Path.of("./lab4snippet1.md");
		String testerFile = Files.readString(pathOfSnip);
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("`google.com");
		expectedList.add("google.com");
		expectedList.add("ucsd.edu");
		assertEquals(expectedList, MarkdownParse.getLinks(testerFile));
	}

	@Test
	public void testLab4Snippet2() throws IOException{
		Path pathOfSnip = Path.of("./lab4snippet2.md");
		String testerFile = Files.readString(pathOfSnip);
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("a.com");
		expectedList.add("a.com(())");
		expectedList.add("example.com");
		assertEquals(expectedList, MarkdownParse.getLinks(testerFile));
	}

	@Test
	public void testLab4Snippet3() throws IOException{
		Path pathOfSnip = Path.of("./lab4snippet3.md");
		String testerFile = Files.readString(pathOfSnip);
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("https://www.twitter.com");
		expectedList.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
		expectedList.add("https://cse.ucsd.edu");
		assertEquals(expectedList, MarkdownParse.getLinks(testerFile));
	}
}
