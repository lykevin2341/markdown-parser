import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.Test;

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
	
}
