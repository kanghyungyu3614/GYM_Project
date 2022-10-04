package GYM.model.Dto;

public class RegistDTO {
	
	int regist_no;
	String regist_name;
	String regist_id;
	String regist_pw;
	
	public RegistDTO() {
		
	}

	public RegistDTO(int regist_no, String regist_name, String regist_id, String regist_pw) {
		super();
		this.regist_no = regist_no;
		this.regist_name = regist_name;
		this.regist_id = regist_id;
		this.regist_pw = regist_pw;
	}

	public int getRegist_no() {
		return regist_no;
	}

	public void setRegist_no(int regist_no) {
		this.regist_no = regist_no;
	}

	public String getRegist_name() {
		return regist_name;
	}

	public void setRegist_name(String regist_name) {
		this.regist_name = regist_name;
	}

	public String getRegist_id() {
		return regist_id;
	}

	public void setRegist_id(String regist_id) {
		this.regist_id = regist_id;
	}

	public String getRegist_pw() {
		return regist_pw;
	}

	public void setRegist_pw(String regist_pw) {
		this.regist_pw = regist_pw;
	}
	
}
