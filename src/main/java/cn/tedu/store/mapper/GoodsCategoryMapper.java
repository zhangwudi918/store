package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.GoodsCategory;

public interface GoodsCategoryMapper {

	/**
	 * 通过父类id查找指定父级分类下的所有子级分类的数据
	 * @param parentId 父类id
	 * @return 所有子级分类的数据
	 */
	List<GoodsCategory> findByParentId(Long parentId);
}
