/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.cor.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author hassenibrahim
 */
public class EntityTest {

    public EntityTest() {
    }

    /**
     * Test of setHealth method, of class Entity.
     */
    @Test
    public void testSetHealth() {
        System.out.println("setHealth");
        Entity instance = new EntityImpl();
        instance.setHealth(100);
        assertEquals(100, instance.getHealth());
    }

    /**
     * Test of setShield method, of class Entity.
     */
    @Test
    public void testSetShieldExceedsMaxShield() {
        System.out.println("setShield");
        Entity instance = new EntityImpl();
        instance.setShield(instance.getMaxShield() + 10);
        assertEquals(instance.getMaxShield(), instance.getShield());
    }

    /**
     * Test of setAttack method, of class Entity.
     */
    @Test
    public void testSetAttack() {
        System.out.println("setAttack");
        Entity instance = new EntityImpl();
        instance.setAttack(50);
        assertEquals(50, instance.getAttack());
    }

    /**
     * Test of getHealth method, of class Entity.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Entity instance = new EntityImpl();
        assertEquals(0, instance.getHealth());
        instance.setHealth(75);
        assertEquals(75, instance.getHealth());
    }

    /**
     * Test of getShield method, of class Entity.
     */
    @Test
    public void testGetShield() {
        System.out.println("getShield");
        Entity instance = new EntityImpl();
        assertEquals(0, instance.getShield());
        instance.setShield(200);
        assertEquals(200, instance.getShield());
    }

    /**
     * Test of getAttack method, of class Entity.
     */
    @Test
    public void testGetAttack() {
        System.out.println("getAttack");
        Entity instance = new EntityImpl();
        assertEquals(0, instance.getAttack());
        instance.setAttack(30);
        assertEquals(30, instance.getAttack());
    }

    /**
     * Test of getMaxHealth method, of class Entity.
     */
    @Test
    public void testGetMaxHealth() {
        System.out.println("getMaxHealth");
        Entity instance = new EntityImpl();
        assertEquals(200, instance.getMaxHealth());
        instance.setHealth(300);
        assertEquals(200, instance.getHealth());
    }

    /**
     * Test of getMaxAttack method, of class Entity.
     */
    @Test
    public void testGetMaxAttack() {
        System.out.println("getMaxAttack");
        Entity instance = new EntityImpl();
        assertEquals(150, instance.getMaxAttack());
        instance.setAttack(200);
        assertEquals(150, instance.getAttack());
    }

    /**
     * Test of getMaxShield method, of class Entity.
     */
    @Test
    public void testGetMaxShield() {
        System.out.println("getMaxShield");
        Entity instance = new EntityImpl();
        assertEquals(300, instance.getMaxShield());
        instance.setShield(400);
        assertEquals(300, instance.getShield());
    }

    /**
     * Test of setup method, of class Entity.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        Entity instance = new EntityImpl();
        instance.setup();
        assertEquals(0, instance.getHealth());
    }

    /**
     * Test of toString method, of class Entity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Entity instance = new EntityImpl();
        instance.setHealth(100);
        instance.setAttack(30);
        instance.setShield(60);
        String result = instance.toString();
        assertEquals("health: 100 - attack: 30 - shield: 60", result);
    }

    public class EntityImpl extends Entity {
        @Override
        public void setup() {
        }
    }

}
