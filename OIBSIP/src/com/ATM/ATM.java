package com.ATM;

import java.util.Scanner;

public class ATM {

	public static void Atm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name");
		String name = sc.nextLine();
		System.out.println("Welcome to:" + name);
		System.out.println("Enter ATM Name");
		String ATM = sc.nextLine();
		System.out.println("weelcome to:" + ATM);
		System.out.println("Enter the ATM pin number");
		int PIN = sc.nextInt();
		System.out.println("your PIN Number is:" + PIN);

		double balance = 50000;
		boolean Transcation = true;
		while (Transcation) {
			System.out.println("1 Deposit");
			System.out.println("2 Withdrawn");
			System.out.println("3 Balance Enquiry");
			System.out.println("4 Quit");
			int choose = sc.nextInt();
			if (choose == 1) {
				System.out.println("Enter your Deposit Amount");
				double deposit = sc.nextInt();
				if (deposit > 0) {
					balance = balance + deposit;
					System.out.println("Deposit successful. Updated balance: " + balance);
				} else {
					System.out.println("Invalid deposit amount. Please try again.");
				}
			} else if (choose == 2) {
				System.out.println("Enter your Withdrawn Amount");
				int withdrawan = sc.nextInt();
				if (withdrawan > 0 && withdrawan <= balance) {
					balance = balance - withdrawan;
					System.out.println("Withdrawal successful. Remaining balance:" + balance);
				} else {
					System.out.println("Invalid withdrawal amount or insufficient funds. Please try again.");
				}
			} else if (choose == 3) {
				System.out.println("Your account balance is:" + balance);
			}

			else if (choose == 4) {
				System.out.println("Thanks for visiting!!...");
				break;
			}

		}
	}

	public static void main(String[] args) {

		Atm();
	}

}
