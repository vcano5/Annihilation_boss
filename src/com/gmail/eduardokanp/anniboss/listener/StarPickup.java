package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.gmail.lynx7478.anni.anniGame.AnniPlayer;

public class StarPickup implements Listener {	
	
	static Plugin plugin;
	
	static ItemStack wStar = com.gmail.eduardokanp.anniboss.Main.wStar();
	static ItemStack Star = com.gmail.eduardokanp.anniboss.Main.star();
		
	@EventHandler
	public void onStarPickup(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if(e.getItem().equals(wStar)) {
			new java.util.Timer().schedule( 
					new java.util.TimerTask() {
					@Override
					    public void run() {
					      	for(int i = 1; i <= 36; i++) {
					   			if(p.getInventory().getItem(i).equals(wStar)) {
					   				p.getInventory().remove(wStar);
					   				for(Player p2: Bukkit.getOnlinePlayers()) {
					   					if(AnniPlayer.getPlayer(p.getUniqueId()).getTeam() == AnniPlayer.getPlayer(p2.getUniqueId()).getTeam()) {
					   						p2.getInventory().addItem(Star);
					        					}
					        				}
					        			} else {
					        				
					        			}
					        		}
					            }
					        }, 
					        50 
					);
		}
	}
}
