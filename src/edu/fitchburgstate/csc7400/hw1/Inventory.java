package edu.fitchburgstate.csc7400.hw1;
/*
 * class:Object Oriented Analysis and Design
 *Instructor:Orlando Montalvo
 *Assignment:Homework 1
 *Student Name:Kyathiboppana 
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
*Inventory contains all information about guitars that are available in store which will be 
* helpful for customers to find suitable guitars.
*
* @author Kboppana
*
*/

public class Inventory {
  private List<Guitar> guitars;
  /**
  *This inventory contains list of all guitars
  *the rick availble currently
     *constructor
     *@param serialNumber
     *@param price
     *@param builder
     *@param model
     *@param type
     *@param backwood
     *@param topWood
     */
  
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  /**
  *This method add guitar takes serial number,model,builder,type,backwood,topwood,price to add a guitar
  *And to create a new guitar instance
  *and adds to rick inventory
  *
  */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
   /**
   *Returns about guitar particulars based on serial number
   *@param serialNumber
   *@return guitar object
   *
   */
  
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  /**
  * Customer provides guitar particulars so that it search for matching guitar in inventory 
  *if there returns information else return Null 
  *@param Search for specific type of guitar
  *@return guitar from ricks collection inventory or null
  */
  
  public Guitar search(Guitar searchGuitar) {
    //has next returns true if it has more guitars elements to iterate 
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      //It returns the next element in the list
        //@exception-if no next element in list,It throws  'NoSuchElementException'
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      /**Returns the name of the manufacturer and stores in the string  builder
      */
     
       String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getManufacturer())))
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equals(guitar.getType())))
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitar.getBackWood())))
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitar.getTopWood())))
        continue;
      return guitar;
    }
    return null;
  }
}
