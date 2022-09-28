package GYM.model.Dto;

public class PtMemberDTO {
    private int pt_no;
    private String pt_name;
    private String pt_phone;
    private String pt_date;
   
    public PtMemberDTO() {}

    public PtMemberDTO(int pt_no, String pt_name, String pt_phone, String pt_date) {
		super();
		this.pt_no = pt_no;
		this.pt_name = pt_name;
		this.pt_phone = pt_phone;
		this.pt_date = pt_date;
    }

	public int getPt_no() {
		return pt_no;
	}
	
	public void setPt_no(int pt_no) {
		this.pt_no = pt_no;
	}
	
	public String getPt_name() {
		return pt_name;
	}
	
	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}
	
	public String getPt_phone() {
		return pt_phone;
	}
	
	public void setPt_phone(String pt_phone) {
		this.pt_phone = pt_phone;
	}
	
	public String getPt_date() {
		return pt_date;
	}
	
	public void setPt_date(String pt_date) {
		this.pt_date = pt_date;
	}
	   
   
   
}
