package boot.mytemp.service;

import boot.mytemp.mapper.SelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectServiceImpl implements SelectService{

    @Autowired
    SelectMapper selectMapper;
    
    /*
    *   seoul 전체 출력
    * */
    @Override
    public List<Map> selectSeoul() {
        return selectMapper.selectSeoul();
    }
}
