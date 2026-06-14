/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.OrdemServico;
import com.av_car_auto_center.model.OrdemServicoPeca;
import com.av_car_auto_center.model.OrdemServicoServico;
import com.av_car_auto_center.respository.OrdemServicoPecaDao;
import com.av_car_auto_center.respository.OrdemServicoServicoDao;
import com.av_car_auto_center.service.OrdemServicoService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class OrdemServicoController implements IGenericController<OrdemServico> {
 
    private final OrdemServicoService ordemServicoService;
    private final OrdemServicoPecaDao ordemServicoPecaDao;
    private final OrdemServicoServicoDao ordemServicoServicoDao;
 
    public OrdemServicoController() {
        this.ordemServicoService = new OrdemServicoService();
        this.ordemServicoPecaDao = new OrdemServicoPecaDao();
        this.ordemServicoServicoDao = new OrdemServicoServicoDao();
    }
 
    @Override
    public void cadastrar(OrdemServico ordemServico) {
        ordemServicoService.cadastrar(ordemServico);
    }
 
    @Override
    public void atualizar(OrdemServico ordemServico) {
        ordemServicoService.atualizar(ordemServico);
    }
 
    @Override
    public OrdemServico buscarPorID(int id) {
        return ordemServicoService.buscarPorID(id);
    }
 
    public List<OrdemServico> listarTodos() {
        return ordemServicoService.listarTodos();
    }
    
    // ---- OrdemServicoPeca ----
 
    public void vincularPeca(OrdemServicoPeca ordemServicoPeca) {
        ordemServicoPecaDao.insert(ordemServicoPeca);
    }
 
    public List<OrdemServicoPeca> listarPecasDaOrdem(int idOrdemServico) {
        return ordemServicoPecaDao.SelectPorOrdemServico(idOrdemServico);
    }
 
    public List<OrdemServicoPeca> listarOrdensDaPeca(int idPeca) {
        return ordemServicoPecaDao.SelectPorPeca(idPeca);
    }
 
    // ---- OrdemServicoServico ----
 
    public void vincularServico(OrdemServicoServico ordemServicoServico) {
        ordemServicoServicoDao.insert(ordemServicoServico);
    }
 
    public List<OrdemServicoServico> listarServicosDaOrdem(int idOrdemServico) {
        return ordemServicoServicoDao.SelectPorOrdemServico(idOrdemServico);
    }
 
    public List<OrdemServicoServico> listarOrdensPorServico(int idServico) {
        return ordemServicoServicoDao.SelectPorServico(idServico);
    }
    
}
