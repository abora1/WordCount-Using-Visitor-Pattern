package wordCount.util;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;


import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.util.Results;

public class FileProcessor {
	public FileProcessor() {
	}

	private BufferedReader br = null;
	private Results rs=new Results();
	public FileProcessor(File input) {
		try {
			
			br = new BufferedReader(new FileReader(input));
			Logger.writeMessage("New File has Been Accepted",
					DebugLevel.FILE_PROCESSOR);

		} catch (IOException e) {
			Logger.writeMessage("NO INPUT FILE FOUND",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		}

	}

	// this method returns a single line from the file to user.
	public String readline() {
		try {
			String s = null;
			while ((s = br.readLine()) != null) {
				return s;
			}
		} catch (IOException e) {
			Logger.writeMessage("INPUT FILE CANNOT BE FETCHED",
					DebugLevel.FILE_PROCESSOR);
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	public void writeToFile(String s) {
		File f1 = null;
		FileWriter fp1 = null;
		try {
			f1 = new File(s);
			fp1 = new FileWriter(f1);
			fp1.write("" + rs.resList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fp1.close();
			} catch (IOException e) {
				Logger.writeMessage("Cannot Create Output File",
						DebugLevel.FILE_PROCESSOR);
				e.printStackTrace();
			}
		}
	}

	// closes the file when completes execution.
	public void fileclose() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
