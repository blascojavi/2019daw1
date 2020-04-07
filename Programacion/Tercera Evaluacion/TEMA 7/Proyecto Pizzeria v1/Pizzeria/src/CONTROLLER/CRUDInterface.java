package CONTROLLER;

import java.util.Map;

public interface CRUDInterface<Object> {

    boolean add(Object o);
    Object read(Integer index);
    Map<Integer,Object> readAll();
    boolean update(Integer index ,Object o);
    boolean delete(Integer index);
}
