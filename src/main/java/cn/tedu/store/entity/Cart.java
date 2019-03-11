package cn.tedu.store.entity;

public class Cart extends BaseEntity {

	private static final long serialVersionUID = 9186549562958848259L;

	private Integer id;
	private Integer uid;
	private Integer count;
	private Long price;
	private Long gid;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", count=" + count + ", price=" + price + ", gid=" + gid + "]";
	}

}
