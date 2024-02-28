package boot.mytemp.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SelectMapper {
    public List<Map> selectSeoul();
    public List<Map> selectJoinTest();
}
