package me.gmx.arsenalclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import me.gmx.arsenalclasses.util.InvenUtil;
import me.gmx.arsenalclasses.util.PlayerUtil;


public class SpecialListeners implements Listener{
	private ArsenalClasses ins;
	public SpecialListeners(ArsenalClasses ins) {
		this.ins = ins;
	}
	
	
	  
	  @EventHandler
	  public void playerInventoryClose(InventoryCloseEvent e)
	  {
		  if (e.getPlayer() instanceof Player)
		  {
			
		  if (e.getInventory() == InvenUtil.getClassInv())
		  {
			  
		   if (!PlayerUtil.isPlayerInAlliance((Player)e.getPlayer()))
		   {
			  		//InvenUtil.classSelInv((Player)e.getPlayer());
		      }else { ;}
		    }
		  }
	  }
	
	
	
	
	 @EventHandler
	  public void playerJoin(PlayerJoinEvent e)
	  {
	    final Player p = e.getPlayer();
	    Bukkit.broadcastMessage("test");
	   // if(p.hasPlayedBefore()){
	   //	return;
	  //  }
	    new BukkitRunnable() {
	    	@Override
			public void run() {
	    	
	    		if (!PlayerUtil.isPlayerInAlliance(p))
	    	    {

	    		    p.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "Hello player, Please select a class using /arsenalclasses class");
	    	    InvenUtil.classSelInv(e.getPlayer());
	    				  
	    	    	
	    	    }else
	    	    {			 
	        	//1.12 p.addPotionEffect(new PotionEffect(PlayerUtil.getAlliance(p).getPotionType(), Integer.MAX_VALUE, 1,true, false)); // create a new potion effect with type Speed then set the duration to the maximum integer value, and the potion's "power" level to 1, and the last two booleans disable the annoying particle  effects. (ambient) and (particles)
		        	p.addPotionEffect(new PotionEffect(PlayerUtil.getAlliance(p).getPotionType(), Integer.MAX_VALUE, 1,false)); // create a new potion effect with type Speed then set the duration to the maximum integer value, and the potion's "power" level to 1, and the last two booleans disable the annoying particle  effects. (ambient) and (particles)

	    	    }
	    		
	    		
	    }}.runTaskLater(ins, 40);
	    
	  }
	 
	 
	
	
}
