/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.mvc.Mudii.controle;

import br.com.alura.mvc.Mudii.model.Pedido;
import br.com.alura.mvc.Mudii.model.StatusPedido;
import br.com.alura.mvc.Mudii.repositorios.RepositorioPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeControle {

    @Autowired
    private RepositorioPedido repositorioPedido;

    @GetMapping
    public String home(Model model) {

        List<Pedido> pedidos = repositorioPedido.findAll();
        
        model.addAttribute("pedidos", pedidos);

        return "home";
    }
    
     @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {

        List<Pedido> pedidos = repositorioPedido.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status" ,status);

        return "home";
    }
   
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
    

}
