package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.mapper.HistoryMapper;
import shop.xiaoyishi.service.HistoryService;
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public Integer countHistory(Long userId) {
        return historyMapper.countHistory(userId);
    }
}
