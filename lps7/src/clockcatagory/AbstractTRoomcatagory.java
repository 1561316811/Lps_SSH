package clockcatagory;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractTRoomcatagory entity provides the base persistence definition of the
 * TRoomcatagory entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractTRoomcatagory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roomcatagory;
	private Set<TRoom> TRooms = new HashSet<TRoom>(0);

	// Constructors

	/** default constructor */
	public AbstractTRoomcatagory() {
	}

	/** full constructor */
	public AbstractTRoomcatagory(String roomcatagory, Set<TRoom> TRooms) {
		this.roomcatagory = roomcatagory;
		this.TRooms = TRooms;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "roomcatagory", unique = true, length = 20)

	public String getRoomcatagory() {
		return this.roomcatagory;
	}

	public void setRoomcatagory(String roomcatagory) {
		this.roomcatagory = roomcatagory;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRoomcatagory")

	public Set<TRoom> getTRooms() {
		return this.TRooms;
	}

	public void setTRooms(Set<TRoom> TRooms) {
		this.TRooms = TRooms;
	}

}