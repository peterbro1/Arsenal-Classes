package me.gmx.arsenalclasses;

import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffectType;

public enum Alliance
{
  Red("Warrior", 
		ChatColor.DARK_RED, 
    	ChatColor.RED,
    	PotionEffectType.INCREASE_DAMAGE),  
  Blue("Paladin", 
		ChatColor.DARK_AQUA, 
		ChatColor.AQUA,
		PotionEffectType.DAMAGE_RESISTANCE),  
  Yellow("Bandit", 
		ChatColor.GOLD, 
		ChatColor.YELLOW,
		PotionEffectType.SPEED),  
  Green("Geologist", 
		ChatColor.DARK_GREEN, 
		ChatColor.GREEN,
		PotionEffectType.FAST_DIGGING),  
  Gray("Undead", 
		ChatColor.DARK_GRAY, 
		ChatColor.GRAY,
		PotionEffectType.HEALTH_BOOST),;
  
  private String name;
  private ChatColor color1;
  private ChatColor color2;
  private PotionEffectType potion;

  
  public String getName()
  {
    return this.name;
  }
  
  public ChatColor getColor1()
  {
    return this.color1;
  }
  
  public ChatColor getColor2()
  {
    return this.color2;
  }
  
  public PotionEffectType getPotionType() {
	  return this.potion;
  }
  
  private Alliance(String name, ChatColor color1, ChatColor color2, PotionEffectType potion)
  {
    this.name = name;
    this.color1 = color1;
    this.color2 = color2;
    this.potion = potion;
  }
  
  public static Alliance getAllianceFromName(String name){
	  for (Alliance a : Alliance.values()) {
		  if (name.equals(a.getName())) {
			  return a;
		  }
	  }
	return null;
  }
  
  public String betaString() {
	  StringBuilder result = new StringBuilder();
	  result = result.append(this.getColor1() + "" + ChatColor.BOLD);
	  for(int i = 0 ; i < name.length(); i++)
	  {
	     result = result.append(name.charAt(i));
	     if(i == name.length()-1)
	        break;
	     if (i % 2 == 0) {
	     result = result.append(this.getColor1() + "" + ChatColor.BOLD);
	     }else {
		     result = result.append(this.getColor2() + "" + ChatColor.BOLD);
	     }
	  }
	  result = result.append(ChatColor.RESET);

	 return (result.toString());
  }

}
