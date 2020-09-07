package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.services.Market;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Responsible for testing service
 */
public class MarketTest {

    private static Market market;

    @BeforeClass public static void start() {
        market = new Market();
    }

    @AfterClass public static void stop() throws Exception {
        market = null;
    }

    /**
     * Method responsible for testing market logic
     * @throws Exception
     */
    @Test public void testMarket() throws Exception {
        HashMap<Enum, Integer> actual = new HashMap<>();
        actual.put(Market.Item.APPLE, 5);
        actual.put(Market.Item.TOMATO, 3);
        market.addItem(Market.Item.TOMATO, 3);
        market.addItem(Market.Item.APPLE, 5);
        assertEquals(43, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
        market.addItem(Market.Item.APPLE, 2);
        market.addItem(Market.Item.APPLE, -1);
        market.addItem(Market.Item.APPLE, -1);
        assertEquals(43, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
        actual.put(Market.Item.BREAD, -4);
        market.addItem(Market.Item.BREAD, -4);
        assertEquals(23, market.calculatePrice());
        comparatorHashMap(actual, Market.shopList);
    }

    /**
     * Method responsible for testing market logic in case of user input error
     */
    @Test public void testExc(){
        String test = "Onion 54";
        try {
            market.parseInt(test);
            fail("Exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Cannot parse " + test + " to integer..");
        }

        try{
            market.parseEnum(test);
            fail("Exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "We do not have item: " + test + " in our item list..");
        }
    }

    /**
     * Method responsible for compare thwo hashmaps each other
     * @param actual
     * @param expected
     */
    private void comparatorHashMap(HashMap<Enum, Integer> actual, HashMap<Enum, Integer> expected){
        int c1 = 0;
        for (Map.Entry<Enum, Integer> elementActual : actual.entrySet()){
            int c2 = 0;
            for (Map.Entry<Enum, Integer> elementExcepted : expected.entrySet()){
                if (c1==c2){
                    assertEquals(elementActual.getKey(), elementExcepted.getKey());
                    assertEquals(elementActual.getValue(), elementExcepted.getValue());
                    break;
                }
                c2++;
            }
            c1++;
        }
    }
}