package example.security.dao.specificdao;

import cn.hutool.core.util.StrUtil;
import example.security.dao.entity.BrowserUser;
import example.security.dao.mapper.BrowserUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Repository
public class BrowserUserDao extends BaseDao<BrowserUser> {

    @Autowired
    private BrowserUserMapper browserUserMapper;

    @Override
    protected Mapper<BrowserUser> getMapper() {
        return browserUserMapper;
    }

    /***
     * 获取浏览器用户对象信息
     * @param account 登录用户账号
     * @param mobileNo 登录手机号码
     * @return 用户对象
     */
    public BrowserUser getBrowserUserInfo(String account,String mobileNo) {
       BrowserUser browserUser = new BrowserUser();
       if (StrUtil.isNotEmpty(account)){
           browserUser.setAccount(account);
       }
       if (StrUtil.isNotEmpty(mobileNo)){
           browserUser.setMobileNo(mobileNo);
       }

       browserUser.setFlag(0);
       return this.queryOne(browserUser);
    }
}
