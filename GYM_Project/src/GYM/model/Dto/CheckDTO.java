package GYM.model.Dto;


public class CheckDTO {
    private int ck_no;
    private String ck_name;
    private String ck_date;
    
    CheckDTO(){}

	public CheckDTO(int ck_no, String ck_name, String ck_date) {
		super();
		this.ck_no = ck_no;
		this.ck_name = ck_name;
		this.ck_date = ck_date;
	}

	public int getCk_no() {
		return ck_no;
	}

	public void setCk_no(int ck_no) {
		this.ck_no = ck_no;
	}

	public String getCk_name() {
		return ck_name;
	}

	public void setCk_name(String ck_name) {
		this.ck_name = ck_name;
	}

	public String getCk_date() {
		return ck_date;
	}

	public void setCk_date(String ck_date) {
		this.ck_date = ck_date;
	}
    
}
