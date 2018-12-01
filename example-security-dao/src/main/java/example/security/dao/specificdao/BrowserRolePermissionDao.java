package example.security.dao.specificdao;

import example.security.dao.entity.BrowserRolePermission;
import example.security.dao.mapper.BrowserRolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public class BrowserRolePermissionDao extends BaseDao<BrowserRolePermission> {

    @Autowired
    private BrowserRolePermissionMapper browserRolePermissionMapper;

    @Override
    protected Mapper<BrowserRolePermission> getMapper() {
        return browserRolePermissionMapper;
    }
}
