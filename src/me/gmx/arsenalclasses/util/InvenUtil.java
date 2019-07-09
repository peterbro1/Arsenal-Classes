package me.gmx.arsenalclasses.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.gmx.arsenalclasses.Alliance;


public class InvenUtil
{
  public static Inventory classI = Bukkit.createInventory(null, 9, "Select a Class");
  private static ItemStack BLUE;
  private static ItemStack GREEN;
  private static ItemStack RED;
  private static ItemStack YEL;
  private static ItemStack GRAY;
  
  
  public static Inventory getClassInv()
  {
	  BLUE = new ItemStack(Material.LAPIS_BLOCK, 1);
	    ItemMeta BLUEMETA = BLUE.getItemMeta();
	    BLUEMETA.setDisplayName(Alliance.Blue.getColor1() + Alliance.Blue.getName());
	    List<String> BLUELORE = new ArrayList();
	    Alliance.Blue.getColor2();
		BLUELORE.add(ChatColor.UNDERLINE + Alliance.Blue.getPotionType().getName());
	    //BLUELORE.add(Alliance.Blue.getColor1() + "SPEED I"); //buff
	    
	    BLUEMETA.setLore(BLUELORE);
	    
	    BLUE.setItemMeta(BLUEMETA);
	    classI.setItem(2, BLUE);
	    
	    GREEN = new ItemStack(Material.EMERALD_BLOCK, 1);
	    ItemMeta GREENMETA = GREEN.getItemMeta();
	    GREENMETA.setDisplayName(Alliance.Green.getColor1() + Alliance.Green.getName());
	    List<String> GREENLORE = new ArrayList();
	    Alliance.Green.getColor2();
		GREENLORE.add(ChatColor.UNDERLINE + Alliance.Green.getPotionType().getName()); //??
	   // GREENLORE.add(Alliance.Green.getColor1() + "SPEED II");
	    
	    GREENMETA.setLore(GREENLORE);
	    
	    GREEN.setItemMeta(GREENMETA);
	    classI.setItem(3, GREEN);
	    
	    YEL = new ItemStack(Material.GOLD_BLOCK, 1);
	    ItemMeta YELMETA = YEL.getItemMeta();
	    YELMETA.setDisplayName(Alliance.Yellow.getColor1() + Alliance.Yellow.getName());
	    List<String> YELLORE = new ArrayList();
	    Alliance.Yellow.getColor2();
		YELLORE.add(ChatColor.UNDERLINE + Alliance.Yellow.getPotionType().getName());
	    //YELLORE.add(Alliance.Yellow.getColor1() + "SPEED III"); //damage wave
	    
	    YELMETA.setLore(YELLORE);
	    
	    YEL.setItemMeta(YELMETA);
	    classI.setItem(4, YEL);
	    
	    RED = new ItemStack(Material.REDSTONE_BLOCK, 1);
	    ItemMeta REDMETA = RED.getItemMeta();
	    REDMETA.setDisplayName(Alliance.Red.getColor1() + Alliance.Red.getName());
	    List<String> REDLORE = new ArrayList();
	    Alliance.Red.getColor2();
		REDLORE.add(Alliance.Red.getPotionType().getName());
	    //REDLORE.add(Alliance.Red.getColor1() + "SPEED IV"); //cc wave
	    REDMETA.setLore(REDLORE);
	    
	    RED.setItemMeta(REDMETA);
	    classI.setItem(5, RED);
	    
	    GRAY = new ItemStack(Material.IRON_BLOCK, 1);
	    ItemMeta GRAYMETA = GRAY.getItemMeta();
	    GRAYMETA.setDisplayName(Alliance.Gray.getColor1() + Alliance.Gray.getName());
	    List<String> GRAYLORE = new ArrayList();
	    Alliance.Gray.getColor2();
		GRAYLORE.add(Alliance.Gray.getPotionType().getName());
	   // GRAYLORE.add(Alliance.Gray.getColor1() + "SPEED V"); //Protection field
	    //GRAYLORE.add(Alliance.Gray.getColor1() + "JUMP BOOST V"); //Protection field
	    GRAYMETA.setLore(GRAYLORE);
	    
	    GRAY.setItemMeta(GRAYMETA);
	    classI.setItem(6, GRAY);
	    return classI;
    
  }
  
