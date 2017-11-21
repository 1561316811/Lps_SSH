package clockcatagory;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_room", catalog = "lapd_test")
public class TRoom extends AbstractTRoom implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TRoom() {
	}

	/** minimal constructor */
	public TRoom(Integer floor, Integer size, Date addTime) {
		super(floor, size, addTime);
	}

	/** full constructor */
	public TRoom(TRoomcatagory TRoomcatagory, String name, Integer floor, Integer size, String remark, Date addTime) {
		super(TRoomcatagory, name, floor, size, remark, addTime);
	}

}
