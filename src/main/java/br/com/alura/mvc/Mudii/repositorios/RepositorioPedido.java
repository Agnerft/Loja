/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.mvc.Mudii.repositorios;

import br.com.alura.mvc.Mudii.model.Pedido;
import br.com.alura.mvc.Mudii.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

    public List<Pedido> findByStatus(StatusPedido status);
 

}
