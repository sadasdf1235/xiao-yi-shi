package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.mapper.CategoryMapper;
import shop.xiaoyishi.service.CategoryService;
import shop.xiaoyishi.vo.CategoryVO;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public List<CategoryVO> firstCategory(){
        return categoryMapper.firstCategory();
    }

    public List<CategoryVO> secondCategory(Long id){
        return categoryMapper.secondCategory(id);
    }
}
