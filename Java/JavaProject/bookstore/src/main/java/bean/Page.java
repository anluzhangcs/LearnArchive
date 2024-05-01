package bean;

/**
 * @author: zhanghao
 * @date: 2021/11/4-10:58
 */

import java.util.List;

/**
 * @Description Page模型,分页操作的抽象
 *  T泛型可以使Page模型可以适用于多个不同模块
 */

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNumber;

    //每页的大小
    private Integer pageSize = PAGE_SIZE;

    //总页数
    private Integer pageTotal;

    //总记录数
    private Integer itemCount;

    //Page中封装的记录
    private List<T> items;

    //不同模块分页请求不同的部分==>抽取分页标签为公共，每个需要分页的只需静态引入
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        //服务器端对页码进行校验
        if (pageNumber < 1) { //不能小于1
            pageNumber = 1;
        }
        if (pageNumber > pageTotal) { //不能大于总页数
            pageNumber = pageTotal;
        }
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
