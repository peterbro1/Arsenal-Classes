package me.gmx.arsenalclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.gmx.arsenalclasses.util.PlayerUtil;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.PlayerData;
public class DefaultListeners 
implements Listener{
	
	private ArsenalClasses ins;
	public DefaultListeners(ArsenalClasses ins) {
		this.ins = ins;
	}
	
	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
	public void playerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if ((PlayerUtil.getAlliance(p) == null)) {
			return;
		}
		
		
		
		
		try {
		e.setFormat(PlayerUtil.getTagFromPlaytime(PlayerUtil.getAlliance(p), p.getStatistic(Statistic.PLAY_ONE_TICK)) + "%s> %s");
		}catch (Exception ex) {
			p.getStatistic(Statistic.PLAY_ONE_TICK);
			ins.log.warning(ins.prefix + "Player " + p.getName() + " tried to chat without being in a class. Error handled.");
			return;
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		 PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(e.getPlayer().getUniqueId());
         Claim claim = GriefPrevention.instance.dataStore.getClaimAt(e.getBlock().getLocation(), true, playerData.lastClaim);
         
         if(claim == null)
         {
        	 
        	// Bukkit.broadcastMessage("claim == null");
        	 //Bukkit.broadcastMessage(String.valueOf(e.getPlayer().getItemInHand().getTypeId()));
             return;
         }else {
        	// Bukkit.broadcastMessage("claim belong to " + claim.getOwnerName());
         }
         
         //must have permission to edit the land claim you're in
         String errorMessage = claim.allowEdit(e.getPlayer());
         if(errorMessage != null)
         {
        	 if (e.getPlayer().getItemInHand().getTypeId() == 4140 || e.getPlayer().getItemInHand().getTypeId() == 7790) {
            	 e.setCancelled(true);
        	 }
        	//Bukkit.broadcastMessage("error message, no permission == null");

        	//Bukkit.broadcastMessage(String.valueOf(e.getPlayer().getItemInHand().getTypeId()));

         }
	}
	
	@EventHandler
	public void playerRespawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		if (PlayerUtil.isPlayerInAlliance(p)) {
			new BukkitRunnable() {public void run() {
				PlayerUtil.giveClassEffect(p);
				
			}}.runTaskLater(ins,20);
		}
	}
	
	
	
	/*@EventHandler
	public void inventoryClose(InventoryCloseEvent e) {

		if (e.getInventory().getName().equals("Select a Class")) {
			if (PlayerUtil.isPlayerInAlliance((Player)e.getPlayer())) {
			InvenUtil.classSelInv((Player)e.getPlayer());
			}
		}
	}*/
	
	 @EventHandler
	  public void inventoryInteract(InventoryClickEvent e)
	  {
	    if ((!e.getInventory().getName().equals("Select a Class"))) {
	      
	    	//Bukkit.broadcastMessage(ins.prefix + "Not a problem- Not correct inventory");
	    	return;
	    }
	    Player p = (Player)e.getWhoClicked();
	   // Bukkit.broadcastMessage(e.getCurrentItem().getItemMeta().getDisplayName());
	   // Bukkit.broadcastMessage(e.getCurrentItem().getItemMeta().getDisplayName().toString());
	   // Bukkit.broadcastMessage(Alliance.Red.name());
	    if (!e.getCurrentItem().hasItemMeta()) {
	    	e.setCancelled(true);
	    	return;
	    }
	    
	    try {
	    if (!PlayerUtil.isPlayerInAlliance(p))
	    {
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Alliance.Red.getColor1() + Alliance.Red.getName())) {
	        PlayerUtil.addToAlliance(p, Alliance.Red);
	        e.setCancelled(true);
		    p.closeInventory();
	      } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Alliance.Blue.getColor1() + Alliance.Blue.getName())) {
	        PlayerUtil.addToAlliance(p, Alliance.Blue);
	        e.setCancelled(true);
		    p.closeInventory();
	      } else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(Alliance.Yellow.getColor1() + Alliance.Yellow.getName())) {
	        PlayerUtil.addToAlliance(p, Alliance.Yellow);
	        e.setCancelled(true);
		    p.closeInventory();
	      } else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(Alliance.Green.getColor1() + Alliance.Green.getName())) {
	        PlayerUtil.addToAlliance(p, Alliance.Green);
	        e.setCancelled(true);
		    p.closeInventory();
	      }else if  (e.getCurrentItem().getItemMeta().getDisplayName().equals(Alliance.Gray.getColor1() + Alliance.Gray.getName())) {
	    	  PlayerUtil.addToAlliance(p, Alliance.Gray);
	    	  e.setCancelled(true);
	  	    p.closeInventory();
	      }
	      
	    }
	    else {
	      p.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "You are already in a class!");
	      return;
	    }
	    }catch(Exception ex) {
	    	ins.log.warning("Issue while trying to fetch item meta /// arsenal");
	    }
	    
	    
	    e.setCancelled(true);
	    
	    
	  }
	 
	 @EventHandler
	 public void entityInteract(PlayerInteractEvent e) {

		// Bukkit.broadcastMessage(e.getPlayer().getItemInHand().getType().name());
		 
		 //PlayerData playerData = GriefPrevention.instance.dataStore.getPlayerData(e.getPlayer().getUniqueId());
         //Claim claim = GriefPrevention.instance.dataStore.getClaimAt(e.getRightClicked().getLocation(), true, playerData.lastClaim);
         
         //if(claim == null)
         //{
        	 
        //     return;
        /// }else {
        	 
        // }
         

	 }
	 @EventHandler
	 public void entitypInteractEvent(PlayerInteractEntityEvent e) {
		// Bukkit.broadcastMessage(e.getPlayer().getItemInHand().getType().name());
	 }
	

}
