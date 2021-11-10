package designpattern.behavior.command;

public class Invoker {
	private HistoryCommandManager commandManager = new HistoryCommandManager();
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action(){
		command.execute();
		commandManager.storeCommand(command);
	}
}
