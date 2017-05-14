package com.essamine.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {

	
	public static java.sql.Date StringDateToSqlDate(String stringDate) {
		SimpleDateFormat reFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.sql.Date sqlDate = null;

		try {
			sqlDate = new java.sql.Date(reFormat.parse(stringDate).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sqlDate;
	}
}
