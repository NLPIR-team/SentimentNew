package com.lingjoin.sentiment.test;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.lingjoin.sentiment.Sentiment;

public class SentimentTest {

	List<String> files=new ArrayList<String>();
	
	public void getAllfiles(File filePath){
		File[] fsFiles=filePath.listFiles();
		for(File f:fsFiles){
			if(f.isFile()&&!f.getName().equals(".DS_Store")) files.add(f.getPath());
			if(f.isDirectory()) this.getAllfiles(f);
		}
	}
	
	public String getContent(File file)throws Exception{
		RandomAccessFile f=new RandomAccessFile(file, "r");
		byte[] b=new byte[(int) file.length()];
		f.read(b);
		f.close();
		String c=new String(b,"GBK").replaceAll("\\s", "");
		return c;
	}
	
	public static void main(String[] args)throws Exception{
		Sentiment.init("lib");
		FileWriter fw=new FileWriter(new File("sentiment.txt"));
		String fPath="./data_train";
		SentimentTest test=new SentimentTest();
		test.getAllfiles(new File(fPath));
		for(String f:test.files){
			System.out.println(f);
			String con=test.getContent(new File(f));
			//fw.write(new File(f).getName()+"\t"+NLPIR.paragraphProcess(con, 1).replaceAll(" ", "\t")+"\n");
			String sent=null;
			if(Sentiment.getSentimentPoint(con)>0) sent="褒"; 
			if(Sentiment.getSentimentPoint(con)==0) sent="中";
			if(Sentiment.getSentimentPoint(con)<0) sent="贬";
			fw.write(new File(f).getName()+"\t"+sent+"\t"+con+"\n");
		}
		fw.flush(); 
		fw.close();
	}
}
