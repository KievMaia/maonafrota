package br.com.kiev.maonafrota;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teste {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String date = "16-08-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(formatter.format(localDate));

		

	}

}
