package EjercicioGuardarBBDD.CONTROLLER;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CrudInterface<Object> {
    Boolean insertar(Connection conn , Object o);
    ResultSet leerTodo(Connection conn ,String tabla );
    ResultSet leerUnoPorId(Connection conn ,String tabla , Integer id );
    Boolean actualizar(Connection conn ,Object o , Integer idAModificar);
    Boolean borrar(Connection conn ,String tabla , Integer idAEliminar);

}
