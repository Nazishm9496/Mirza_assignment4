import java.io.*;
import java.nio.*;
import java.util.*;

public class Application extends DuplicateCounter
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Application duplicateCounter = new Application();
		try
		{
			File inFile = new File("problem2.txt");
			String data = inFile.getPath();
			duplicateCounter.count(data);
		    File outputFile = new File("unique_word_counts.txt");
		    String moreData = outputFile.getPath();
		    duplicateCounter.write(moreData);
			
		}
		catch(ArrayIndexOutOfBoundsException | SecurityException |
				FormatterClosedException a)
		{
			a.printStackTrace();
		}
	}
}