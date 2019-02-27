/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.sd.servidor;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Hugo
 */
public class PersistenceTest {

    public PersistenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByName method, of class Persistence.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "João da Silva";
        Persistence instance = new Persistence();
        Agenda result = instance.findByName(name);
        assertEquals(name, result.getName());
    }

    /**
     * Test of saveAgenda method, of class Persistence.
     */
    @Test
    public void testSaveAgenda() {
        System.out.println("saveAgenda");
        Agenda agenda = new Agenda();
        agenda.setName("lala");
        agenda.setPhone("1231-1231");
        Persistence instance = new Persistence();
        Integer expResult = 1;
        Integer result = instance.saveAgenda(agenda);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteAgenda method, of class Persistence.
     */
    @Test
    public void testDeleteAgenda() {
        System.out.println("deleteAgenda");
        String name = "lala";
        Persistence instance = new Persistence();
        Integer expResult = 1;
        Integer result = instance.deleteAgenda(name);
        assertEquals(expResult, result);
    }

}
