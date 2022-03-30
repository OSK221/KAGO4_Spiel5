package my_project.model.maze.tile;

import my_project.model.maze.TileBase;

public class BlockTile extends TileBase {

    public BlockTile(double x, double y) {
        super(x, y,"block","Block.png");
    }

    @Override
    public void update(double dt) {

    }
}