  /*public static void createClass() {
	  
	  BLUE = new ItemStack(Material.LAPIS_BLOCK, 1);
	    ItemMeta BLUEMETA = BLUE.getItemMeta();
	    BLUEMETA.setDisplayName(Alliance.Blue.getName());
	    List<String> BLUELORE = new ArrayList();
	    Alliance.Blue.getColor2();
		BLUELORE.add(ChatColor.UNDERLINE + Alliance.Blue.getPotionType().getName());
	    //BLUELORE.add(Alliance.Blue.getColor1() + "SPEED I"); //buff
	    
	    BLUEMETA.setLore(BLUELORE);
	    
	    BLUE.setItemMeta(BLUEMETA);
	    classI.setItem(2, BLUE);
	    
	    GREEN = new ItemStack(Material.EMERALD_BLOCK, 1);
	    ItemMeta GREENMETA = GREEN.getItemMeta();
	    GREENMETA.setDisplayName(Alliance.Green.getName());
	    List<String> GREENLORE = new ArrayList();
	    Alliance.Green.getColor2();
		GREENLORE.add(ChatColor.UNDERLINE + Alliance.Green.getPotionType().getName()); //??
	   // GREENLORE.add(Alliance.Green.getColor1() + "SPEED II");
	    
	    GREENMETA.setLore(GREENLORE);
	    
	    GREEN.setItemMeta(GREENMETA);
	    classI.setItem(3, GREEN);
	    
	    YEL = new ItemStack(Material.GOLD_BLOCK, 1);
	    ItemMeta YELMETA = YEL.getItemMeta();
	    YELMETA.setDisplayName(Alliance.Yellow.getName());
	    List<String> YELLORE = new ArrayList();
	    Alliance.Yellow.getColor2();
		YELLORE.add(ChatColor.UNDERLINE + Alliance.Yellow.getPotionType().getName());
	    //YELLORE.add(Alliance.Yellow.getColor1() + "SPEED III"); //damage wave
	    
	    YELMETA.setLore(YELLORE);
	    
	    YEL.setItemMeta(YELMETA);
	    classI.setItem(4, YEL);
	    
	    RED = new ItemStack(Material.REDSTONE_BLOCK, 1);
	    ItemMeta REDMETA = RED.getItemMeta();
	    REDMETA.setDisplayName(Alliance.Red.getColor1() + Alliance.Red.getName());
	    List<String> REDLORE = new ArrayList();
	    Alliance.Red.getColor2();
		REDLORE.add(Alliance.Red.getPotionType().getName());
	    //REDLORE.add(Alliance.Red.getColor1() + "SPEED IV"); //cc wave
	    REDMETA.setLore(REDLORE);
	    
	    RED.setItemMeta(REDMETA);
	    classI.setItem(5, RED);
	    
	    GRAY = new ItemStack(Material.IRON_BLOCK, 1);
	    ItemMeta GRAYMETA = GRAY.getItemMeta();
	    GRAYMETA.setDisplayName(Alliance.Gray.getColor1() + Alliance.Gray.getName());
	    List<String> GRAYLORE = new ArrayList();
	    Alliance.Gray.getColor2();
		GRAYLORE.add(Alliance.Gray.getPotionType().getName());
	   // GRAYLORE.add(Alliance.Gray.getColor1() + "SPEED V"); //Protection field
	    //GRAYLORE.add(Alliance.Gray.getColor1() + "JUMP BOOST V"); //Protection field
	    GRAYMETA.setLore(GRAYLORE);
	    
	    GRAY.setItemMeta(GRAYMETA);
	    classI.setItem(6, GRAY);
  }*/
  
