package DAL.Contacts;

import java.util.List;

/**
 * Created by AZayeni on 20/02/2018.
 */

public interface ICRUD <T> {
    long Add(T entity);
    void Update(T entity);
    T Get(int id,int CompanyCode);
    T Get(String id,String CompanyCode);
    List<T> GetALL();
    void Delete(int id,int CompanyCode);
}
