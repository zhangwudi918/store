package cn.tedu.store.vo;

import java.io.Serializable;

public class CartVO implements Serializable{

	private static final long serialVersionUID = -977121558471543679L;

	private Integer id;
	private Long oldPrice;
	private Long newPrice;
	private String gid;
	private Integer count;
	private String image;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Long getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Long oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Long getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(Long newPrice) {
		this.newPrice = newPrice;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice + ", gid=" + gid + ", count="
				+ count + ", image=" + image + ", title=" + title + "]";
	}

	
}
