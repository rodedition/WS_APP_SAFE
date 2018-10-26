/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Eval_Terr;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface Eval_TerrDAO {
    public List<Eval_Terr> getListEval_Terr();
    public boolean addCertificado(Certificado certificado);
    public Certificado getByIdCertificado (Long id);
    public void deleteCertificado (Long id);
    public boolean updateCertificado (Certificado certificado);   
}
