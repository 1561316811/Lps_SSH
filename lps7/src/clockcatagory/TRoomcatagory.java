package clockcatagory;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TRoomcatagory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_roomcatagory", catalog = "lapd_test")
public class TRoomcatagory extends AbstractTRoomcatagory implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TRoomcatagory() {
	}

	/** full constructor */
	public TRoomcatagory(String roomcatagory, Set<TRoom> TRooms) {
		super(roomcatagory, TRooms);
	}

}
