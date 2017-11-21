package clockcatagory;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractTRoom entity provides the base persistence definition of the TRoom
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractTRoom implements java.io.Serializable {

	// Fields

	private Integer id;
	private TRoomcatagory TRoomcatagory;
	private String name;
	private Integer floor;
	private Integer size;
	private String remark;
	private Date addTime;

	// Constructors

	/** default constructor */
	public AbstractTRoom() {
	}

	/** minimal constructor */
	public AbstractTRoom(Integer floor, Integer size, Date addTime) {
		this.floor = floor;
		this.size = size;
		this.addTime = addTime;
	}

	/** full constructor */
	public AbstractTRoom(TRoomcatagory TRoomcatagory, String name, Integer floor, Integer size, String remark,
			Date addTime) {
		this.TRoomcatagory = TRoomcatagory;
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.remark = remark;
		this.addTime = addTime;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catagory")

	public TRoomcatagory getTRoomcatagory() {
		return this.TRoomcatagory;
	}

	public void setTRoomcatagory(TRoomcatagory TRoomcatagory) {
		this.TRoomcatagory = TRoomcatagory;
	}

	@Column(name = "name", unique = true, length = 10)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "floor", nullable = false)

	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "size", nullable = false)

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "addTime", nullable = false, length = 19)

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}