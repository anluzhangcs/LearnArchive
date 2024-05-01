package bean;

/**
 * @author: zhanghao
 * @date: 2021/11/9-13:19
 */

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 订单项
 */
public class Order {
    private String id;
    private Date createTime;
    private BigDecimal Totalprice;
    private Integer status;
    private Integer userId;

    public Order() {
    }

    public Order(String id, Date createTime, BigDecimal totalprice, Integer status, Integer userId) {
        this.id = id;
        this.createTime = createTime;
        Totalprice = totalprice;
        this.status = status;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        Totalprice = totalprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", Totalprice=" + Totalprice +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
