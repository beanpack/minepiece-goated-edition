package net.mcreator.minepiecegoatededition.procedures;

import net.minecraftforge.eventbus.api.Event;

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