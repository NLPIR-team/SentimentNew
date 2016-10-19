package com.lingjoin.sentiment;

public class Sentiment {

	public static boolean state=false;
	
	public static boolean init(String arg){
		state=CSentimentLibrary.Instance.ST_Init(arg, 1, "");
		if(state){
			return true;
		}else{
			System.out.println(CSentimentLibrary.Instance.ST_GetLastErrMsg());
			return false;
		}
	}
	
	public static String getOneObjectResult(String sTitle, String sContent, String sObject){
		if(state){
			return CSentimentLibrary.Instance.ST_GetOneObjectResult(sTitle, sContent, sObject);
		}else
			return null;
	}
	
	public static String getSentencePoint(String sSentence){
		if(state){
			return CSentimentLibrary.Instance.ST_GetSentencePoint(sSentence);
		}else
			return null;
	}
	
	public static double getSentimentPoint(String sSentence){
		if(state){
			return CSentimentLibrary.Instance.ST_GetSentimentPoint(sSentence);
		}else
			return 0.0;
		
	}
	
	public static boolean importUserDict(String sFilePath, int bOverwrite){
		if(state){
			return CSentimentLibrary.Instance.ST_ImportUserDict(sFilePath, bOverwrite);
		}else
			return false;
	}
	
	public static boolean exit(){
		return CSentimentLibrary.Instance.ST_Exit();
	}
	
	public static String ST_GetLastErrMsg(){
		return CSentimentLibrary.Instance.ST_GetLastErrMsg();
	}
}
