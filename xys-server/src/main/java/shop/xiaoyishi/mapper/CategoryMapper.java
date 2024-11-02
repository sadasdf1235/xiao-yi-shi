package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.vo.CategoryVO;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 一级分类
     * @return
     */
    @Select("select category_id id,category_name name, parent_category_id parent_id from categories where parent_category_id is null and is_deleted = 0 ")
    List<CategoryVO> firstCategory();

    /**
     * 二级分类
     * @return
     */
    @Select("select category_id id,category_name name, parent_category_id parent_id from categories where parent_category_id = #{id} and is_deleted = 0")
    List<CategoryVO> secondCategory(Long id);
}
