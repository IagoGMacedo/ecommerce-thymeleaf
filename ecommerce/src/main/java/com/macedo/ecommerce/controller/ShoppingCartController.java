package com.macedo.ecommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macedo.ecommerce.model.Category;
import com.macedo.ecommerce.model.Product;
import com.macedo.ecommerce.model.ProductItem;
import com.macedo.ecommerce.model.ShoppingCart;
import com.macedo.ecommerce.model.User;
import com.macedo.ecommerce.service.ProductItemService;
import com.macedo.ecommerce.service.ProductService;
import com.macedo.ecommerce.service.ShoppingCartService;
import com.macedo.ecommerce.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    ProductItemService productItemService;

    @RequestMapping("/showShoppingCart/{idUser}")
    public String showShoppingCart(@PathVariable("idUser") Integer idUser, Model model) {

        User user = userService.getUserById(idUser);
        if(user != null){
            model.addAttribute("shoppingCart", user.getShoppingCart());
            List<ProductItem> productItems = user.getShoppingCart().getProductItems();
            BigDecimal totalValue = BigDecimal.ZERO;
            for (ProductItem productItem : productItems) {
                totalValue = totalValue.add(productItem.getTotalItemPrice());
            }
            System.out.println("total value: "+totalValue);
            model.addAttribute("totalValue", totalValue);
            model.addAttribute("productItems", productItems);
            model.addAttribute("user", user);
            return "shoppingCart/listaShoppingCart";
        }
        return "home";

    }

    @RequestMapping("/addProductToShoppingCart/{idUser}/{idProduct}")
    public String addProductToShoppingCart(
            @PathVariable("idUser") Integer idUser,
            @PathVariable("idProduct") Integer idProduct,
            Model model) {
        
        System.out.println("entrei no metodo de adicionar no carrinho");

        User user = userService.getUserById(idUser);
        ShoppingCart shoppingCart = user.getShoppingCart();
        Product product = productService.getProductById(idProduct);
        if(shoppingCart != null && product != null){
            ProductItem productItem = new ProductItem();
            productItem.setProduct(product);
            productItem.setQuantity(1);
            productItem.setShoppingCart(shoppingCart);
            shoppingCart.getProductItems().add(productItem);
            shoppingCartService.updateShoppingCart(shoppingCart);
            System.out.println("inclusão feita com sucesso");
            model.addAttribute("quantityShoppingCart", shoppingCart.getProductItems().size());
        }
        return "redirect:/product/getListaProductsUser/"+user.getId();
    }

    @RequestMapping("/removeProductItemFromShoppingCart/{idUser}/{idProduct}")
    public String removeProductItemFromShoppingCart(
            @PathVariable("idUser") Integer idUser,
            @PathVariable("idProduct") Integer idProduct,
            Model model) {
        
        System.out.println("entrei no metodo de remover no carrinho");

        User user = userService.getUserById(idUser);
        ShoppingCart shoppingCart = user.getShoppingCart();
        ProductItem product = productItemService.getProductItemById(idProduct);
        if(shoppingCart != null && product != null){
            shoppingCart.getProductItems().remove(product);
            shoppingCartService.updateShoppingCart(shoppingCart);
            productItemService.deleteProductItem(product);
            System.out.println("remoção feita com sucesso");
            model.addAttribute("quantityShoppingCart", shoppingCart.getProductItems().size());
        }
        return "redirect:/shoppingCart/showShoppingCart/"+user.getId();
        
    }

    @RequestMapping("/increaseProductItemFromShoppingCart/{idUser}/{idProduct}")
    public String increaseProductItemFromShoppingCart(
            @PathVariable("idUser") Integer idUser,
            @PathVariable("idProduct") Integer idProduct,
            Model model) {
        

        User user = userService.getUserById(idUser);
        ShoppingCart shoppingCart = user.getShoppingCart();
        ProductItem product = productItemService.getProductItemById(idProduct);
        if(shoppingCart != null && product != null){
            product.setQuantity(product.getQuantity()+1);
            productItemService.updateProductItem(product);
            System.out.println("remoção feita com sucesso");
            model.addAttribute("quantityShoppingCart", shoppingCart.getProductItems().size());
        }
        return "redirect:/shoppingCart/showShoppingCart/"+user.getId();
        
    }

    @RequestMapping("/decreaseProductItemFromShoppingCart/{idUser}/{idProduct}")
    public String decreaseProductItemFromShoppingCart(
            @PathVariable("idUser") Integer idUser,
            @PathVariable("idProduct") Integer idProduct,
            Model model) {
        

        User user = userService.getUserById(idUser);
        ShoppingCart shoppingCart = user.getShoppingCart();
        ProductItem product = productItemService.getProductItemById(idProduct);
        if(shoppingCart != null && product != null){
            if(product.getQuantity() - 1==0){
                shoppingCart.getProductItems().remove(product);
                shoppingCartService.updateShoppingCart(shoppingCart);
                productItemService.deleteProductItem(product);
            } else{
                product.setQuantity(product.getQuantity()-1);
                productItemService.updateProductItem(product);
            }
            System.out.println("remoção feita com sucesso");
            model.addAttribute("quantityShoppingCart", shoppingCart.getProductItems().size());
        }
        return "redirect:/shoppingCart/showShoppingCart/"+user.getId();
        
    }


    

    @RequestMapping("/getListaShoppingCartsAdmin")
    public String showListaShoppingCartAdmin(Model model) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts();
        model.addAttribute("shoppingCarts", shoppingCarts);
        return "shoppingCart/listaShoppingCartsAdmin";
    }

    @RequestMapping("/getListaShoppingCartsUser")
    public String showListaShoppingCartUser(Model model) {
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCarts();
        model.addAttribute("shoppingCarts", shoppingCarts);
        return "shoppingCart/listaShoppingCartsUser";
    }

    @RequestMapping("/deleteShoppingCart/{id}")
    public String deleteShoppingCart(@PathVariable("id") Integer id) {
        ShoppingCart deleteShoppingCart = shoppingCartService.getShoppingCartById(id);
        if (deleteShoppingCart != null)
            shoppingCartService.deleteShoppingCart(deleteShoppingCart);
        return "redirect:/shoppingCart/getListaShoppingCarts";
    }

    
}