package GYM.view;

import java.util.ArrayList;
import java.util.Scanner;

import GYM.controller.BodyController;
import GYM.controller.CheckController;
import GYM.controller.Controller;
import GYM.controller.MembershipController;
import GYM.controller.PtMemberController;
import GYM.controller.RecordController;
import GYM.model.Dto.CheckDTO;
import GYM.controller.SuchController;
import GYM.model.Dto.BodyDTO;
import GYM.model.Dto.MembershipDTO;
import GYM.model.Dto.PtMemberDTO;
import GYM.model.Dto.RecordDTO;
import GYM.model.Dto.RegistDTO;

public class View {
	
	Scanner scanner = new Scanner(System.in);
	//컨트롤러 추가 시작
	Controller control = new Controller();
	MembershipController memcontrol = new MembershipController();
	PtMemberController ptmemcontrol= new PtMemberController();
	BodyController bodycontrol = new BodyController();
	SuchController suchcontrol = new SuchController();
	CheckController checkcontrol = new CheckController();
	RecordController recordController = new RecordController();
	String name;
	String id;
	String pw;
	String login_name;
	String login_id;
	
	//컨트롤러 추가 끝
	public static void main(String[] args) {
		
		View view = new View();
		
		view.menu();
		
	}
	
	// 회원가입
	void regist() {
		
		System.out.println("이름을 입력해주세요 : ");
		String name = scanner.next();
		System.out.println("아이디를 입력해주세요 : ");
		String id = scanner.next();
		System.out.println("패스워드를 입력해주세요 : ");
		String pw = scanner.next();
		boolean result = control.regist(name, id, pw);
		
		if(result == true) {
			System.out.println("회원가입에 성공했습니다!!");
		} else if(result == false) {
			System.out.println("회원가입에 실패했습니다!!");
		}
	}
	
