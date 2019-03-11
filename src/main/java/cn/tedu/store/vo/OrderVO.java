package cn.tedu.store.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.tedu.store.entity.OrderItem;

public class OrderVO implements Serializable{

	private static final long serialVersionUID = -5378744832577871647L;
	private Integer id; 
	private Integer uid;
	private String recvName;
	private String  recvPhone;
	private String  recvDistrict;
	private String  recvAddress;
	private Long  pay;
	private Date  orderTime;
	private Integer  status;
	private List<OrderItem> list;
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
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvDistrict() {
		return recvDistrict;
	}
	public void setRecvDistrict(String recvDistrict) {
		this.recvDistrict = recvDistrict;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public Long getPay() {
		return pay;
	}
	public void setPay(Long pay) {
		this.pay = pay;
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
	public List<OrderItem> getList() {
		return list;
	}
	public void setList(List<OrderItem> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvDistrict=" + recvDistrict + ", recvAddress=" + recvAddress + ", pay=" + pay + ", orderTime="
				+ orderTime + ", status=" + status + ", list=" + list + "]";
	}
	
	
}
