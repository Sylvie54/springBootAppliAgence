/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence.Dao;

import AFPA.CDA03.demo.appliAgence.models.Circuits;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Acer
 */
public interface CircuitsRepository extends JpaRepository<Circuits, Long>  {
    
}
