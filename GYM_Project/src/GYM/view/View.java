package GYM.view;

import java.util.Scanner;

import GYM.controller.Controller;

public class View {
	
	Scanner scanner = new Scanner(System.in);
	Controller control = new Controller();

	public static void main(String[] args) {
		
		View view = new View();
		
		view.regist();
		view.menu();
		
	}
	
	void regist() {
		String admin_id = "admin";
		String admin_pw = "admin";
		
		control.regist(admin_id, admin_pw);
		return;
	}
	
	void menu() {
		
		while( true ) {
			System.out.println("1.로그인");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();				
				System.out.println("1.로그인");
			}
			
			int btn = scanner.nextInt();
			
			if(btn == 1) {
				
				System.out.println("아이디를 입력하세요 : ");
				String id = scanner.next();
				System.out.println("패스워드를 입력하세요 : ");
				String pw = scanner.next();
				
				int result = login(id, pw);
				System.out.println(result);
				if(result == 1) {
					System.out.println("로그인에 성공했습니다!!");
					admin();
				} else if (result == 2) {
					System.out.println("패스워드가 일치하지 않습니다!!");
				} else if (result == 3) {
					System.out.println("존재하지 않는 아이디입니다!!");
				}
			}
		}
		
	}
	
	int login(String id, String pw) {
		return control.login(id, pw);
	}
	
	void admin() {
		
		while(true) {
			System.out.println("1.판매상품 2.회원관리 3.로그아웃");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();				
				System.out.println("1.판매상품 2.회원관리 3.로그아웃");
			}
			
			int btn2 = scanner.nextInt();
			
			if(btn2 == 1) {
				product();
			} else if(btn2 == 2) {
				management();
			} else if(btn2 == 3) {
				break;
			}
		}
		
	}
	
	void product() {
		
		while(true) {
			System.out.println("\t   ☆ 판매상품페이지 ☆");
			System.out.println("===================================");
			System.out.println("1.회원권등록 2.pt예약 3.바디프로필 4.뒤로가기");

			while(!scanner.hasNextInt()) { 
				scanner.next();
				System.out.println("\t   ☆ 판매상품페이지 ☆");
				System.out.println("===================================");
				System.out.println("1.회원권등록 2.pt예약 3.바디프로필 4.뒤로가기");
			}
			
			int btn3 = scanner.nextInt();
			
			if(btn3 == 1) {
				
			} else if(btn3 == 2) {
				
			} else if(btn3 == 3) {
				
			} else if(btn3 == 4) {
				break;
			}
		}
		
	}
	
	void management() {
		
		while(true) {
			System.out.println("\t   ☆ 회원관리페이지 ☆");
			System.out.println("===================================");
			System.out.println("1.출결관리 2.운동관리 3.pt회원관리 4.뒤로가기");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();
				System.out.println("\t   ☆ 회원관리페이지 ☆");
				System.out.println("===================================");
				System.out.println("1.출결관리 2.운동관리 3.pt회원관리 4.뒤로가기");
			}
			
			int btn4 = scanner.nextInt();
			
			if(btn4 == 1) {
				
			} else if(btn4 == 2) {
				
			} else if(btn4 == 3) {
				
			} else if(btn4 == 4) {
				break;
			}
		}
		
	}
	
}
