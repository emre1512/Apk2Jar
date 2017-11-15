package com.emredavarci.apk2jar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;

public class Main {

	public static void main(String[] args) {
		
		String root = "C:/Users/user/Documents/Tez/Apk2Jar/";
		String dataset = root + "Dataset/";
		String unzip = root + "unzip/";
		String apktooldecompile = root + "apktooldecompile/";	
		
		String d2j = dataset + "d2j/d2j.bat";	
		String apktool = dataset + "apktool/apktool.bat";	
		String androidManifest = apktooldecompile + "AndroidManifest.xml";
		
		String javaSourceFile = unzip + "javaSourceFile.txt";
				
		// Get shell
		ExecuteCommand cmd = new ExecuteCommand();
		
		// Get next apk name at "Dataset" folder
		String apkName = "apper"; // bunu alýrken uzantýsýný silmeyi unutma
		
		// Extract AndroidManifest.xml and save it to "manifest" folder
		cmd.executeCommand(apktool + " d" + " " + dataset + apkName + ".apk" + " -o " + apktooldecompile);	
		
		// Read AndroidManifest.xml and search permissions
		
		
		
//		// Convert apk to jar and save it to "root" folder				
//		cmd.executeCommand(d2j + " " + dataset + apkName + ".apk");		
//		
//		
//		// Unzip jar to "unzip" folder
//		String zipFilePath = root + apkName + "-dex2jar.jar";
//        String destDirectory = unzip;
//
//        try {
//            Utils.unzip(zipFilePath, destDirectory);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//		        
//        // Find all .class files in "unzip" directory and decompile them		        
//        File file = new File(unzip);
//        List<String> classFilesList = new ArrayList<String>();
//        Utils.getClassFiles(file, classFilesList);
//        
//        // Extract java source code from all .class files and put it in "unzip" folder
//        extractJavaCode(unzip, javaSourceFile, classFilesList);
//		
//        // Get "javaSourceFile" and search all strings in it
        
        System.out.println("Done");
 
	}
	
	private static void extractJavaCode(String unzip, String javaSourceFile, List<String> classFilesList){
	       
		try {
		    final FileOutputStream stream = new FileOutputStream(javaSourceFile);

		    try {
		        final OutputStreamWriter writer = new OutputStreamWriter(stream);

		        try {
		        	for (String path : classFilesList) {
		        		Decompiler.decompile(path, new PlainTextOutput(writer), DecompilerSettings.javaDefaults());
					}
		        }
		        finally {
		            writer.close();
		        }
		    }
		    finally {
		        stream.close();
		    }
		}
		catch (final IOException e) {
		    // handle error
		}
	}
	
}
