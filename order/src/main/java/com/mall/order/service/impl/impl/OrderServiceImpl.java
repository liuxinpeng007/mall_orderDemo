package com.mall.order.service.impl.impl;

import com.mall.order.entity.Goods;
import com.mall.order.entity.Order;
import com.mall.order.entity.OrderGoods;
import com.mall.order.entity.OrderItem;
import com.mall.order.feign.GoodsFeignClient;
import com.mall.order.mapper.OrderItemMapper;
import com.mall.order.mapper.OrderMapper;
import com.mall.order.service.impl.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 订单服务类
 *
 * @author liuxinpeng
 * @data 2019/04/03
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private GoodsFeignClient goodsFeignClient;

    /**
     * 根据订单ID查询订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    @Override
    public OrderGoods getOrderById(String id) {
        // 1.查询订单信息
        Order order = orderMapper.getOrderById(id);
        if (order != null) {
            // 根据订单信息查询商品信息
            return queryGoodsDescByOrder(order);
        }
        return null;
    }


    /**
     * 根据用户ID查询订单信息
     *
     * @param userId 用户ID
     * @return 订单信息
     */
    @Override
    public List<OrderGoods> getOrderByUserId(String userId) {
        // 1.根据用户ID查询所有订单信息
        List<Order> orders = orderMapper.getOrderByUserId(userId);
        if (orders != null && orders.size() > 0) {
            List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();
            // 2.循环查找订单信息相关的商品信息
            for (int i = 0, len = orders.size(); i < len; i++) {
                OrderGoods orderGoods = queryGoodsDescByOrder(orders.get(i));
                orderGoodsList.add(orderGoods);
            }
            // 3.返回订单信息和商品信息
            return orderGoodsList;
        }
        return null;
    }

    /**
     * 生成订单
     *
     * @param goods 商品信息集合
     */
    @Override
    public boolean addOrder(List<Goods> goods) throws Exception {
        // 1.判空
        if (goods != null && goods.size() > 0) {
            // 2.生成订单
            Order order = new Order();
            // 3. 生成订单号，此处使用UUID，正常应使用特定的算法来实现订单号
            String orderId = UUID.randomUUID().toString().replace("-", "");
            order.setId(orderId);
            order.setOrderDate(new Date());
            // 订单状态 0：待付款、1：已付款、2：已付款、3：取消或删除订单
            order.setStatus("0");
            // 此处应该从session或redis中取得当前用户ID，暂使用固定值代替
            order.setUserId("edcae26418994a70a67ceb3d9fda6fa7");
            try {
                float amount = 0f;
                // 4.循环设置订单详细信息并入库
                for (int i = 0, len = goods.size(); i < len; i++) {
                    Goods temp = goods.get(i);
                    OrderItem item = new OrderItem();
                    item.setId(UUID.randomUUID().toString().replace("-", ""));
                    item.setOrderId(orderId);
                    item.setGoodsId(temp.getId());
                    item.setGoodsNum(temp.getGoodsNum());
                    item.setGoodsPrice(temp.getPrice());
                    orderItemMapper.addOrderItem(item);
                    // 计算订单总价
                    amount += temp.getPrice() * temp.getGoodsNum();
                }
                order.setAmount(amount);
                // 5.订单入库
                orderMapper.addOrder(order);
                return true;
            } catch (Exception e) {
                // catchk区域中应打印报错日志
                // 并抛出异常,让事务处理器能够捕获到异常并回滚该方法对数据库的操作。
                // 简单演示，暂且没配置事务。
                e.printStackTrace();
                System.out.println("创建订单失败原因");
                throw new Exception("订单创建失败。失败原因XXX");
            }
        }
        return false;
    }

    /**
     * 根据订单查询商品信息
     *
     * @param order 订单详情
     */
    private OrderGoods queryGoodsDescByOrder(Order order) {
        if (order != null) {
            // 1.查询订单详情
            List<OrderItem> orderItems = orderItemMapper.getOrderByOrderId(order.getId());
            if (orderItems != null && orderItems.size() > 0) {
                // 2.查询商品详情
                List<Goods> goodsList = new ArrayList<Goods>();
                for (int i = 0, len = orderItems.size(); i < len; i++) {
                    OrderItem temp = orderItems.get(i);
                    // 商品ID
                    String goodsId = temp.getGoodsId();
                    // 根据商品ID查询商品信息
                    Goods goods = goodsFeignClient.getStudentById(goodsId);
                    goods.setPrice(temp.getGoodsPrice());
                    goods.setGoodsNum(temp.getGoodsNum());
                    goodsList.add(goods);
                }
                // 3.创建订单和商品详情类
                OrderGoods detail = new OrderGoods();
                detail.setOrder(order);
                detail.setGoodsList(goodsList);
                return detail;
            }
        }
        return null;
    }

}
