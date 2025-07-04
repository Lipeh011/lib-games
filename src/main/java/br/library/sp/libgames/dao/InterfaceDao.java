package br.library.sp.libgames.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<T> {
    public void inserir(T objeto) throws SQLException;

    public void alterar(T objeto) throws SQLException;

    public void excluir(int id) throws SQLException;

    public List<T> listar() throws SQLException;

    public T buscar(int id) throws SQLException;
}
