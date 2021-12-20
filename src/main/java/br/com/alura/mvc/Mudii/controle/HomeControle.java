/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.mvc.Mudii.controle;

import br.com.alura.mvc.Mudii.model.Pedido;
import br.com.alura.mvc.Mudii.repositorios.RepositorioPedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeControle {

    @Autowired
    private RepositorioPedido repositorioPedido;

    @GetMapping("/home")
    public ModelAndView home() {
        
        List<Pedido> pedidos = repositorioPedido.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);

        return mv;
    }

}
