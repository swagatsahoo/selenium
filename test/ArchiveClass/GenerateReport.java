package org.test.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateReport {
	
	static ConfigPropertyReader configPropertyReader = new ConfigPropertyReader();

	
	public static void generatedReportsWithTimeStamp() {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYYMMMdd_HHmmSS");
		
		File sourceFile = new File(configPropertyReader.sourceReportFile());
		File destinationFile = new File( configPropertyReader.destinationReportFile()+"\\TestReport_" + df.format(date) + ".html" );
		
		try {
			Files.copy(sourceFile.toPath(), destinationFile.toPath());
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
