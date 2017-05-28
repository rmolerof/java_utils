package org.cwmoney.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class CWMoneyParser {
	public static HashMap<String, String> parseType = new HashMap<String, String>();
	public static HashMap<String, String> parseKindIncome = new HashMap<String, String>();
	public static HashMap<String, String> parseKindsIncome = new HashMap<String, String>();
	public static HashMap<String, String> parseKindExpense = new HashMap<String, String>();
	public static HashMap<String, String> parseKindsExpense = new HashMap<String, String>();
	public static HashMap<String, String> parseAccount = new HashMap<String, String>();
	public static HashMap<String, String> parseItem = new HashMap<String, String>();
	
	private String expenseOrIncome;
	
	static{
		parseType.put("Expense", "1");
		parseType.put("Income", "2");
		
		parseKindIncome.put("Salary Income", "1");
		parseKindIncome.put("Other Income", "2");
		parseKindIncome.put("Family", "3");
		parseKindIncome.put("Fortune", "4");
		parseKindIncome.put(" Humita Sales", "5");
		parseKindIncome.put("Remo", "6");
		parseKindIncome.put("Herbalife", "7");
		parseKindIncome.put("", "");
		
		parseKindExpense.put("Food&Drink", "1");
		parseKindExpense.put("Household", "2");
		parseKindExpense.put("Automobile", "3");
		parseKindExpense.put("Communications", "4");
		parseKindExpense.put("Entertainment", "5");
		parseKindExpense.put("Gifts & Social", "7");
		parseKindExpense.put("Medicare", "8");
		parseKindExpense.put("Finance&Investment", "9");
		parseKindExpense.put("Others", "10");
		parseKindExpense.put("Computing", "13");
		parseKindExpense.put("Herbalife", "14");
		parseKindExpense.put("Max", "16");
		parseKindExpense.put("Clothing", "17");
		parseKindExpense.put("Learning", "18");
		parseKindExpense.put("", "");
		
		parseKindsExpense.put("", "");
		parseKindsExpense.put("Breakfast", "1");
		parseKindsExpense.put("Lunch", "2");
		parseKindsExpense.put("Dinner", "3");
		parseKindsExpense.put("Tea,Drinks", "4");
		parseKindsExpense.put("Fruit&Snacks", "5");
		parseKindsExpense.put("Daily Use", "6");
		parseKindsExpense.put("Power&Water bill", "7");
		parseKindsExpense.put("Rent&Loan", "8");
		parseKindsExpense.put("Public transportation", "9");
		parseKindsExpense.put("Taxi", "10");
		parseKindsExpense.put("Car gas", "11");
		parseKindsExpense.put("Train,Air Ticket", "12");
		parseKindsExpense.put("Communication", "13");
		parseKindsExpense.put("Mobile", "14");
		parseKindsExpense.put("Internet", "15");
		parseKindsExpense.put("Cable TV", "16");
		parseKindsExpense.put("Sports", "17");
		parseKindsExpense.put("Friends", "18");
		parseKindsExpense.put("Entertainment", "19");
		parseKindsExpense.put("Pets", "20");
		parseKindsExpense.put("Travel", "21");
		parseKindsExpense.put("Luxury", "22");
		parseKindsExpense.put("Book&Mag.", "23");
		parseKindsExpense.put("Education", "24");
		parseKindsExpense.put("ELearning", "25");
		parseKindsExpense.put("Gifts,Social", "26");
		parseKindsExpense.put("Family", "27");
		parseKindsExpense.put("Donation", "28");
		parseKindsExpense.put("Sick&Medicine", "29");
		parseKindsExpense.put("Medical Insurance", "30");
		parseKindsExpense.put("Insurance", "31");
		parseKindsExpense.put("Health Food", "32");
		parseKindsExpense.put("Beauty Wellness", "33");
		parseKindsExpense.put("Bank Fee", "34");
		parseKindsExpense.put("Investment", "35");
		parseKindsExpense.put("Installment", "36");
		parseKindsExpense.put("Tax Expense", "37");
		parseKindsExpense.put("Fine", "38");
		parseKindsExpense.put("Other", "39");
		parseKindsExpense.put("Money Lost", "40");
		parseKindsExpense.put("Bad debt", "41");
		parseKindsExpense.put("Apartment", "42");
		parseKindsExpense.put("Salsa", "43");
		parseKindsExpense.put("Groceries", "44");
		parseKindsExpense.put("Eye Care", "45");
		parseKindsExpense.put("Tip", "46");
		parseKindsExpense.put("Meter", "47");
		parseKindsExpense.put("Stationary", "48");
		parseKindsExpense.put("Ingredients", "49");
		parseKindsExpense.put("Accessories", "50");
		parseKindsExpense.put("Food", "51");
		parseKindsExpense.put("Transportation", "52");
		parseKindsExpense.put("Peripherals", "53");
		parseKindsExpense.put("Device", "54");
		parseKindsExpense.put("Softwares & Apps", "55");
		parseKindsExpense.put("Hotel", "56");
		parseKindsExpense.put("taxi", "57");
		parseKindsExpense.put("Food", "58");
		parseKindsExpense.put("Transportation", "59");
		parseKindsExpense.put("Electronics", "60");
		parseKindsExpense.put("Essentials", "61");
		parseKindsExpense.put("Insurance", "62");
		parseKindsExpense.put("Accessories", "63");
		parseKindsExpense.put("Car Health", "64");
		parseKindsExpense.put("Joy", "65");
		parseKindsExpense.put("Inventory", "66");
		parseKindsExpense.put("Mail", "67");
		parseKindsExpense.put("Loan", "68");
		parseKindsExpense.put("Toll", "69");
		parseKindsExpense.put("Accessories", "70");
		parseKindsExpense.put("Mail", "71");
		parseKindsExpense.put("Fine", "72");
		parseKindsExpense.put("EatOut", "73");
		parseKindsExpense.put("Professional", "74");
		parseKindsExpense.put("Gym", "75");
		parseKindsExpense.put("Education", "76");
		parseKindsExpense.put("Stationary", "77");
		parseKindsExpense.put("Loan Pmt", "78");
		parseKindsExpense.put("Mortgage", "79");
		parseKindsExpense.put("Home Improvement", "80");
		parseKindsExpense.put("Maintenance", "81");
		parseKindsExpense.put("Electricity", "82");
		parseKindsExpense.put("Gas", "83");
		parseKindsExpense.put("Sewage", "84");
		parseKindsExpense.put("Water", "85");
		parseKindsExpense.put("Waste", "86");
		
		
		parseKindsIncome.put("", "");
		parseKindsIncome.put("Work Income", "1");
		parseKindsIncome.put("Interest income", "2");
		parseKindsIncome.put("Parttime Earnings", "3");
		parseKindsIncome.put("Bonus Income", "4");
		parseKindsIncome.put("Gift Income", "5");
		parseKindsIncome.put("Other Income", "6");
		parseKindsIncome.put("Investment Income", "7");
		parseKindsIncome.put("Grifo", "8");
		parseKindsIncome.put("Found", "9");
		parseKindsIncome.put("Mom", "10");
		parseKindsIncome.put("Cash", "11");
		parseKindsIncome.put("Credit", "12");
		parseKindsIncome.put("Export", "13");
		parseKindsIncome.put("Huancayo", "14");
		parseKindsIncome.put("Luz Rodrigues", "15");
		parseKindsIncome.put("Loan", "16");
		parseKindsIncome.put("Esperanza Romero", "17");
		parseKindsIncome.put("Juanita Minchola", "18");
		parseKindsIncome.put("House Income", "19");
		
		parseAccount.put("CASH", "1");
		parseAccount.put("Saving (PNC)", "2");
		parseAccount.put("Checking (PNC)", "3");
		parseAccount.put("bcp Dollars", "6");
		parseAccount.put("Credit (PNC)", "7");
		parseAccount.put("NWMF", "8");
		parseAccount.put("QR", "9");
		parseAccount.put("", "9");
		parseAccount.put("Macy's", "10");
		parseAccount.put("Credit (QR)", "11");
		parseAccount.put("Growth (PNC)", "12");
		parseAccount.put("Family", "13");
		parseAccount.put("Home Equity", "14");
		parseAccount.put("IRA", "15");
		
		parseItem.put("Default", "1");
		parseItem.put("MyHouse", "6");
		
	}
	
	public static HashMap<String, String> getParseItem() {
		return parseItem;
	}

	public static void main(String[] args){
		
		System.out.println(parseKindIncome.get("Humita Sales"));
	}
	
	public HashMap<String, String> getParseAccount(){
		return parseAccount;
	}
	
	public HashMap<String, String> getParseKind(){
		if(expenseOrIncome.equals("Expense")){
			return parseKindExpense;
		} else {
			return parseKindIncome;
		}
	}
	
	public HashMap<String, String> getParseKinds(){
		if(expenseOrIncome.equals("Expense")){
			return parseKindsExpense;
		} else {
			return parseKindsIncome;
		}
	} 
	
	
	public String getExpenseOrIncome() {
		return expenseOrIncome;
	}



	public void setExpenseOrIncome(String expenseOrIncome) {
		this.expenseOrIncome = expenseOrIncome;
	}



	public static String parseDate(String date){
		DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date targetDate;
		String formattedDate = "";
		try {
			targetDate = originalFormat.parse(date);
			
			formattedDate = targetFormat.format(targetDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}
	
	public static String parseTimeStamp(String date){
		DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date targetDate;
		String formattedDate = "";
		try {
			targetDate = originalFormat.parse(date);
			
			formattedDate = targetFormat.format(targetDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}
	
}
