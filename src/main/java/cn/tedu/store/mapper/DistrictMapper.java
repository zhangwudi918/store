package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

public interface DistrictMapper {

	/**
	 * 通过上级行政区的code查找其所管辖的下级行政区
	 * @param parent 省级行政区的code
	 * @return 下级行政区的集合
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 通过code查找行政区详情
	 * @param code
	 * @return
	 */
	District findByCode(String code);
}
