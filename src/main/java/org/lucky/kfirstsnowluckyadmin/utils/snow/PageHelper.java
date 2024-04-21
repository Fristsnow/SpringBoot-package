package org.lucky.kfirstsnowluckyadmin.utils.snow;

import com.github.pagehelper.PageInfo;
import org.lucky.kfirstsnowluckyadmin.utils.constant.HttpStatus;
import org.lucky.kfirstsnowluckyadmin.utils.core.page.PageDomain;
import org.lucky.kfirstsnowluckyadmin.utils.core.page.TableDataInfo;
import org.lucky.kfirstsnowluckyadmin.utils.core.page.TableSupport;
import org.lucky.kfirstsnowluckyadmin.utils.sql.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

public class PageHelper {

    protected final Logger logger = LoggerFactory.getLogger(PageHelper.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            com.github.pagehelper.PageHelper.startPage(pageNum, pageSize, orderBy);
        } else {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            com.github.pagehelper.PageHelper.orderBy(orderBy);
        }
    }

    protected void startPage(String orderBy) {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            com.github.pagehelper.PageHelper.startPage(pageNum, pageSize, orderBy);
        } else {
            com.github.pagehelper.PageHelper.orderBy(orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

//    /**
//     * 页面跳转
//     */
//    public String redirect(String url)
//    {
//        return StringUtils.format("redirect:{}", url);
//    }

//    /**
//     * 获取当前用户id
//     */
//    protected Long getUserId(){
//        return SecurityUtils.getLoginUser().getUser().getUserId();
//    }
//    /**
//     * 获取当前用户信息
//     */
//    protected SysUser getUser(){
//        return SecurityUtils.getLoginUser().getUser();
//    }

}
