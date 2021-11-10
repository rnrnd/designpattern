package designpattern.creation.builder;

public interface Builder {
	Builder buildFort();
	Builder buildWall();
	Builder buildMine();
	Terrain build();
}
