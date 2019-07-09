package me.gmx.arsenalclasses;

import java.text.Format;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.gmx.arsenalclasses.util.InvenUtil;
import me.gmx.arsenalclasses.util.PlayerUtil;


public class Commands implements CommandExecutor{

	private ArsenalClasses ins;
	public Commands(ArsenalClasses ins) {
		this.ins = ins;
	}
	
	private ArrayList<UUID> afk = new ArrayList<UUID>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		
		final Player p = ((Player)sender);
		
		
		/*for (Alliance a : Alliance.values()) {
			for (String st : PlayerUtil.getTagFromPlaytime(a, 0)) {
				Bukkit.broadcastMessage(ins.prefix +st);
			}
		}
		if (cmd.getName().equalsIgnoreCase("afk")) {
			if (!(sender instanceof Player)) {return false;}
			if (afk.contains(p.getUniqueId())) {
				afk.remove(p.getUniqueId());
				p.setStatistic(Statistic.PLAY_ONE_TICK, (int)ins.getConfig().get("afk." + p.getUniqueId()));
				ins.saveConfig();
				
			}
			afk.add(p.getUniqueId());
			ins.getConfig().set("afk." + p.getUniqueId(), p.getStatistic(Statistic.PLAY_ONE_TICK));
			ins.saveConfig();
			
		}*/		
		    if (cmd.getName().equalsIgnoreCase("arsenalclasses"))
		    {
		      if (args.length == 0)
		      {
		    	 // ParticleUtil.createHelix((Player)sender, Effect.SPELL);
		        sender.sendMessage(ChatColor.GOLD + "|====================|");
		        sender.sendMessage(" ");
		        sender.sendMessage(ArsenalClasses.prefix + ChatColor.AQUA + "Created by GMX, used by Arsenal Network");
		        sender.sendMessage(" ");
		        sender.sendMessage(ChatColor.GOLD + "|====================|");
		        sender.sendMessage(" ");
		        sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "/ac remove [Player]" + ChatColor.YELLOW + " Removes player's class");
		        sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "/ac chooseclass [Player]" + ChatColor.YELLOW + " - Opens class selection menu for specified player");
		        sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "/ac list" + ChatColor.YELLOW + " - Lists all players' chosen classes.");
		        sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "/ac class" + ChatColor.YELLOW + " - Allows a player to bring up the class selection GUI.");
		       /* sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war listcd" + ChatColor.YELLOW + " - Lists all players' cooldown timers.");
		        sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war class" + ChatColor.YELLOW + " - Open class selection menu!");
		        sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war setcd [Monk,Riftwalker,etc] [int] " + ChatColor.YELLOW + " - Changes ability cooldowns");
		        sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war nocooldowns [Playername]" + ChatColor.YELLOW + " - Toggles cooldown restrictions");
		        sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war remove [Playername]" + ChatColor.YELLOW + " - Removes a player from his/her alliance.");
		        sender.sendMessage(ins.prefix + ChatColor.GOLD + "/war createwand" + ChatColor.YELLOW + " - Spawns an instance of the relic wand.");   */



		        return true;
		      }else if (args.length == 1) 
		      {
		    	 /* p.setStatistic(Statistic.PLAY_ONE_TICK, Integer.parseInt(args[0]));
		    	  ins.saveConfig();
		    	  return true;*/
		    	  
		    	  
		    	  if (args[0].equalsIgnoreCase("class")) {
		    		  if (sender instanceof Player) {
		    			  if (!PlayerUtil.isPlayerInAlliance((Player)sender)) {
		    				  InvenUtil.classSelInv((Player)sender);
		    				  return true;
		    			  }else {
		    				  sender.sendMessage(ins.prefix + ChatColor.GOLD + "You have already chosen a class!");
		    				  return true;
		    			  }
		    		  }
		    	  }
		    	  
		    	  
		    	  
		    	  if (args[0].equalsIgnoreCase("list")) 
		    	  {
			    	  if (!sender.hasPermission("ac.list") && !sender.isOp()) {sender.sendMessage(ArsenalClasses.prefix + ChatColor.DARK_RED + "Insufficient permission"); return true;}

		        	 ins.reloadConfig();
		        	  Map<String, Object> hash = ins.getConfig().getConfigurationSection("classes").getValues(true);
		        	  for (String s : hash.keySet()){//names
		        		  sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + s + ChatColor.YELLOW + " " +
		        	  Alliance.getAllianceFromName(ins.getConfig().getConfigurationSection("classes").get(s).toString()).getName());
		        	  }
		        	 
		        	  
		          }	    	  
		    	  
		    	  
		      }else if (args.length == 2) 
		      {
		    	//remove from alliance
		    	  if (args[0].equalsIgnoreCase("remove"))
		    	  {
		    	  if (!sender.hasPermission("ac.removefromclass") && !sender.isOp()) {sender.sendMessage(ArsenalClasses.prefix + ChatColor.DARK_RED + "Insufficient permission"); return true;}
		    	  
		        		if (Bukkit.getPlayer(args[1]) != null
		        				&& PlayerUtil.isPlayerInAlliance(Bukkit.getPlayer(args[1]))){
		        			PlayerUtil.removeFromAlliance(Bukkit.getPlayer(args[1]));
		        			sender.sendMessage(ArsenalClasses.prefix + ChatColor.RED + args[1] + " has been removed from the class table");
		        			return true;
		        		}else{
		        			sender.sendMessage(ArsenalClasses.prefix + ChatColor.GOLD + "Specified player is either offline or has not chosen a class");
		        			return true;
		        		}
		        		
		        		//open menu
		    	  }else if (args[0].equalsIgnoreCase("chooseclass")) {
			    	  if (!sender.hasPermission("ac.forceclassscreen") && !sender.isOp()) {sender.sendMessage(ArsenalClasses.prefix + ChatColor.DARK_RED + "Insufficient permission"); return true;}
			    	  if (Bukkit.getPlayer(args[1]) == null) {sender.sendMessage(ArsenalClasses.prefix + ChatColor.DARK_RED + "Player does not exist");return false;}
			    	  InvenUtil.classSelInv(Bukkit.getPlayer(args[1]));
			    	  sender.sendMessage(ArsenalClasses.prefix+ ChatColor.GREEN + "Opened menu for player: " + ChatColor.DARK_GREEN + args[1]);
			    	  return true;

		    	  }
		    	  
		    	  
		      }
		    }
		//
	 return false; }
}
