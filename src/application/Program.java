package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args ) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>(); //lista do tipo generico
		
		System.out.print(" Enter the number of tax payers:");
		int N = sc.nextInt();
		
		
		
		for(int i = 1; i <= N; i++) {
			
			System.out.println(" Tax payer #"+ i + "data: ");
			System.out.print("Individual or company (i/c)?");
			char type = sc.next().charAt(0); // char 0 para pegar a primeira letra que le no caso vai ser 0 mesmo
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine(); //next so aceita uma palavra sem espaço
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if (type == 'i') { 
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
				//Individual x = new Individual(name, anualIncome, healthExpenditures);
				//list.add(x);
			}
			else {
				System.out.println("Numer of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
		    }
			
	}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}
}
