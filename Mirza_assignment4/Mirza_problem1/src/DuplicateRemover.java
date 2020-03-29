import java.io.*;
import java.nio.*;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.*;

public class DuplicateRemover
{
	public HashSet<String> uniqueWords;

	public void remove (String dataFile)
	{
		try
		{
			BufferedReader inputFile = new BufferedReader(new FileReader(dataFile));
			Scanner input = new Scanner(inputFile);
			while(input.hasNext())
			{
				String[] lines = input.nextLine().split(" ");
				String edit = "";
				for(int i = 0; i < lines.length; i++)
				{
					if (uniqueWords.add(lines[i]))
					{
						edit += lines[i] + " ";
					}
				}
				edit = edit.strip();
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
						inputFile.close();
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}
		}
	}
	public void write (String outputFile)
	{
		try
		{
			File file = new File(outputFile);
			if(!file.exists())
			{
				file.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
			output.write(String.join("/n", uniqueWords));
			output.close();
		}
		catch(FileAlreadyExistsException f)
		{
			f.printStackTrace();
		}
	}
}
