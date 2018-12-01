package example.security.dao.mapper;

import example.security.dao.entity.BrowserRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrowserRoleMapper extends Mapper<BrowserRole> {

    /***
     * 通过userId获取用户权限信息
     * @param userId 用户编号
     * @return 角色信息列表
     */
    List<BrowserRole> getUserRoleInfo(@Param("userId") Integer userId);
}