package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BossPoisonSw implements Listener {

	static ItemStack sword = com.gmail.eduardokanp.anniboss.Main.sword();
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getEntityType() == EntityType.PLAYER) {
			if(e.getDamager().getType() == EntityType.PLAYER) {
				Player v = (Player) e.getEntity();
				Player c = (Player) e.getDamager();
				if(c.getInventory().getItemInHand().equals(sword)) {
					v.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 120, 1));
				}
			}
		}
	}
}
