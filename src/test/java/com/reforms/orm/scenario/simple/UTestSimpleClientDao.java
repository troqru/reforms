package com.reforms.orm.scenario.simple;

import com.reforms.orm.scenario.TestScenarioDao;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Тестируем выборку для вложенных объектов
 * @author evgenie
 */
public class UTestSimpleClientDao extends TestScenarioDao {

    public UTestSimpleClientDao() {
        super("scenario_simple.sql", "UTestClientDao");
    }

    @Test
    public void testClientDaoMap() throws Exception {
        ClientDao clientDao = new ClientDao(h2ds);
        ClientOrm clientOrm1 = clientDao.loadClient(1L);
        assertEquals("[id=1, " +
                "name=Пупкин Иван Иванович, " +
                      "addressId=1, " +
                "city=Москва, " +
                "street=Лужники, " +
                "actTime=Sun Jan 01 19:12:01 MSK 2017]", clientOrm1.toString());
        ClientOrm clientOrm2 = clientDao.loadClient(2L);
        assertEquals("[id=2, " +
                "name=Остапов Никалай Сергеевич, " +
                      "addressId=2, " +
                "city=Москва, " +
                "street=Конова, " +
                "actTime=Sun Jan 01 19:12:01 MSK 2017]", clientOrm2.toString());
    }

    @Test
    public void testClientsDaoMap() throws Exception {
        ClientDao clientDao = new ClientDao(h2ds);
        List<ClientOrm> clientsOrm = clientDao.loadClients();
        ClientOrm clientOrm1 = clientsOrm.get(0);
        assertEquals("[id=1, " +
                "name=Пупкин Иван Иванович, " +
                      "addressId=1, " +
                "city=Москва, " +
                "street=Лужники, " +
                "actTime=Sun Jan 01 19:12:01 MSK 2017]", clientOrm1.toString());
        ClientOrm clientOrm2 = clientsOrm.get(1);
        assertEquals("[id=2, " +
                "name=Остапов Никалай Сергеевич, " +
                      "addressId=2, " +
                "city=Москва, " +
                "street=Конова, " +
                "actTime=Sun Jan 01 19:12:01 MSK 2017]", clientOrm2.toString());
    }
}