package shop.xiaoyishi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.xiaoyishi.mapper.HistoryMapper;
import shop.xiaoyishi.service.HistoryService;
import shop.xiaoyishi.vo.HistoryVO;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    /**
     * 历史数量
     * @param userId
     * @return
     */
    public Integer countHistory(Long userId) {
        return historyMapper.countHistory(userId);
    }

    @Override
    /**
     * 历史列表
     * @param userId
     * @param type
     * @return
     */
    public List<HistoryVO> historyList(Long userId, Integer type) {
        if(type == 0){
            return historyMapper.historyList(userId);
        }else if (type == 1){
            return historyMapper.historyCommodityList(userId);
        }else{
            return historyMapper.historyPostList(userId);
        }
    }
}
