package example.security.dao.specificdao;

import example.security.dao.entity.BrowserRole;
import example.security.dao.mapper.BrowserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public class BrowserRoleDao extends BaseDao<BrowserRole> {

    @Autowired
    private BrowserRoleMapper browserRoleMapper;

    @Override
    protected Mapper<BrowserRole> getMapper() {
        return browserRoleMapper;
    }

    public List<BrowserRole> getRoleInfo(Integer userId) {
        return browserRoleMapper.getUserRoleInfo(userId);
    }
}
