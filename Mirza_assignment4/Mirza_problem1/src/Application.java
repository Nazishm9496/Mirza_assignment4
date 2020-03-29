import java.io.*;
import java.nio.*;
import java.util.*;


public class Application extends DuplicateRemover
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Application duplicateRemover = new Application();
		try
		{
			File inFile = new File("problem1.txt");
			String data = inFile.getPath();
			duplicateRemover.remove(data);
		    File outputFile = new File("outputFile.txt");
		    String moreData = outputFile.getPath();
		    duplicateRemover.write(moreData);	
		}
		catch(ArrayIndexOutOfBoundsException | SecurityException |
				FormatterClosedException a)
		{
			a.printStackTrace();
		}
	}
}