  public static void classSelInv(Player p)
  {
    BLUE = new ItemStack(Material.LAPIS_BLOCK, 1);
    ItemMeta BLUEMETA = BLUE.getItemMeta();
    BLUEMETA.setDisplayName(Alliance.Blue.getColor1() + Alliance.Blue.getName());
    List<String> BLUELORE = new ArrayList();
    Alliance.Blue.getColor2();
	BLUELORE.add(ChatColor.UNDERLINE + Alliance.Blue.getPotionType().getName());
    //BLUELORE.add(Alliance.Blue.getColor1() + "SPEED I"); //buff
    
    BLUEMETA.setLore(BLUELORE);
    
    BLUE.setItemMeta(BLUEMETA);
    classI.setItem(2, BLUE);
    
    GREEN = new ItemStack(Material.EMERALD_BLOCK, 1);
    ItemMeta GREENMETA = GREEN.getItemMeta();
    GREENMETA.setDisplayName(Alliance.Green.getColor1() + Alliance.Green.getName());
    List<String> GREENLORE = new ArrayList();
    Alliance.Green.getColor2();
	GREENLORE.add(ChatColor.UNDERLINE + Alliance.Green.getPotionType().getName()); //??
   // GREENLORE.add(Alliance.Green.getColor1() + "SPEED II");
    
    GREENMETA.setLore(GREENLORE);
    
    GREEN.setItemMeta(GREENMETA);
    classI.setItem(3, GREEN);
    
    YEL = new ItemStack(Material.GOLD_BLOCK, 1);
    ItemMeta YELMETA = YEL.getItemMeta();
    YELMETA.setDisplayName(Alliance.Yellow.getColor1() + Alliance.Yellow.getName());
    List<String> YELLORE = new ArrayList();
    Alliance.Yellow.getColor2();
	YELLORE.add(ChatColor.UNDERLINE + Alliance.Yellow.getPotionType().getName());
    //YELLORE.add(Alliance.Yellow.getColor1() + "SPEED III"); //damage wave
    
    YELMETA.setLore(YELLORE);
    
    YEL.setItemMeta(YELMETA);
    classI.setItem(4, YEL);
    
    RED = new ItemStack(Material.REDSTONE_BLOCK, 1);
    ItemMeta REDMETA = RED.getItemMeta();
    REDMETA.setDisplayName(Alliance.Red.getColor1() + Alliance.Red.getName());
    List<String> REDLORE = new ArrayList();
    Alliance.Red.getColor2();
	REDLORE.add(Alliance.Red.getPotionType().getName());
    //REDLORE.add(Alliance.Red.getColor1() + "SPEED IV"); //cc wave
    REDMETA.setLore(REDLORE);
    
    RED.setItemMeta(REDMETA);
    classI.setItem(5, RED);
    
    GRAY = new ItemStack(Material.IRON_BLOCK, 1);
    ItemMeta GRAYMETA = GRAY.getItemMeta();
    GRAYMETA.setDisplayName(Alliance.Gray.getColor1() + Alliance.Gray.getName());
    List<String> GRAYLORE = new ArrayList();
    Alliance.Gray.getColor2();
	GRAYLORE.add(Alliance.Gray.getPotionType().getName());
   // GRAYLORE.add(Alliance.Gray.getColor1() + "SPEED V"); //Protection field
    //GRAYLORE.add(Alliance.Gray.getColor1() + "JUMP BOOST V"); //Protection field
    GRAYMETA.setLore(GRAYLORE);
    
    GRAY.setItemMeta(GRAYMETA);
    classI.setItem(6, GRAY);
    
    
    p.openInventory(classI);
  }
  
  
  
  
  public ItemStack getBlue()
  {
    return BLUE;
  }
  
  public ItemStack getGreen()
  {
    return GREEN;
  }
  
  public ItemStack getRed()
  {
    return GREEN;
  }
  
  public ItemStack getYel()
  {
    return GREEN;
  }
  
  public ItemStack getGray(){
	  return GRAY;
  }
}
