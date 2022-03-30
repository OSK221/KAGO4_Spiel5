package my_project.model.maze.tile;

import my_project.model.maze.TileBase;

public class WaterTile extends TileBase {

    public WaterTile(double x, double y) {
        super(x, y, "water", 0, 150,255);
    }
}
