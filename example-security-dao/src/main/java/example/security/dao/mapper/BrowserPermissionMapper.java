package example.security.dao.mapper;

import example.security.dao.entity.BrowserPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrowserPermissionMapper extends Mapper<BrowserPermission> {

    /***
     *
     * @param account
     * @return
     */
    List<BrowserPermission> getPermissonByLoginName(@Param("account") String account);
}