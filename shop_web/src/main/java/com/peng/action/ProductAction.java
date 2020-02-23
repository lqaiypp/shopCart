package com.peng.action;

import com.peng.entity.CartItem;
import com.peng.entity.Product;
import com.peng.service.ShoppingService;
import com.peng.service.ShoppingServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductAction {
    private Integer currentPage;
    private String productName;
    private String opt;
    private Double price;
    private Integer productId;
    private Integer[] pIds;
    private Integer[] pAmounts;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer[] getPIds() {
        return pIds;
    }

    public void setPIds(Integer[] pIds) {
        this.pIds = pIds;
    }

    public Integer[] getPAmounts() {
        return pAmounts;
    }

    public void setPAmounts(Integer[] pAmounts) {
        this.pAmounts = pAmounts;
    }

    public String showAllProduct() {
        if (currentPage == null) {
            currentPage = 1;
        }
        //调用Service
        ShoppingService sp = new ShoppingServiceImpl();
        List<Product> l = sp.findProduct(currentPage, productName, opt, price);
        //获取request
        HttpServletRequest req = ServletActionContext.getRequest();
        req.setAttribute("prods", l);
        //保留下可以查询的条件
        req.setAttribute("productName", productName);
        return "showProduct";
    }

    public String AddCart() {
        //调用Service
        ShoppingService sp = new ShoppingServiceImpl();
        Product p = sp.queryById(productId);
        //获取request和session
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        CartItem cartItem = null;
        if (cart == null) {
            cart = new HashMap<Integer, CartItem>();
            cartItem = new CartItem(p, 1, p.getPrice() * 1);
            cart.put(productId, cartItem);
            session.setAttribute("cart", cart);
        } else {
            //判断该商品是否添加过
            if (cart.containsKey(productId)) {
                //找到该购物车对象
                cartItem = cart.get(productId);
                //更新该商品在购物车中的信息
                cartItem.setMount(cartItem.getMount() + 1);
                cartItem.setTotlePrice(cartItem.getTotlePrice() * 2);
            } else {
                cartItem = new CartItem(p, 1, p.getPrice() * 1);
                cart.put(productId, cartItem);
            }
            session.setAttribute("prod", p);
        }
        return "addCart";
    }

    public String DeleteOne() {
        //获得request和session
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        Map<Integer, CartItem> deleteCart = (Map<Integer, CartItem>) session.getAttribute("deleteCart");
        CartItem cartItem = null;
        if (deleteCart == null) {
            deleteCart = new HashMap<Integer, CartItem>();
            deleteCart.put(productId, cart.get(productId));
        } else {
            //判断是否删除过该商品
            if (deleteCart.containsKey(productId)) {
                cartItem = deleteCart.get(productId);
                cartItem.setMount(cartItem.getMount() + 1);
                cartItem.setTotlePrice(cartItem.getMount() * cartItem.getProduct().getPrice());
            } else {
                deleteCart.put(productId, cart.get(productId));
            }
        }
        cart.remove(productId);
        session.setAttribute("deleteCart", deleteCart);
        return "DeleteOne";

    }

    public String UpdateMount() {
        System.out.println(pIds);
        System.out.println(pAmounts);
        //获得request和session
        HttpServletRequest req = ServletActionContext.getRequest();
        String[] strPids = req.getParameterValues("pIds");
        System.out.println(strPids[0]);
        HttpSession session = req.getSession();
        //获取老购物车集合
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        //回收站集合
        Map<Integer, CartItem> deleteCart = null;
        if (session.getAttribute("deleteCart") == null) {//判断是否存在回收站
            deleteCart = new HashMap<Integer, CartItem>();
        } else {
            deleteCart = (Map<Integer, CartItem>) session.getAttribute("deleteCart");
        }
        //先新建一个新的购物车集合
        Map<Integer, CartItem> newCart = new HashMap<Integer, CartItem>();
        if (pIds == null) {//如果提交的pIds数组为空则代表把购物车中所有物品都删除
            Set<Integer> key = cart.keySet();
            for (Integer id : key) {
                deleteCart.put(id, cart.get(id));
            }
            session.removeAttribute("cart");
            session.setAttribute("deleteCart", deleteCart);
        } else {//不为空则为部分删除或者不删除
            for (int i = 0; i < pIds.length; i++) {
                CartItem c = cart.get(pIds[i]);
                c.setMount(pAmounts[i]);
                c.setTotlePrice(pAmounts[i] * c.getProduct().getPrice());
                newCart.put(pIds[i], c);
                cart.remove(pIds[i]);
            }
            //然后把老购车中删除的商品加入到回收站中
            Set<Integer> key = cart.keySet();
            for (Integer id : key) {
                deleteCart.put(id, cart.get(id));
            }
        }
        session.setAttribute("cart", newCart);
        session.setAttribute("deleteCart", deleteCart);
        return "UpdateMount";
    }

    public String RecoveryOneCart() {
        //获得request和session
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession session = req.getSession();
        Map<Integer, CartItem> deleteCart = (Map<Integer, CartItem>) session.getAttribute("deleteCart");
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        CartItem cartItem = null;
        if (cart == null) {
            cart = new HashMap<Integer, CartItem>();
            cart.put(productId, deleteCart.get(productId));
        } else {
            //判断以前是否删除过该商品
            if (cart.containsKey(productId)) {
                cartItem = cart.get(productId);
                cartItem.setMount(cartItem.getMount() + 1);
                cartItem.setTotlePrice(cartItem.getMount() * cartItem.getProduct().getPrice());
            } else {
                cart.put(productId, deleteCart.get(productId));
            }
        }
        deleteCart.remove(productId);
        session.setAttribute("cart", cart);
        session.setAttribute("deleteCart", deleteCart);
        return "RecoveryOneCart";
    }

}
