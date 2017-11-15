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
		String dataset = "C:/Users/user/Documents/Tez/Apk2Jar/Dataset/";
		String unzip = "C:/Users/user/Documents/Tez/Apk2Jar/unzip/";
			
		String d2j = "C:/Users/user/Documents/Tez/Apk2Jar/Dataset/decomp/d2j.bat";		
		String javaSource = "javaSource.txt";
		
		// Get next apk name at "Dataset" folder
		String apkName = "apper"; // bunu alýrken uzantýsýný silmeyi unutma
		
		// Convert apk to jar and save it to "root" folder
		ExecuteCommand cmd = new ExecuteCommand();		
		String output = cmd.executeCommand(d2j + " " + dataset + apkName + ".apk");		
		//System.out.println(output);
		
		// Unzip jar to "unzip" folder
		String zipFilePath = root + apkName + "-dex2jar.jar";
        String destDirectory = unzip;

        try {
            Utils.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
        int counter = 0;
        
        // Find all .class files in "unzip" directory
        // Decompile them
		        
        File file = new File(unzip);
        List<String> classFilesList = new ArrayList<String>();
        Utils.getClassFiles(file, classFilesList);
        
//        for (String string : classFilesList) {
//        	System.out.println(string);
//		}
        
        System.out.println("Done");
        
//		try {
//		    final FileOutputStream stream = new FileOutputStream(unzip + javaSource);
//
//		    try {
//		        final OutputStreamWriter writer = new OutputStreamWriter(stream);
//
//		        try {
//		        	Decompiler.decompile("C:/Users/user/Documents/Tez/Apk2Jar/result/android/app/OnActivityPausedListener.class", new PlainTextOutput(writer), DecompilerSettings.javaDefaults());
//		        }
//		        finally {
//		            writer.close();
//		        }
//		    }
//		    finally {
//		        stream.close();
//		    }
//		}
//		catch (final IOException e) {
//		    // handle error
//		}

	
	}
	
}
