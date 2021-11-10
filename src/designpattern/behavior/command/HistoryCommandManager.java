package designpattern.behavior.command;

import java.util.Vector;

public class HistoryCommandManager {
	Vector UndoList=new Vector();
	Vector RedoList=new Vector();
	public void storeCommand(Command cmd){
		UndoList.add(cmd);
	}
	public void clearAllCommand(){
		UndoList.clear();
		RedoList.clear();
	}
	public void undo(){
		if ( UndoList.size() <= 0 ) return;
		Command cmd = ((Command)(UndoList.get(UndoList.size()-1)));
		cmd.undo();
		UndoList.remove(cmd);
		RedoList.add(cmd);
	}
	public void redo(){
		if ( RedoList.size() <= 0 ) return;
		Command cmd = ((Command)(RedoList.get(RedoList.size()-1)));
		cmd.execute();
		RedoList.remove(cmd);
		UndoList.add(cmd);
	}
}
