package net.mcreator.minepiecegoatededition.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.command.FunctionObject;

import java.util.Optional;

public class DarkRootRemoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote() && _ent.world.getServer() != null) {
				Optional<FunctionObject> _fopt = _ent.world.getServer().getFunctionManager().get(new ResourceLocation("removedf"));
				if (_fopt.isPresent())
					_ent.world.getServer().getFunctionManager().execute(_fopt.get(), _ent.getCommandSource());
			}
		}
	}
}
