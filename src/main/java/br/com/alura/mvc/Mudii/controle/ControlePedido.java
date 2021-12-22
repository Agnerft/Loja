/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.mvc.Mudii.controle;

import br.com.alura.mvc.Mudii.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.Mudii.model.Pedido;
import br.com.alura.mvc.Mudii.repositorios.RepositorioPedido;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class ControlePedido {
    
    @Autowired
    private RepositorioPedido repositorioPedido;
    
    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
       
        
        return "pedido/formulario";
    }
    
    @PostMapping("/novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        if(result.hasErrors()){
            return "pedido/formulario";
        }
        Pedido pedido = requisicao.toPedido();
        repositorioPedido.save(pedido);
        return "redirect:/home";
    }
    
}
