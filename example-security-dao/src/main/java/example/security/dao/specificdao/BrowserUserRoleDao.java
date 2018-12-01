package example.security.dao.specificdao;

import example.security.dao.entity.BrowserUserRole;
import example.security.dao.mapper.BrowserUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public class BrowserUserRoleDao extends BaseDao<BrowserUserRole> {

    @Autowired
    private BrowserUserRoleMapper browserUserRoleMapper;

    @Override
    protected Mapper<BrowserUserRole> getMapper() {
        return browserUserRoleMapper;
    }

    /***
     * 通过用户编号获取用户角色信息
     * @param userId
     */
    public void getUserRoleInfo(Integer userId) {
    }
}
