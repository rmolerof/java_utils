package org.fedex.sandbox.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.cwmoney.utils.CWMoneyParser;

public class CSVReader {

	public static void main(String[] args) {

		String csvFile = "D://LIFE 2015//Taxes & Finances//Financial Backup//Recover CWMoney//cwmoney_ex2_db_en_CSV_20170527.csv";
		String line = "";
		String cvsSplitBy = ",";
		int count = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			StringBuffer fileQuery = null;
			fileQuery = new StringBuffer("");

			StringBuffer header = null;
			header = new StringBuffer("");
			header.append("insert into rec_table\n");
			header.append("(    i_date,    i_type,  i_kind,    i_kinds, i_account, i_item, i_money, i_create,     i_gps,  i_rev1,      i_remark, rev3, rev4, rev5)\n");
			header.append("values\n");
			
			CWMoneyParser parser = new CWMoneyParser(); 
			while ((line = br.readLine()) != null) {
				
				// use comma as separator
				String[] row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				parser.setExpenseOrIncome(cleanStr(row[1]));
				
				if(count > 0){//if(count > 0 && count <= 2844){
					fileQuery.insert(0,  "( '" + CWMoneyParser.parseDate(cleanStr(row[0])) + 
							"', '" + parser.parseType.get(cleanStr(row[1])) + 
							"', '" + parser.getParseKind().get(cleanStr(row[2])) +
							"', '" + parser.getParseKinds().get(cleanStr(row[3])) +
							"', '" + parser.getParseAccount().get(cleanStr(row[4])) + 
							"', '" + parser.getParseItem().get(cleanStr(row[5])) +
							"', " + cleanStr(row[6]) +
							", '" + CWMoneyParser.parseTimeStamp(cleanStr(row[9])) +
							"', '" + cleanStr(row[10]).replace(":", ",") +
							"', '" + cleanStr(row[11]) +
							"', '" + cleanStr(row[12]) +
							"', " + "0" +
							", " + "0" +
							", " + "0" +
							"),\n");
				}
				
				count++;
			}
			
			fileQuery.insert(0, header.toString());
			
			try( PrintWriter out = new PrintWriter("D://LIFE 2015//Taxes & Finances//Financial Backup//Recover CWMoney//query.txt")){
			    out.println( fileQuery.toString().substring(0, fileQuery.toString().length()-2) );
			}
			//System.out.println(fileQuery.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String cleanStr(String el){
		return el.replace("\"", "").replace("'", "").trim();
	}

}