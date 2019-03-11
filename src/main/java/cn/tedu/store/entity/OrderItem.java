package cn.tedu.store.entity;

public class OrderItem extends BaseEntity {

	private static final long serialVersionUID = -266126793358890302L;
	private Integer id;
	private Integer oid;
	private String goodsId;
	private String goodsImage;
	private String goodsTitle;
	private Integer goodsCount;
	private Long goodsPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Long getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", oid=" + oid + ", goodsId=" + goodsId + ", goodsImage=" + goodsImage
				+ ", goodsTitle=" + goodsTitle + ", goodsCount=" + goodsCount + ", goodsPrice=" + goodsPrice + "]";
	}

}
