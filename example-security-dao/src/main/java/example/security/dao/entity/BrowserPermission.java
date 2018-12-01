package example.security.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_browser_permission")
public class BrowserPermission {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名
     */
    @Column(name = "perm_name")
    private String permName;

    /**
     * 描述
     */
    private String remark;

    /**
     * 菜单链接
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 关联资源（后台接口/权限字符串等）
     */
    private String permission;

    /**
     * 所属上级
     */
    @Column(name = "p_id")
    private Integer pId;

    /**
     * 是否显示 0--显示 1--显示
     */
    @Column(name = "is_display")
    private Integer isDisplay;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型 1--页面 2--动作
     */
    private Integer type;

    /**
     * 动作方法 ALL POST GET PUT
     */
    private String method;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0：未删除，1：逻辑删除
     */
    private Integer flag;

    /**
     * 修改人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名
     *
     * @return perm_name - 资源名
     */
    public String getPermName() {
        return permName;
    }

    /**
     * 设置资源名
     *
     * @param permName 资源名
     */
    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    /**
     * 获取描述
     *
     * @return remark - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取菜单链接
     *
     * @return url - 菜单链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单链接
     *
     * @param url 菜单链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取关联资源（后台接口/权限字符串等）
     *
     * @return permission - 关联资源（后台接口/权限字符串等）
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置关联资源（后台接口/权限字符串等）
     *
     * @param permission 关联资源（后台接口/权限字符串等）
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 获取所属上级
     *
     * @return p_id - 所属上级
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * 设置所属上级
     *
     * @param pId 所属上级
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * 获取是否显示 0--显示 1--显示
     *
     * @return is_display - 是否显示 0--显示 1--显示
     */
    public Integer getIsDisplay() {
        return isDisplay;
    }

    /**
     * 设置是否显示 0--显示 1--显示
     *
     * @param isDisplay 是否显示 0--显示 1--显示
     */
    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取类型 1--页面 2--动作
     *
     * @return type - 类型 1--页面 2--动作
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 1--页面 2--动作
     *
     * @param type 类型 1--页面 2--动作
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取动作方法 ALL POST GET PUT
     *
     * @return method - 动作方法 ALL POST GET PUT
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置动作方法 ALL POST GET PUT
     *
     * @param method 动作方法 ALL POST GET PUT
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0：未删除，1：逻辑删除
     *
     * @return flag - 0：未删除，1：逻辑删除
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * 设置0：未删除，1：逻辑删除
     *
     * @param flag 0：未删除，1：逻辑删除
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取修改人
     *
     * @return update_by - 修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改人
     *
     * @param updateBy 修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}