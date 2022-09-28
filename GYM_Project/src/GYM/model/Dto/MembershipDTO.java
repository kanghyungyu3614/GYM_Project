package GYM.model.Dto;

public class MembershipDTO {
	private int mem_no;
	private String mem_name;
	private String mem_start;
	private String mem_end;
	private String mem_comment;
	
	public MembershipDTO() {}

	public MembershipDTO(int mem_no, String mem_name, String mem_start, String mem_end, String mem_comment) {
		super();
		this.mem_no = mem_no;
		this.mem_name = mem_name;
		this.mem_start = mem_start;
		this.mem_end = mem_end;
		this.mem_comment = mem_comment;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
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

	public String getMem_comment() {
		return mem_comment;
	}

	public void setMem_comment(String mem_comment) {
		this.mem_comment = mem_comment;
	}
	
	
}
