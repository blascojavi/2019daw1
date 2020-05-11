package EjercicioGuardarBBDD.CONTROLLER;

import EjercicioGuardarBBDD.MODEL.Parque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDParque implements CrudInterface<Parque>{


    @Override
    public Boolean insertar(Connection conn, Parque parque) {
        Boolean inserted = false;
        String insertParque = "INSERT INTO parque (id,nombre,extension,idComunidad) VALUES ?,?,?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(insertParque);
            ps.setInt(1,parque.getId());
            ps.setString(2,parque.getNombre());
            ps.setDouble(3,parque.getExtension());
            ps.setInt(4,parque.getIdComunidad());
            inserted = ps.execute();
        } catch (SQLException insertError) {
            insertError.printStackTrace();
        }
        return inserted;
    }

    @Override
    public ResultSet leerTodo(Connection conn, String tabla) {
        return null;
    }

    @Override
    public ResultSet leerUnoPorId(Connection conn, String tabla, Integer id) {
        return null;
    }

    @Override
    public Boolean actualizar(Connection conn, Parque parque, Integer idAModificar) {
        return null;
    }


    @Override
    public Boolean borrar(Connection conn, String tabla, Integer idAEliminar) {
        return null;
    }
}
