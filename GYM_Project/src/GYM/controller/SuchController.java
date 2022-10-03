package GYM.controller;

import java.util.ArrayList;

import GYM.model.Dao.SuchDAO;
import GYM.model.Dto.SuchDTO;

public class SuchController {
	
	public ArrayList<SuchDTO> read(){
		return SuchDAO.getInstance().read();
	}
	
}
