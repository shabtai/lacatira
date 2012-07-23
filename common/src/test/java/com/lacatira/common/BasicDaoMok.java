package com.lacatira.common;

import org.junit.Ignore;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: rantene
 * Date: 6/4/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Ignore
public class BasicDaoMok<T extends BusinessModel>  implements GenericDao< T , Long> {
    protected Map<Long,T>  map = new HashMap<Long,T>();
    private List<T> namedQ;




    @Override
    public List<T> getAll() {
        return new ArrayList<T>
        (map.values());
    }

    @Override
    public List<T> getAllDistinct() {
         return new ArrayList<T>
        (new HashSet<T>(map.values()));
    }

    @Override
    public T get(Long id) {
        return map.get(id);
    }

    @Override
    public boolean exists(Long id) {
        return map.containsKey(id);
    }

    @Override
    public T save(T object) {
        return map.put(object.getId(),object);
    }

    @Override
    public void update(T object) {
        save(object);
    }

    @Override
    public void remove(Long id) {
        map.remove(map.get(id));
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        return namedQ;
    }
}
