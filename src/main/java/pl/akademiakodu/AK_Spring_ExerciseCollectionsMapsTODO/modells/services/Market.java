package pl.akademiakodu.AK_Spring_ExerciseCollectionsMapsTODO.modells.services;

/**
 * Imports section
 */

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Responsible for market exercise, calculations connecting with market management
 */
@Service
public class Market {

    /**
     * Declaration variables
     */
    public enum Item {POTATO, ONION, TOMATO, CUCUMBER, GARLIC, PEPER, APPLE, BREAD}

    public static HashMap<Enum, Integer> shopList;

    /**
     * With constructor initialization our shoplist
     */
    public Market() {
        shopList = new HashMap<>();
    }

    /**
     * Method responsible for adding given item and their quantity to defined shop list(static here)
     *
     * @param item
     * @param qty
     */
    public void addItem(Item item, int qty) {
        if (shopList.containsKey(item))
            shopList.put(item,shopList.get(item)+qty);
        else shopList.put(item,qty);
    }

    /**
     * Method generating string containing all items with their qty from our shop list
     *
     * @return
     */
    public String showCurrentList() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Enum, Integer> element : shopList.entrySet()) {
            sb.append("Item: " + element.getKey() + " = " + element.getValue() + "pcs; *** ");
        }
        return sb.toString();
    }

    /**
     * Method responsible for calculation total price of our shop list
     *
     * @return total shop list price
     */
    public int calculatePrice() {
        //todo
//        int sum=0;
//        for (Map.Entry<Enum, Integer> element : shopList.entrySet()){
//           sum+=element.getValue()*element.getKey().toString().length();
//        }
//        return sum;
        int sum = 0;
        for (Map.Entry<Enum, Integer> item : shopList.entrySet()) {
            int price = item.getKey().toString().length();
            int value = item.getValue();
            sum += value * price;
        }
        return sum;
    }

    /**
     * Method responsible for parsing given string to integer if possible
     *
     * @param s string
     * @return integer
     */
    public int parseInt(String s) {
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot parse " + s + " to integer..");
        }
        return result;
    }

    /**
     * Method responsible for parsing given string to enum if possible
     *
     * @param s string
     * @return enum
     */
    public Item parseEnum(String s) {
        Item result = null;
        List<Item> tempList = getItems();
        for (Item item : tempList) {
            if (s.equals(item.toString())) {
                return item;
            }
        }
        throw new IllegalArgumentException("We do not have item: " + s + " in our item list..");
    }

    /**
     * method responsible to store every item to string
     *
     * @return string containing all current available items in market
     */
    public String showAllItems() {
        StringBuilder sb = new StringBuilder();
        sb.append("Items: ");
        for (Item item : getItems()) {
            sb.append(item.toString() + ", ");
        }
        return sb.toString();
    }

    /**
     * Get list of available items
     */
    public List<Item> getItems() {
        return Arrays.asList(Item.POTATO, Item.ONION, Item.TOMATO, Item.CUCUMBER, Item.GARLIC,
                Item.PEPER, Item.APPLE, Item.BREAD);
    }

}
