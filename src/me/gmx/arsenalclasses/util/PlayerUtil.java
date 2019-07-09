package me.gmx.arsenalclasses.util;

import java.util.Map;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import me.gmx.arsenalclasses.Alliance;
import me.gmx.arsenalclasses.ArsenalClasses;



public class PlayerUtil {

	
	
	
	
	private static ArsenalClasses ins;
	public PlayerUtil(ArsenalClasses ins){
		PlayerUtil.ins = ins;
	}
	
	//working
  public static void addToAlliance(Player p, Alliance a)
  {
	  if (isPlayerInAlliance(p)){
		  return;
	  }
	  p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_SPLASH, 4, 4);
      ParticleUtil.createHelix(p,Effect.VILLAGER_THUNDERCLOUD);
		ins.getConfig().getConfigurationSection("classes").set(p.getName(), a.getName());
		p.sendMessage(ArsenalClasses.prefix + a.getColor2() + "You have joined " + a.getColor1() + a.getName());
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 2, 5);
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 2, 5);
		ParticleUtil.helixParticle(p);
    	ins.saveConfig();
    	giveClassEffect(p);
    
  }
  
  public static void giveClassEffect(Player p) {
  //1.12	p.addPotionEffect(new PotionEffect(PlayerUtil.getAlliance(p).getPotionType(), Integer.MAX_VALUE, 1, true, false)); // create a new potion effect with type Speed then set the duration to the maximum integer value, and the potion's "power" level to 1, and the last two booleans disable the annoying particle  effects. (ambient) and (particles)
  	p.addPotionEffect(new PotionEffect(PlayerUtil.getAlliance(p).getPotionType(), Integer.MAX_VALUE, 1, false)); // create a new potion effect with type Speed then set the duration to the maximum integer value, and the potion's "power" level to 1, and the last two booleans disable the annoying particle  effects. (ambient) and (particles)

  }
  
  public static void removeFromAlliance(Player p){
	  
	  if (!isPlayerInAlliance(p)){
		  return;
	  }
	  	p.removePotionEffect(PlayerUtil.getAlliance(p).getPotionType());
		ins.getConfig().getConfigurationSection("classes").set(p.getName(), null);
		p.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "You have been removed from your alliance");
    	ins.saveConfig();
    	
  }
  
  //??????
  public static boolean isPlayerInAlliance(Player p)
  {
	  if (ins.getConfig().getConfigurationSection("classes").getKeys(true) == null) {
		  return false;
	  }
	  
	  
	  try {
    if (ins.getConfig().getConfigurationSection("classes").getKeys(true).contains(p.getName())){
    	return true;
    }else
    return false;
	  }catch(NullPointerException e) {
		  //e.printStackTrace();
		  ins.log.log(Level.WARNING,"Failed to retrieve");
		  return false;
	  }
  }
  
  //????
  public static Alliance getAlliance(Player p)
  {
    Map<String, Object> names = ins.getConfig().getConfigurationSection("classes").getValues(true);
    if (names.keySet().contains(p.getName())){
    	return Alliance.getAllianceFromName(names.get(p.getName()).toString());
    }else
    return null;
  }
  
  public static String getTagFromPlaytime(Alliance a, int playtime) {
	  //String[] strat;
	  double seconds,minutes,hours,days,weeks;
	  seconds = playtime/20;
	  minutes = seconds/60;
	  hours = minutes/60;
	  days = hours/24;
	  weeks = days/7;
	  ChatColor one,two;
	  one = a.getColor1();
	  two = a.getColor2();
	  String name = a.getName();
	 /* strat = new String[] {
			  (one + name),
			  (one + "[" + name + "]"),
			  (two + "[" +one + name + two + "]"),
			  (two + "{" + one + name + two + "}"),
			  (two + "-{" + one + ChatColor.BOLD + name + two + "}-"),
			  (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-{" + ChatColor.BOLD + a.betaString() + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}-" ),
			   (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-={" + ChatColor.UNDERLINE + a.betaString() + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}=-" ),
			   (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-={" + ChatColor.GOLD + "§k!!" +  ChatColor.UNDERLINE + a.betaString() + ChatColor.GOLD + "§k!!" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}=-" )
			  
	  };
	  return strat;*/
		  if (playtime < 72000) {//less than one
			  return (one + name);
		  }else if (playtime >= 72000 && playtime < 360000) { //1-5 HR
			  return (one + "[" + name + "]");
		  }else if (playtime >= 72000 && playtime < 864000) { // 5-12 HR
			  return (two + "[" +one + name + two + "]");
		  }else if (playtime >= 1728000 && playtime < 3456000) { //  1day - 1.99day
			  return (two + "{" + one + name + two + "}");
		  }else if (playtime >= 3456000 && playtime < 8640000) { //2day - 4.99day
			  return (two + "-{" + one + ChatColor.BOLD + name + two + "}-");
		  }else if (playtime >= 8640000 && playtime < 17280000) { // 5day - 9.99day
			 return (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-{" + ChatColor.BOLD + a.betaString() + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}-" );
		  }else if (playtime >= 17280000 && playtime < 34560000) {// 10day - 19.99day
			  return (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-={" + ChatColor.UNDERLINE + a.betaString() + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}=-" );
		  }else if (days >= 20) { // 20day+ o_o
			  return (ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "-={" + ChatColor.GOLD + "§k!!" +  ChatColor.UNDERLINE + a.betaString() + ChatColor.GOLD + "§k!!" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "}=-" );
		  }else {
			  return "unfinished";
		  }
		  
	  
	  
	  
	  
  }
  
  
  
  
}
