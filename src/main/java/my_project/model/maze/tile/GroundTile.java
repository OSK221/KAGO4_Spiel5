package my_project.model.maze.tile;

import my_project.model.maze.TileBase;

public class GroundTile extends TileBase {

    public GroundTile(double x, double y) {
        super(x, y,"ground", 0,255,0, false);
    }
}