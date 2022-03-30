package my_project.model.maze.tile;

import my_project.model.maze.TileBase;

public class WallTile extends TileBase {

    public WallTile(double x, double y) {
        super(x, y,"wall", "Wall.png");
    }

}