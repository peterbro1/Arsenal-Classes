package me.gmx.arsenalclasses.util;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.gmx.arsenalclasses.ArsenalClasses;

public class ParticleUtil {
	private static ArsenalClasses ins;
	public ParticleUtil(ArsenalClasses ins) {
		ParticleUtil.ins = ins;
	}
	public static void helixParticle(Player player)
	  {
	    double radius = 0.8D;
	    new BukkitRunnable() {
            double y = 0.0D;
	    	@Override
			public void run() {
	    		double x = radius * Math.cos(y);
	    	    double z = radius * Math.sin(y);
	    			Location loc = player.getLocation();
	    		 	Location loc2 = new Location(player.getWorld(), loc.getX() + x, loc.getY() + y + 0.05D, loc.getZ() + z, (int)radius, (int)radius);
	    		    player.getWorld().playEffect(loc2, Effect.COLOURED_DUST, 0);
	    		    Location loc3 = new Location(player.getWorld(), loc.getX() - x, loc.getY() + y + 0.05D, loc.getZ() - z, (int)radius, (int)radius);
	    		    player.getWorld().playEffect(loc3, Effect.COLOURED_DUST, 0);
	    		
	              this.y += 0.05D;
	              if (this.y >= 10.0D) {
	                cancel();
	              }
	    	}
	    }.runTaskTimer(ins, 5, 1L);
	    
	    
	   
	  }
	
	public static void createHelix(Player player, Effect effect) {
	    Location loc = player.getLocation();
	    int radius = 2;
	    new BukkitRunnable() {
	    	double t = 0;
	    	@Override
			public void run() {
	    	t++;
	    	if (t>10) {
	    		cancel();
	    	}
	    	
	    	 for(double y = 0; y <= 50; y+=0.08) {
	    		 
	 	        double x = radius * Math.cos(y- (t/2));
	 	        double z = radius * Math.sin(y- (t/2));
	 	       //1.12 player.getWorld().spawnParticle(Particle.SPELL_WITCH,new Location(player.getWorld(), (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z)),1,0,0,0,0);
	 	       //1.12 player.getWorld().spawnParticle(Particle.SPELL_WITCH,new Location(player.getWorld(), (float) (loc.getX() - x), (float) (loc.getY() + y), (float) (loc.getZ() - z)),1,0,0,0,0);
	 	        player.getWorld().playEffect(new Location(player.getWorld(), (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z)), effect, 0);
	 	        player.getWorld().playEffect(new Location(player.getWorld(), (float) (loc.getX() - x), (float) (loc.getY() + y), (float) (loc.getZ() - z)), effect, 0);

	 	    }
	    	
	    }}.runTaskTimer(ins, 20, 5);
	   
	}
	
	
	/*public static Particle randParticle() {
        Random r = new Random();
        int rNumb = r.nextInt(5) + 1;
        if(rNumb == 1)
            return Particle.FIREWORKS_SPARK;
        else if(rNumb == 2)
            return Particle.VILLAGER_HAPPY;
        else if(rNumb == 3)
            return Particle.SPELL_WITCH;
        else if(rNumb == 4)
            return Particle.FLAME;
        else if(rNumb == 5) {
            return Particle.BLOCK_CRACK;
        }
        return null;
    }*/
}