	void menu() {
		
		while( true ) {
			System.out.println("1.로그인 2.회원가입");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();
				System.out.println("1.로그인 2.회원가입");
			}
			
			int btn = scanner.nextInt();
			
			if(btn == 1) { // 로그인
				System.out.println("아이디를 입력하세요 : ");
				id = scanner.next();
				System.out.println("패스워드를 입력하세요 : ");
				pw = scanner.next();
				
				int result = login(id, pw);
				registRead(id);
				loginSave(login_name, login_id);
				idSave(login_id);
				if(result == 1) {
					System.out.println("로그인에 성공했습니다!!");
					user();
				} else if (result == 2) {
					System.out.println("패스워드가 일치하지 않습니다!!");
				} else if (result == 3) {
					System.out.println("존재하지 않는 아이디입니다!!");
				} else if (result == 4) {
					System.out.println("로그인에 성공했습니다!!");
					admin();
				}
			} else if(btn == 2) {
				
				View view = new View();
				
				view.regist();
				
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
				System.out.println("이름을 입력해주세요. : ");
				String mem_name = scanner.next();
				System.out.println("시작날짜를 입력해주세요. : ");
				String mem_start = scanner.next();
				System.out.println("마감날짜를 입력해주세요. : ");
				String mem_end = scanner.next();
				System.out.println("특이사항을 입력해주세요. : ");
				String mem_comment = scanner.next();
				scanner.nextLine();
				
				boolean result = memCreate(mem_name, mem_start, mem_end, mem_comment);
				if(result) { System.out.println("회원등록이 완료되었습니다!!"); }
				else if(result == false) { System.out.println("회원등록 실패!!"); }
			} else if(btn3 == 2) {
				System.out.println("이름을 입력해주세요. : ");
				String pt_name = scanner.next();
				System.out.println("전화번호를 입력해주세요. : ");
				String pt_phone = scanner.next();
				System.out.println("등록날짜를 입력해주세요. : ");
				String pt_date = scanner.next();
				boolean result = ptMemberCreate(pt_name,pt_phone,pt_date);
				if(result) {
					System.out.println("등록이 완료되었습니다.");
				}
				else {System.out.println("등록이 실패했습니다.");}				
				
			} else if(btn3 == 3) { 
				System.out.println("이름을 입력해주세요. : ");
				String body_name = scanner.next();
				System.out.println("날짜를 지정해 주세요. : ");
				String body_date = scanner.next();
				System.out.println("장소를 지정해 주세요. : ");
				String body_place = scanner.next();
				System.out.println("특이사항을 알려주세요. : ");
				String body_comment = scanner.next();
				boolean result = bodyReservationCreate(body_name,body_date,body_place,body_comment);
				if(result) {
					System.out.println("등록이 완료되었습니다.");
				}
				else {System.out.println("등록이 실패했습니다.");}		
			} else if(btn3 == 4) {
				break;
			}
		}
		
	}
	
	public void management() {
		
		while(true) {
			System.out.println("\t   ☆ 회원관리페이지 ☆");
			System.out.println("===================================");
			System.out.println("1.회원권관리 2.pt회원관리 3.운동관리 4.뒤로가기 5.출결관리");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();
				System.out.println("\t   ☆ 회원관리페이지 ☆");
				System.out.println("===================================");
				System.out.println("1.회원권관리 2.pt회원관리 3.운동관리 4.뒤로가기 5.출결관리");
			}
			
			int btn4 = scanner.nextInt();
			
			if(btn4 == 1) {
				memRead();
				
				System.out.println("1.수정하기 2.삭제하기 3.뒤로가기");
				
				while(!scanner.hasNextInt()) { 
					scanner.next();				
					System.out.println("1.수정하기 2.삭제하기 3.뒤로가기");
				}
				
				int btn5 = scanner.nextInt();
				
				if(btn5 == 1) {
					System.out.println("수정할 번호를 입력하세요 : ");
					
					while(!scanner.hasNextInt()) { 
						scanner.next();				
						System.out.println("수정할 번호를 입력하세요 : ");
					}
					
					int mem_no = scanner.nextInt();
					System.out.println("이름을 입력해주세요. : ");
					String mem_name = scanner.next();
					System.out.println("시작날짜를 입력해주세요. : ");
					String mem_start = scanner.next();
					System.out.println("마감날짜를 입력해주세요. : ");
					String mem_end = scanner.next();
					System.out.println("특이사항을 입력해주세요. : ");
					String mem_comment = scanner.next();
					scanner.nextLine();
					
					boolean result = memUpdate(mem_no, mem_name, mem_start, mem_end, mem_comment);
					
					if(result == true) {
						System.out.println("회원수정이 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원수정 실패!!");
					}
				} else if(btn5 == 2) {
					System.out.println("삭제할 번호를 입력하세요 : ");
					int mem_no = scanner.nextInt();
					boolean result = memDelete(mem_no);
					
					if(result == true) {
						System.out.println("회원삭제가 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원삭제 실패!!");
					}
				}
				
			} else if(btn4 == 2) { //ptMemberRead
				ptMemRead();
				
				System.out.println("1.수정하기 2.삭제하기 3.뒤로가기");
				
				while(!scanner.hasNextInt()) { 
					scanner.next();				
					System.out.println("1.로그인");
				}
				
				int btn5 = scanner.nextInt();
				
				if(btn5 == 1) {
					System.out.println("수정할 번호를 입력하세요 : ");
					
					while(!scanner.hasNextInt()) { 
						scanner.next();				
						System.out.println("수정할 번호를 입력하세요 : ");
					}
					
					int pt_no = scanner.nextInt();
					System.out.println("이름을 입력해주세요. : ");
					String pt_name = scanner.next();
					System.out.println("전화번호를 입력해주세요. : ");
					String pt_phone = scanner.next();
					System.out.println("등록날짜를 입력해주세요. : ");
					String pt_date = scanner.next();
					scanner.nextLine();

					boolean result = ptMemUpdate(pt_no,pt_name,pt_phone,pt_date);
					
					if(result == true) {
						System.out.println("회원수정이 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원수정 실패!!");
					}
				} else if(btn5 == 2) {
					System.out.println("삭제할 번호를 입력하세요 : ");
					int pt_no = scanner.nextInt();
					boolean result = ptMemDelete(pt_no);
					
					if(result == true) {
						System.out.println("회원삭제가 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원삭제 실패!!");
					}
				}
			} else if(btn4 == 3) {
				bodyRead();
				
				System.out.println("1.수정하기 2.삭제하기 3.뒤로가기");
				
				while(!scanner.hasNextInt()) { 
					scanner.next();				
					System.out.println("1.수정하기 2.삭제하기 3.뒤로가기");
				}
				
				int btn5 = scanner.nextInt();
				
				if(btn5 == 1) {
					System.out.println("수정할 번호를 입력하세요 : ");
					
					while(!scanner.hasNextInt()) { 
						scanner.next();				
						System.out.println("수정할 번호를 입력하세요 : ");
					}
					
					int body_no = scanner.nextInt();
					System.out.println("이름을 입력해주세요. : ");
					String body_name = scanner.next();
					System.out.println("날짜를 입력해주세요. : ");
					String body_date = scanner.next();
					System.out.println("장소를 입력해주세요. : ");
					String body_place = scanner.next();
					System.out.println("특이사항를 입력해주세요. : ");
					String body_comment = scanner.next();
					scanner.nextLine();

					boolean result = bodyUpdate(body_no,body_name,body_date,body_place,body_comment);
					
					if(result == true) {
						System.out.println("회원수정이 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원수정 실패!!");
					}
				} else if(btn5 == 2) {
					System.out.println("삭제할 번호를 입력하세요 : ");
					int body_no = scanner.nextInt();
					boolean result = bodyDelete(body_no);
					
					if(result == true) {
						System.out.println("회원삭제가 완료되었습니다!!");
					} else if(result == false){
						System.out.println("회원삭제 실패!!");
					}
				}
			} else if(btn4 == 4) {
				break;
			} else if(btn4 == 5) {
			   System.out.println("출결관리페이지입니다.");
			   CheckRead();
			   
				System.out.println("1.추가하기 2.뒤로가기");
				
				while(!scanner.hasNextInt()) { 
					scanner.next();				
					System.out.println("1.추가하기 2.뒤로가기");
				}
				
				int btn5 = scanner.nextInt();
				
				if(btn5 == 1) {
					System.out.println("이름을 입력해주세요. : ");
					String check_name = scanner.next();
					System.out.println("날짜를 입력해주세요. : ");
					String check_date = scanner.next();
					scanner.nextLine();

					boolean result = checkCreate(check_name,check_date);
					
					if(result == true) {
						System.out.println("출석체크가 완료되었습니다!!");
					} else if(result == false){
						System.out.println("출석체크 실패!!");
					}
				}
			}
		}
		 
	}
	
	void user() {
		
		while(true) {
			System.out.println("1.일정조회 2.마이페이지 3.운동기록 4.로그아웃");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();				
				System.out.println("1.일정조회 2.마이페이지 3.운동기록 4.로그아웃");
			}
			
			int btn2 = scanner.nextInt();
			
			if(btn2 == 1) {
				registRead(id);
				loginSave(login_name, login_id);
				idSave(login_id);
				suchMemRead();
				suchPtRead();
				suchBodyRead();
			} else if(btn2 == 2) {
				mypage();
			} else if(btn2 == 3) {
				record();	// 운동기록
			} else if(btn2 == 4) {
				break;
			}
		}
	}
	
	void mypage() {

		while(true) {
			System.out.println("1.회원수정 2.회원탈퇴 3.뒤로가기");
			
			while(!scanner.hasNextInt()) { 
				scanner.next();
				System.out.println("1.회원수정 2.회원탈퇴 3.뒤로가기");
			}

			int btn6 = scanner.nextInt();
			
			if(btn6 == 1) {
				
				System.out.println("이름 : ");
				String change_name = scanner.next();
				System.out.println("아이디 : ");
				String change_id = scanner.next();
				System.out.println("패스워드 : ");
				String change_pw = scanner.next();
				
				boolean result = changeRegist(change_name, change_id, change_pw);
				
				if(result == true) {
					System.out.println("회원수정 완료!!");
					loginSave(change_id, change_pw);
					registRead(change_id);
					id = change_id;
				} else if(result == false){
					System.out.println("회원수정 실패!!");
				}
				
			} else if(btn6 == 2) {
				
				System.out.println("1.회원탈퇴 2.뒤로가기");
				
				while(!scanner.hasNextInt()) { 
					scanner.next();
					System.out.println("1.회원탈퇴 2.뒤로가기");
				}

				int btn8 = scanner.nextInt();
				
				if(btn8 == 1) {
					boolean result = deleteRegist(id);
					if(result == true) {
						System.out.println("회원삭제가 완료되었습니다.");
						menu();
					} else if(result == false) {
						System.out.println("회원삭제가 실패하였습니다.");
					}
				} else if(btn8 == 2) {
					while(true) {
						break;
					}
				}
				
			} else if(btn6 == 3) {
				break;
			}

		}
	}
	// record 운동 기록  start
	void record() {
		while(true) {
			System.out.println("1.운동기록추가 2.운동기록조회 3.뒤로가기");
			int btn7 = scanner.nextInt();
			
			if(btn7 == 1) {
				System.out.println("이름을 입력해주세요. : ");
				String record_name = scanner.next();
				System.out.println("날짜을 입력해주세요. : ");
				String record_date = scanner.next();
				System.out.println("체지방을 입력해주세요. : ");
				String record_weight = scanner.next();
				System.out.println("오늘의 루틴을 입력해주세요.. : ");
				String record_routine = scanner.next();
				
				
				recordController.create(record_name, record_date, record_routine, record_weight);
			} else if (btn7 == 2) {			
				call();
			} else if (btn7 == 3) {
				break;
			}
			
		}
		
		
		
	}
	// 운동기록 end 
	void call() {
		System.out.println("==========================================================");
		System.out.println("회원번호\t이름\t날짜\t\t\t몸무게\t루틴");
		System.out.println("==========================================================");
		
		RecordRead();
	}
	// 로그인정보 넘겨서 저장
	public void loginSave(String login_name, String login_id) {
		suchcontrol.login_save(login_name, login_id);
		return;
	}
	public void idSave(String login_id) {
		control.id_save(login_id);
		return;
	}
	
	//create start
	public boolean memCreate(String mem_name, String mem_start, String mem_end, String mem_comment) {		
		return memcontrol.create(mem_name, mem_start, mem_end, mem_comment);
	}
	
	public boolean ptMemberCreate(String pt_name,String pt_phone,String pt_date) {
		return ptmemcontrol.create(pt_name,pt_phone,pt_date);
	}
	
	public boolean bodyReservationCreate( String body_name, String body_date, String body_place, String body_comment) {
		return bodycontrol.create( body_name, body_date, body_place, body_comment);
	}
	
	public boolean checkCreate(String check_name, String check_date) {
		return checkcontrol.create(check_name,check_date);
	}
	// 운동관리 
	public boolean recordCreate(String rd_name, String rd_date, String rd_routine, String rd_weight ) {
		return recordController.create(rd_name, rd_date, rd_routine, rd_weight);
	}
	
	//create end
	
	
	// update start
	public boolean memUpdate(int mem_no, String mem_name, String mem_start, String mem_end, String mem_comment ) {
		return memcontrol.update(mem_no, mem_name, mem_start, mem_end, mem_comment );
	}
	
	public boolean ptMemUpdate(int pt_no,String pt_name,String pt_phone, String pt_date) {
		return ptmemcontrol.update(pt_no,pt_name,pt_phone,pt_date);
	}
	
	public boolean bodyUpdate(int body_no,String body_name, String body_date, String body_place, String body_comment) {
		return bodycontrol.update(body_no, body_name, body_date, body_place, body_comment);
	}
	
	public boolean changeRegist(String change_name, String change_id, String change_pw) {
		return control.update(change_name, change_id, change_pw);
	}
	// update end
	
	
	// delete start
	
	public boolean memDelete(int mem_no) {
		return memcontrol.delete(mem_no);
	}
	
	public boolean ptMemDelete(int pt_no) {
		return ptmemcontrol.delete(pt_no);
	}
	
	public boolean bodyDelete(int body_no) {
		return bodycontrol.delete(body_no);
	}
	
	public boolean deleteRegist(String id) {
		return control.delete(id);
	}
	// delete end
	
	
	//read start
	public void memRead() {
		ArrayList<MembershipDTO> mem_list = memcontrol.read();
		System.out.println("회원번호\t회원이름\t\t시작날짜\t\t마감날짜\t\t특이사항");
		for(MembershipDTO dto : mem_list) {
			System.out.print(dto.getMem_no()+"\t");
			System.out.print(dto.getMem_name()+"\t\t");
			System.out.print(dto.getMem_start()+"\t");
			System.out.print(dto.getMem_end()+"\t");
			System.out.println(dto.getMem_comment());
		}
	}
	
	public void ptMemRead() {
		ArrayList<PtMemberDTO> pt_mem_list = ptmemcontrol.read();
		System.out.println("회원번호\t회원이름\t전화번호\t     등록날짜");
		for(PtMemberDTO dto : pt_mem_list) {
			System.out.print(dto.getPt_no()+"\t");
			System.out.print(dto.getPt_name()+"\t");
			System.out.print(dto.getPt_phone()+"  ");
			System.out.println(dto.getPt_date()+"\t");
		}	
	}	
	
	public void registRead(String id) {
		ArrayList<RegistDTO> regist_list = control.regist_read(id);
		for(RegistDTO dto : regist_list) {
			login_id = dto.getRegist_id();
			login_name = dto.getRegist_name();
		}
	}

	public void bodyRead() {
		ArrayList<BodyDTO> body_list = bodycontrol.read();
		System.out.println("회원번호\t이름\t날짜\t\t장소\t특이사항");
		for(BodyDTO dto : body_list) {
			System.out.print(dto.getBody_no()+"\t");
			System.out.print(dto.getBody_name()+"\t");
			System.out.print(dto.getBody_date()+"\t");
			System.out.print(dto.getBody_place()+"\t");
			System.out.println(dto.getBody_comment()+"\t");
		}		
		
	}
	
	public void CheckRead() {
		ArrayList<CheckDTO> check_list = checkcontrol.read();
		System.out.println("회원번호\t이름\t날짜");
		for(CheckDTO dto : check_list) {
			System.out.print(dto.getCk_no()+"\t");
			System.out.print(dto.getCk_name()+"\t");
			System.out.println(dto.getCk_date()+"\t");
		}

	}
	
	public void suchMemRead() {
		ArrayList<MembershipDTO> such_mem_list = suchcontrol.mem_read();
		System.out.println("=============================");
		System.out.println("☆ " + login_name + "님의 페이지 ☆");
		System.out.println("=============================");
		for(MembershipDTO dto : such_mem_list) {
			System.out.println("※ 회원권");
			System.out.print("시작일 : ");
			System.out.println(dto.getMem_start());
			System.out.print("종료일 : ");
			System.out.println(dto.getMem_end());
		}
	}
	public void suchPtRead() {
		ArrayList<PtMemberDTO> such_pt_list = suchcontrol.pt_read();
		System.out.println("=============================");
		for(PtMemberDTO dto : such_pt_list) {
			System.out.println("※ PT");
			System.out.print("시작일 : ");
			System.out.println(dto.getPt_date());
		}
	}
	public void suchBodyRead() {
		ArrayList<BodyDTO> such_body_list = suchcontrol.body_read();
		System.out.println("=============================");
		System.out.println("※ 바디프로필");
		for(BodyDTO dto : such_body_list) {
			System.out.print("장소 : ");
			System.out.println(dto.getBody_place());
			System.out.print("예약일 :");
			System.out.println(dto.getBody_date());
		}
		System.out.println("=============================");
	}
	
	public void RecordRead() {
		ArrayList<RecordDTO> record_list = recordController.read();
		for(RecordDTO dto : record_list ) {
			System.out.print(dto.getRd_no()+"\t");
			System.out.print(dto.getRd_name()+"\t");
			System.out.print(dto.getRd_date()+"\t");
			System.out.print(dto.getRd_weight()+"\t");
			System.out.println(dto.getRd_routine());
		} 
	}
	
	//read end
}
