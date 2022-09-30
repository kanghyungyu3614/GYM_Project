package GYM.controller;

public class BodyController {
 
	// 1.
			boolean ex( int body_no, String body_name,
					String body_place, String body_comment) {
				BodyDTO dto = new BodyDTO(body_no, body_name, body_place, body_comment);
				return true;
			}
			
			// 2.
			/*
			ArrayList<BodyDTO> read () {
				return BodyDTO.getInstance().ex( dto );
			}
			//
			 
			 */
	
}
