package com.peng.action;

import com.peng.entity.CartItem;
import com.peng.entity.Product;
import com.peng.service.ShoppingService;
import com.peng.service.ShoppingServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CartItemAction {
    private Integer productId;
    private Integer[] pIds;
    private Integer[] pAmounts;


    public CartItemAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CartItemAction(Integer productId, Integer[] pIds, Integer[] pAmounts) {
        super();
        this.productId = productId;
        this.pIds = pIds;
        this.pAmounts = pAmounts;
    }

    @Override
    public String toString() {
        return "CartItemAction [productId=" + productId + ", pIds="
                + Arrays.toString(pIds) + ", pAmounts="
                + Arrays.toString(pAmounts) + "]";
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer[] getpIds() {
        return pIds;
    }

    public void setpIds(Integer[] pIds) {
        this.pIds = pIds;
    }

    public Integer[] getpAmounts() {
        return pAmounts;
    }

    public void setpAmounts(Integer[] pAmounts) {
        this.pAmounts = pAmounts;
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
            //判断该商品是否以前添加过
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
        cart.remove(productId);
        return "DeleteOne";

    }

    public String UpdateMount() {
        //获得request和session
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        CartItem cartItem = null;
        if (pIds != null) {
            for (int i = 0; i < pIds.length; i++) {
                if (cart.containsKey(pIds[i])) {
                    cart.remove(pIds[i]);
                    for (int j = 0; j < pAmounts.length; j++) {
                        cartItem = cart.get(pIds[i]);
                        cartItem.setMount(pAmounts[i]);
                    }
                    session.setAttribute("cart", cart);
                }
            }
        }
        return "UpdateMount";

    }


}













