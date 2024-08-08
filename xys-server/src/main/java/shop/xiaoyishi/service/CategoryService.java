package shop.xiaoyishi.service;

import shop.xiaoyishi.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    List<CategoryVO> firstCategory();
    List<CategoryVO> secondCategory(Long id);
}
