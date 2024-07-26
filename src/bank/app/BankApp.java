package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1. 계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());
			if(selectNo == 1) {
				createAccount();
			}else if(selectNo == 2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if(selectNo == 4) {
				widthdraw();
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	private static void createAccount() {
		System.out.println("------------------ 계좌생성 ------------------");
		System.out.print("계좌번호: ");
		String tmp_ano = scanner.nextLine();
		System.out.print("계좌주: ");
		String tmp_own = scanner.nextLine();
		System.out.print("초기입금액: ");
		int tmp_bal = Integer.parseInt(scanner.nextLine());
		
		accounts.add(new Account(tmp_ano, tmp_own, tmp_bal));
		
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	private static void accountList() {
		System.out.println("------------------ 계좌목록 ------------------");
		for(Account acc : accounts) {
			System.out.println(acc.getAno()+" "+acc.getOwner()+" "+acc.getBalance());
		}
	}
	private static void deposit() {
		System.out.println("------------------- 예금 -------------------");
		System.out.print("계좌번호: ");
		String tmp_ano = scanner.nextLine();
		System.out.print("예금액: ");
		int tmp_bal = Integer.parseInt(scanner.nextLine());
		findAccount(tmp_ano).setBalance(findAccount(tmp_ano).getBalance() + tmp_bal);
		
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	private static void widthdraw() {
		System.out.println("------------------- 출금 -------------------");
		System.out.print("계좌번호: ");
		String tmp_ano = scanner.nextLine();
		System.out.print("출금액: ");
		int tmp_bal = Integer.parseInt(scanner.nextLine());
		findAccount(tmp_ano).setBalance( findAccount(tmp_ano).getBalance() - tmp_bal);
		
		System.out.println("결과: 출금이 성공되었습니다.");
	}
	private static Account findAccount(String ano) {
		for(Account acc : accounts) {
			if(acc.getAno().equals(ano)) {
				return acc;
			}
		}
		System.out.println("계좌가 존재하지 않습니다.");
		return null;
	}
}
