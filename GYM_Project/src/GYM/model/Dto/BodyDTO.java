package GYM.model.Dto;

public class BodyDTO {
	private int body_no;
	private String body_name;
	private String body_place;
	private String body_comment;
	
	public BodyDTO() {}

	public BodyDTO(int body_no, String body_name, String body_place, String body_comment) {
		super();
		this.body_no = body_no;
		this.body_name = body_name;
		this.body_place = body_place;
		this.body_comment = body_comment;
	}

	public int getBody_no() {
		return body_no;
	}

	public void setBody_no(int body_no) {
		this.body_no = body_no;
	}

	public String getBody_name() {
		return body_name;
	}

	public void setBody_name(String body_name) {
		this.body_name = body_name;
	}

	public String getBody_place() {
		return body_place;
	}

	public void setBody_place(String body_place) {
		this.body_place = body_place;
	}

	public String getBody_comment() {
		return body_comment;
	}

	public void setBody_comment(String body_comment) {
		this.body_comment = body_comment;
	}
	
	
}
