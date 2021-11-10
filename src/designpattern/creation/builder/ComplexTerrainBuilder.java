package designpattern.creation.builder;

public class ComplexTerrainBuilder implements Builder{
	Terrain terrain = new Terrain();
	@Override
	public Builder buildFort() {
		terrain.f = new Fort();
		return this;
	}

	@Override
	public Builder buildWall() {
		terrain.w = new Wall();
		return this;
	}

	@Override
	public Builder buildMine() {
		terrain.m = new Mine();
		return this;
	}

	@Override
	public Terrain build() {
		return terrain;
	}
}
