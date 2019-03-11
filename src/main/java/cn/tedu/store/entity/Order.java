package cn.tedu.store.entity;

import java.util.Date;

public class Order extends BaseEntity {

	private static final long serialVersionUID = 748874982753891892L;

	private Integer id;
	private Integer uid;
	private Date orderTime;
	private Integer status;
	private Long pay;
	private String recvName;
	private String recvDistrict;
	private String recvPhone;
	private String recvAddress;
	
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getPay() {
		return pay;
	}
	public void setPay(Long pay) {
		this.pay = pay;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvDistrict() {
		return recvDistrict;
	}
	public void setRecvDistrict(String recvDistrict) {
		this.recvDistrict = recvDistrict;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", orderTime=" + orderTime + ", status=" + status + ", pay=" + pay
				+ ", recvName=" + recvName + ", recvDistrict=" + recvDistrict + ", recvPhone=" + recvPhone
				+ ", recvAddress=" + recvAddress + "]";
	}
	

	

}
