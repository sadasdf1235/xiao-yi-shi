package shop.xiaoyishi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shop.xiaoyishi.vo.CategoryVO;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select category_id id,category_name name, parent_category_id parent_id from categories where parent_category_id is null ")
    List<CategoryVO> firstCategory();

    @Select("select category_id id,category_name name, parent_category_id parent_id from categories where parent_category_id = #{id}")
    List<CategoryVO> secondCategory(Long id);
}
