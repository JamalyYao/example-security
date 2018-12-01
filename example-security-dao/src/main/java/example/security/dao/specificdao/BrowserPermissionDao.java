package example.security.dao.specificdao;

import example.security.dao.entity.BrowserPermission;
import example.security.dao.mapper.BrowserPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public class BrowserPermissionDao extends BaseDao<BrowserPermission> {

    @Autowired
    private BrowserPermissionMapper browserPermissionMapper;

    @Override
    protected Mapper<BrowserPermission> getMapper() {
        return browserPermissionMapper;
    }

    /***
     * 获取权限
     * @param loginName
     * @return
     */
    public List<BrowserPermission> getPermissonByLoginName(String loginName) {
        return browserPermissionMapper.getPermissonByLoginName(loginName);
    }
}
