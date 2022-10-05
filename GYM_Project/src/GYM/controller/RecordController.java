package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.RecordDAO;
import GYM.model.Dto.RecordDTO;

public class RecordController{
	
	public boolean create( String record_name, String record_date, String record_routine, String record_weight ) {
		RecordDTO exercise_dto = new RecordDTO(0 , record_name, record_date, record_routine, record_weight  );
		return RecordDAO.getInstance().create(exercise_dto);
	}
	
	public ArrayList<RecordDTO> read() {
		return RecordDAO.getInstance().read();
	}
	
	
} // class end




