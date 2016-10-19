package com.lingjoin.sentiment;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CSentimentLibrary extends Library {

	CSentimentLibrary Instance=(CSentimentLibrary) Native.loadLibrary("SentimentNew", CSentimentLibrary.class);
	
	public boolean ST_Init(String sDataPath, int encode, String sLicenceCode);
	
	public boolean ST_Exit();
	
	public String ST_GetOneObjectResult(String sTitle, String sContent, String sObject);
	
	public String ST_GetSentencePoint(String sSentence);
	
	public double ST_GetSentimentPoint(String sSentence);
	
	public boolean ST_ImportUserDict(String sFilePath, int bOverwrite);
	
	public String ST_GetLastErrMsg();
}
