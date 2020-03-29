import java.io.*;
import java.nio.*;
import java.util.*;

public class DuplicateCounter
{
	public HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

	public void count(String dataFile)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			String currentLine = reader.readLine();
			while (currentLine != null)
			{
				String[] words = currentLine.toLowerCase().split(" ");
				for (String word : words)
				{
					if(wordCounter.containsKey(word))
					{
						wordCounter.put(word, wordCounter.get(word)+1);
					}
					else
					{
						wordCounter.put(word, 1);
					}
				}
				currentLine = reader.readLine();
			}
		}
		catch(FileNotFoundException | ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		finally
		{
				try
				{
						reader.close();
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}
		}
	}
	public void write(String outputFile)
	{
		try
		{
			BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
			output.write(String.join("/n", wordCounter));
			output.close();
		}
		catch(FileAlreadyExistsException f)
		{
			f.printStackTrace();
		}
		
	}
}
