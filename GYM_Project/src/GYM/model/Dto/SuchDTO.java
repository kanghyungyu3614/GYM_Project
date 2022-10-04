package GYM.model.Dto;

public class SuchDTO {
	private int such_no;
	private int mem_no;
	private String mem_start;
	private String mem_end;
	private int pt_no;
	private String pt_date;
	private int body_no;
	private String body_date;
	
	public SuchDTO() {
		
	}
	
	public SuchDTO(int such_no, int mem_no, String mem_start, String mem_end, int pt_no, String pt_date, int body_no,
			String body_date) {
		super();
		this.such_no = such_no;
		this.mem_no = mem_no;
		this.mem_start = mem_start;
		this.mem_end = mem_end;
		this.pt_no = pt_no;
		this.pt_date = pt_date;
		this.body_no = body_no;
		this.body_date = body_date;
	}

	public int getSuch_no() {
		return such_no;
	}

	public void setSuch_no(int such_no) {
		this.such_no = such_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_start() {
		return mem_start;
	}

	public void setMem_start(String mem_start) {
		this.mem_start = mem_start;
	}

	public String getMem_end() {
		return mem_end;
	}

	public void setMem_end(String mem_end) {
		this.mem_end = mem_end;
	}

	public int getPt_no() {
		return pt_no;
	}

	public void setPt_no(int pt_no) {
		this.pt_no = pt_no;
	}

	public String getPt_date() {
		return pt_date;
	}

	public void setPt_date(String pt_date) {
		this.pt_date = pt_date;
	}

	public int getBody_no() {
		return body_no;
	}

	public void setBody_no(int body_no) {
		this.body_no = body_no;
	}

	public String getBody_date() {
		return body_date;
	}

	public void setBody_date(String body_date) {
		this.body_date = body_date;
	}
	
}
