package com.qualitas.portal.fraudes.account.Infrastructure.dao.impl;

import com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao;
import com.qualitas.portal.fraudes.account.domain.model.Persona;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    private final SqlSession sqlSession;

    @Autowired
    public PersonaDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        sqlSession.insert("com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao.crearPersona", persona);
        return persona;
    }

    @Override
    public Persona obtenerPersona(BigDecimal id) {
        return sqlSession.selectOne("com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao.obtenerPersona", id);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        sqlSession.update("com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao.actualizarPersona", persona);
        return persona;
    }

    @Override
    public List<Persona> listarPersonas() {
        return sqlSession.selectList("com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao.listarPersonas");
    }

    @Override
    public void eliminarPersona(BigDecimal id) {
        sqlSession.delete("com.qualitas.portal.fraudes.account.Infrastructure.dao.PersonaDao.eliminarPersona", id);
    }
}
