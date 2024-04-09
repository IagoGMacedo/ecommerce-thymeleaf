package com.macedo.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.macedo.ecommerce.model.Address;
import com.macedo.ecommerce.model.Role;
import com.macedo.ecommerce.model.User;
import com.macedo.ecommerce.service.AddressService;
import com.macedo.ecommerce.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;




@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    
    

    @RequestMapping("/login")
    public String loginUsuario(Model model, @ModelAttribute("user") User user) {
        System.out.println("entrei no endpoint de login");
        System.out.println("meu email: " + user.getEmail());
        System.out.println("minha senha: " +user.getPassword());

        User userFind = userService.getUserByEmail(user.getEmail());

        if(userFind != null && userFind.getPassword().equals(user.getPassword())){
            model.addAttribute("user", userFind);
            return "vitrine.html";
            /* 
            if(userFind.getRole() == Role.ADMIN)
                return "homeAdmin.html";
            */

        //return "home.html";
        }
            
        return "home.html";
    }

    @RequestMapping("/register")
    public String registroUsuario(Model model, @ModelAttribute("user") User user) {
        System.out.println("entrei no endpoint de registro");
        System.out.println("meu nome: " + user.getName());
        System.out.println("meu email: " + user.getEmail());
        System.out.println("minha senha: " +user.getPassword());

        User userFind = userService.getUserByEmail(user.getEmail());

        if(userFind == null && !user.getName().isEmpty() && !user.getPassword().isEmpty() 
        && !user.getEmail().isEmpty()){
            userService.saveUser(user);
            model.addAttribute("user", user);
            model.addAttribute("address", new Address());
            //return "cadastrarEndereco.html";
            
            return "redirect:/product/getListaProducts";
        }


        return "home.html";
    }

    @RequestMapping("/terminarCadastro/{id}")
    public String terminarCadastroUsuario(@PathVariable("id") Integer id,Model model, @ModelAttribute("address") Address address) {
        System.out.println("entrei no endpoint de terminar cadastro");
        System.out.println("meu bairro: " +address.getDistrict());
        System.out.println("minha cidade: " +address.getCity());
        User usuarioFind = userService.getUserById(id);
        if(usuarioFind != null){
            address.setId(usuarioFind.getAddress().getId());
            addressService.updateAddress(address);


            model.addAttribute("user", usuarioFind);
            return "vitrine.html";
        }
        return "home.html";
    }
    

}
