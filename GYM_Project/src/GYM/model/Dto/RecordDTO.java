package GYM.model.Dto;

import java.util.Objects;

public class RecordDTO {
	private int rd_no;
	private String rd_name;
	private String rd_date;
	private String rd_routine;
	private String rd_weight;
	
	RecordDTO(){}

	public RecordDTO(int rd_no, String rd_name, String rd_date, String rd_routine, String rd_weight) {
		super();
		this.rd_no = rd_no;
		this.rd_name = rd_name;
		this.rd_date = rd_date;
		this.rd_routine = rd_routine;
		this.rd_weight = rd_weight;
	}

	public int getRd_no() {
		return rd_no;
	}

	public void setRd_no(int rd_no) {
		this.rd_no = rd_no;
	}

	public String getRd_name() {
		return rd_name;
	}

	public void setRd_name(String rd_name) {
		this.rd_name = rd_name;
	}

	public String getRd_date() {
		return rd_date;
	}

	public void setRd_date(String rd_date) {
		this.rd_date = rd_date;
	}

	public String getRd_routine() {
		return rd_routine;
	}

	public void setRd_routine(String rd_routine) {
		this.rd_routine = rd_routine;
	}

	public String getRd_weight() {
		return rd_weight;
	}

	public void setRd_weight(String rd_weight) { 
		this.rd_weight = rd_weight;
	}
	
} // class end
